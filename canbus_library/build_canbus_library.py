#!/usr/bin/env python3
"""Builds a canbus library for the FYT launcher: the screen class of every car, the requests of its
fuel/range screens and the codes of its fuel consumption and range.

    py build_canbus_library.py <src> [--out FILE] [--mapping FILE]   from a decompiled com.syu.canbus
    py build_canbus_library.py --launcher <repo> [--out FILE]        the library built into the launcher
                                                                     (classes from its asset, pages from decompiled_carinfo/)
    py build_canbus_library.py --seal FILE                           recomputes the footer of an edited file
    py build_canbus_library.py --check FILE                          validates a file like the launcher does
    py build_canbus_library.py --diff A B [--ids 1507667,163]        what differs between two library files
    py build_canbus_library.py --merge BASE FILE [--out OUT]         BASE merged with FILE like the launcher's import

Format (version 2; version 1 files, without S records, are still read; the full description is in README.md next to this script):

    canbus_library 2
    C <ids> | <class> [| <alt> | portrait | fytver:<tok>,...]     screen class of the cars
    R <ids> | <page> | <cmd>[:<i>,...]; ...                        a fuel page and the requests it sends
    N <ids>                                                        the cars need no request
    S <ids> | <fuel> | <range>                                     codes 0..1199 or "-": fuel consumption and range
    end <records> <crc32>

Python 3.8+, standard library only.
Exit code: 0 success, 1 bad input, 2 an invalid file in --check, --diff or --merge, 3 differences found by --diff.
"""
import argparse
import collections
import datetime
import itertools
import pathlib
import re
import sys
import zlib

HEADER = 'canbus_library 2'
MAX_CODE = 1199
MAX_BYTES = 2 * 1024 * 1024
MAX_LINES = 200000
MAX_ERRORS = 200
MAX_IDS_PER_LINE = 5000
MAX_PAGES_PER_ID = 10
MAX_REQS_PER_LINE = 8
MAX_INTS = 8
CLASS_RE = re.compile(r'com\.syu(\.[A-Za-z_$][A-Za-z0-9_$]*)+')
TOKEN_RE_FYTVER = re.compile(r'[A-Za-z0-9]{1,16}')
PAGE_NAME_RE = re.compile(r'(?i)(oil|mile|trip|fuel|consum|drivinginfo)')
FYTVER_PATH = '/sys/fytver/fyt_bin_version'
# the role of a method of a fuel page, decided by its name: the fuel consumption now and the range
FUEL_NAME_RE = re.compile(r'(?i)(oil|fuel).*(expend|consum|cost)|consum.*(oil|fuel)|cur.*oil')
FUEL_NOT_RE = re.compile(r'(?i)ave|avg|average|history|total|trip|unit|max|min|mark')
RANGE_NAME_RE = re.compile(r'(?i)driving.?mile|drivable|drivenable|remain|endurance|range|last.?mile|can.?run')
RANGE_NOT_RE = re.compile(r'(?i)total|trip|unit|history|dived|driven')
DATA_CODE_RE = re.compile(r'\bDATA\s*\[\s*([0-9]+)\s*\]')
METHOD_RE = re.compile(r'\b(\w+)\s*\(([^()]*)\)\s*(?:throws\s+[\w.,\s]+)?\{')
ELECTRIC_WORDS = frozenset(('ev', 'electric', 'battery'))
NOT_METHODS = frozenset(('if', 'for', 'while', 'switch', 'catch', 'synchronized', 'try', 'return', 'new', 'else'))


# --------------------------------------------------------------------------------------------------
# Java lexer
# --------------------------------------------------------------------------------------------------

TOKEN_RE = re.compile(r'''
    (?P<ws>\s+)
  | (?P<lc>//[^\n]*)
  | (?P<bc>/\*.*?\*/)
  | (?P<str>"(?:\\.|[^"\\\n])*")
  | (?P<chr>'(?:\\.|[^'\\\n])*')
  | (?P<num>0[xX][0-9a-fA-F]+[lL]?|[0-9]+[lL]?)
  | (?P<id>[A-Za-z_$][A-Za-z0-9_$]*)
  | (?P<op>->|==|!=|<=|>=|&&|\|\||[^\s])
''', re.X | re.S)


class Tok:
    __slots__ = ('kind', 'text', 'line')

    def __init__(self, kind, text, line):
        self.kind = kind
        self.text = text
        self.line = line

    def __repr__(self):
        return '%s:%r@%d' % (self.kind, self.text, self.line)


def lex(text):
    """Tokens of a Java source: no whitespace and no line comments; block comments are kept (the car ids
    of the case labels are in them)."""
    out = []
    line = 1
    pos = 0
    n = len(text)
    while pos < n:
        m = TOKEN_RE.match(text, pos)
        if m is None:
            pos += 1
            continue
        kind = m.lastgroup
        chunk = m.group(0)
        if kind not in ('ws', 'lc'):
            out.append(Tok(kind, chunk, line))
        line += chunk.count('\n')
        pos = m.end()
    return out


def mask_java(text):
    """The source with comments and the insides of strings and chars blanked out (same length, newlines
    kept), so that braces and parentheses can be counted."""
    out = []
    pos = 0
    n = len(text)
    while pos < n:
        m = TOKEN_RE.match(text, pos)
        if m is None:
            out.append(text[pos])
            pos += 1
            continue
        kind = m.lastgroup
        chunk = m.group(0)
        if kind in ('lc', 'bc'):
            out.append(re.sub(r'[^\n]', ' ', chunk))
        elif kind in ('str', 'chr'):
            out.append(chunk[0] + re.sub(r'[^\n]', ' ', chunk[1:-1]) + chunk[-1])
        else:
            out.append(chunk)
        pos = m.end()
    return ''.join(out)


def parse_java_int(text):
    t = text.strip()
    m = re.fullmatch(r'(-?)(0[xX][0-9a-fA-F]+|[0-9]+)[lL]?', t)
    if not m:
        return None
    v = int(m.group(2), 16) if m.group(2)[:2] in ('0x', '0X') else int(m.group(2))
    return -v if m.group(1) else v


# --------------------------------------------------------------------------------------------------
# The switch: tokens -> statements
# --------------------------------------------------------------------------------------------------

class Stmt:
    __slots__ = ('kind', 'value', 'line', 'then', 'orelse', 'cond', 'label')

    def __init__(self, kind, line, value=None, label=None, cond=None, then=None, orelse=None):
        self.kind = kind          # case, default, assign, break, return, if, block, other
        self.line = line
        self.value = value        # case: the id (or None); assign: (what, value)
        self.label = label        # case: the text of the label
        self.cond = cond          # if: the tokens of the condition
        self.then = then
        self.orelse = orelse


class SwitchParser:
    def __init__(self, toks, consts, warn):
        self.t = toks
        self.i = 0
        self.consts = consts
        self.warn = warn

    def peek(self, k=0):
        j = self.i + k
        return self.t[j] if j < len(self.t) else None

    def is_op(self, tok, text):
        return tok is not None and tok.kind == 'op' and tok.text == text

    def skip_comments(self):
        while self.peek() is not None and self.peek().kind == 'bc':
            self.i += 1

    def parse_list(self, until_close=True):
        out = []
        while True:
            self.skip_comments()
            tok = self.peek()
            if tok is None:
                break
            if until_close and self.is_op(tok, '}'):
                break
            out.append(self.parse_stmt())
        return out

    def parse_body_or_stmt(self):
        self.skip_comments()
        if self.is_op(self.peek(), '{'):
            self.i += 1
            body = self.parse_list()
            self.skip_comments()
            if self.is_op(self.peek(), '}'):
                self.i += 1
            return body
        return [self.parse_stmt()]

    def collect_until(self, stop_ops):
        """Tokens up to (not including) a stop op at nesting depth 0; the stop is not consumed."""
        out = []
        depth = 0
        while True:
            tok = self.peek()
            if tok is None:
                return out
            if tok.kind == 'op':
                if depth == 0 and tok.text in stop_ops:
                    return out
                if tok.text in '({[':
                    depth += 1
                elif tok.text in ')}]':
                    depth -= 1
            out.append(tok)
            self.i += 1

    def parse_stmt(self):
        tok = self.peek()
        line = tok.line
        if tok.kind == 'id' and tok.text == 'case':
            self.i += 1
            label = self.collect_until((':',))
            if self.is_op(self.peek(), ':'):
                self.i += 1
            return Stmt('case', line, value=self.case_value(label), label=' '.join(x.text for x in label))
        if tok.kind == 'id' and tok.text == 'default':
            self.i += 1
            if self.is_op(self.peek(), ':'):
                self.i += 1
            return Stmt('default', line)
        if tok.kind == 'id' and tok.text == 'if':
            self.i += 1
            cond = []
            if self.is_op(self.peek(), '('):
                self.i += 1
                cond = self.collect_until((')',))
                if self.is_op(self.peek(), ')'):
                    self.i += 1
            then = self.parse_body_or_stmt()
            orelse = None
            self.skip_comments()
            nxt = self.peek()
            if nxt is not None and nxt.kind == 'id' and nxt.text == 'else':
                self.i += 1
                orelse = self.parse_body_or_stmt()
            return Stmt('if', line, cond=cond, then=then, orelse=orelse)
        if self.is_op(tok, '{'):
            return Stmt('block', line, then=self.parse_body_or_stmt())
        if tok.kind == 'id' and tok.text == 'break':
            self.collect_until((';',))
            self.i += 1
            return Stmt('break', line)
        if tok.kind == 'id' and tok.text == 'return':
            self.collect_until((';',))
            self.i += 1
            return Stmt('return', line)
        if tok.kind == 'id' and tok.text in ('cls', 'name') and self.is_op(self.peek(1), '=') \
                and not self.is_op(self.peek(2), '='):
            self.i += 2
            rhs = self.collect_until((';',))
            if self.is_op(self.peek(), ';'):
                self.i += 1
            return Stmt('assign', line, value=self.assign_value(tok.text, rhs, line))
        # anything else: up to the end of the statement (with its blocks)
        self.collect_until((';', '{'))
        nxt = self.peek()
        if self.is_op(nxt, '{'):
            self.i += 1
            self.parse_list()
            if self.is_op(self.peek(), '}'):
                self.i += 1
        elif self.is_op(nxt, ';'):
            self.i += 1
        else:
            self.i += 1
        return Stmt('other', line)

    def case_value(self, label):
        for tok in label:
            if tok.kind == 'bc':
                m = re.fullmatch(r'/\*\s*(-?\d+)\s*\*/', tok.text)
                if m:
                    return int(m.group(1))
        ids = [x for x in label if x.kind != 'bc']
        if len(ids) == 1 and ids[0].kind == 'num':
            return parse_java_int(ids[0].text)
        if len(ids) == 2 and self.is_op(ids[0], '-') and ids[1].kind == 'num':
            v = parse_java_int(ids[1].text)
            return -v if v is not None else None
        if ids and ids[-1].kind == 'id':
            name = ids[-1].text
            if name in self.consts:
                return self.consts[name]
        self.warn(label[0].line if label else 0, 'unresolved case label "%s"' % ' '.join(x.text for x in label))
        return None

    def assign_value(self, var, rhs, line):
        rhs = [x for x in rhs if x.kind != 'bc']
        if len(rhs) == 1 and rhs[0].kind == 'str':
            return ('name', bytes(rhs[0].text[1:-1], 'utf-8').decode('unicode_escape'))
        # (Class<?>) a.b.X.class or X.class
        j = 0
        if rhs and self.is_op(rhs[0], '('):
            depth = 0
            while j < len(rhs):
                if self.is_op(rhs[j], '('):
                    depth += 1
                elif self.is_op(rhs[j], ')'):
                    depth -= 1
                    if depth == 0:
                        j += 1
                        break
                j += 1
        rest = rhs[j:]
        if len(rest) >= 3 and rest[-1].kind == 'id' and rest[-1].text == 'class' and self.is_op(rest[-2], '.'):
            parts = [x.text for x in rest[:-2]]
            if parts and all((k % 2 == 0 and rest[k].kind == 'id') or (k % 2 == 1 and rest[k].text == '.')
                             for k in range(len(parts))):
                return ('class', ''.join(parts))
        return ('other', None)


# --------------------------------------------------------------------------------------------------
# Conditions
# --------------------------------------------------------------------------------------------------

class CondEval:
    """Evaluates the conditions of the switch for one combination (portrait, fytver matches)."""

    PORTRAIT_RE = re.compile(r'(?:\w+\.)*(?:TheApp|LauncherApplication)\.getConfiguration\(\)(==|!=)1')
    PORTRAIT2_RE = re.compile(r'(?:\w+\.)*isPortrait\(\)')
    FYTVER_RE = re.compile(r'readFile\("' + re.escape(FYTVER_PATH) + r'"\)\.contains\("([^"]*)"\)')

    def __init__(self, warn):
        self.warn = warn
        self.tokens = []

    def evaluate(self, cond, portrait, fytver):
        self.toks = [x for x in cond if x.kind != 'bc']
        self.p = 0
        self.portrait = portrait
        self.fytver = fytver
        self.line = self.toks[0].line if self.toks else 0
        value = self.parse_or()
        return value

    def peek(self):
        return self.toks[self.p] if self.p < len(self.toks) else None

    def parse_or(self):
        v = self.parse_and()
        while self.peek() is not None and self.peek().text == '||':
            self.p += 1
            r = self.parse_and()
            v = v or r
        return v

    def parse_and(self):
        v = self.parse_not()
        while self.peek() is not None and self.peek().text == '&&':
            self.p += 1
            r = self.parse_not()
            v = v and r
        return v

    def parse_not(self):
        tok = self.peek()
        if tok is not None and tok.kind == 'op' and tok.text == '!':
            self.p += 1
            return not self.parse_not()
        if tok is not None and tok.kind == 'op' and tok.text == '(':
            # a parenthesised group, or the start of an atom such as (x).foo()
            start = self.p
            depth = 0
            j = self.p
            while j < len(self.toks):
                if self.toks[j].text == '(':
                    depth += 1
                elif self.toks[j].text == ')':
                    depth -= 1
                    if depth == 0:
                        break
                j += 1
            inner = self.toks[start + 1:j]
            after = self.toks[j + 1] if j + 1 < len(self.toks) else None
            if after is None or after.text in ('||', '&&', ')'):
                self.p = j + 1
                sub = CondEval(self.warn)
                sub.tokens = self.tokens
                v = sub.evaluate(inner, self.portrait, self.fytver)
                return v
        return self.parse_atom()

    def parse_atom(self):
        depth = 0
        start = self.p
        while self.p < len(self.toks):
            t = self.toks[self.p]
            if t.text == '(':
                depth += 1
            elif t.text == ')':
                if depth == 0:
                    break
                depth -= 1
            elif depth == 0 and t.text in ('||', '&&'):
                break
            self.p += 1
        atom = self.toks[start:self.p]
        text = ''.join(x.text for x in atom)
        m = self.PORTRAIT_RE.fullmatch(text)
        if m:
            return self.portrait if m.group(1) == '==' else not self.portrait
        if self.PORTRAIT2_RE.fullmatch(text):
            return self.portrait
        m = self.FYTVER_RE.fullmatch(text)
        if m:
            tok = m.group(1)
            if tok not in self.tokens:
                self.tokens.append(tok)
            return self.fytver
        self.warn(atom[0].line if atom else self.line, 'unrecognised condition "%s" taken as false' % text)
        return False


# --------------------------------------------------------------------------------------------------
# Mapping: the switch of ActivityLauncher.launchCanbus()
# --------------------------------------------------------------------------------------------------

def read_text(path):
    return pathlib.Path(path).read_text(encoding='utf-8', errors='replace')


def find_matching(toks, i, open_op, close_op):
    depth = 0
    for j in range(i, len(toks)):
        if toks[j].kind == 'op':
            if toks[j].text == open_op:
                depth += 1
            elif toks[j].text == close_op:
                depth -= 1
                if depth == 0:
                    return j
    return None


def find_switches(toks):
    """(index of the header's first token, index of the opening brace, index of the closing brace, header text)."""
    out = []
    for i, t in enumerate(toks):
        if t.kind == 'id' and t.text == 'switch' and i + 1 < len(toks) and toks[i + 1].text == '(':
            j = find_matching(toks, i + 1, '(', ')')
            if j is None or j + 1 >= len(toks) or toks[j + 1].text != '{':
                continue
            k = find_matching(toks, j + 1, '{', '}')
            if k is None:
                continue
            header = ''.join(x.text for x in toks[i + 2:j])
            out.append((i, j + 1, k, header))
    return out


def count_pairs(toks, a, b):
    """Case labels followed by an assignment of a class: the size of a mapping switch."""
    n = 0
    for i in range(a, b):
        t = toks[i]
        if t.kind == 'id' and t.text in ('cls', 'name') and i + 1 < b and toks[i + 1].text == '=':
            n += 1
    return n


def load_constants(final_canbus_path):
    consts = {}
    if final_canbus_path and pathlib.Path(final_canbus_path).is_file():
        for m in re.finditer(r'public\s+static\s+final\s+int\s+(\w+)\s*=\s*(-?(?:0[xX][0-9a-fA-F]+|[0-9]+))\s*;',
                             read_text(final_canbus_path)):
            consts[m.group(1)] = parse_java_int(m.group(2))
    return consts


class Mapping:
    """ids -> {(portrait, fytver): class reference}, as simulated from the switch."""

    def __init__(self):
        self.source = ''
        self.method = ''
        self.results = {}       # id -> {(portrait, fytver): ('class'|'name', value) or None}
        self.fytver_tokens = {}  # id -> [tokens]
        self.warnings = []
        self.unresolved = 0


def build_mapping(path, consts, label):
    """The best switch of the file (the one on DataCanbus.DATA[1000] if there is one)."""
    text = read_text(path)
    toks = lex(text)
    switches = find_switches(toks)
    chosen = None
    best = -1
    for sw in switches:
        score = count_pairs(toks, sw[1], sw[2])
        if 'DataCanbus.DATA[1000]' in sw[3]:
            score += 1000000
        if score > best and count_pairs(toks, sw[1], sw[2]) > 0:
            best = score
            chosen = sw
    method = None
    if chosen is not None:
        for i in range(chosen[0], 0, -1):
            t = toks[i]
            if t.kind == 'id' and i + 1 < len(toks) and toks[i + 1].text == '(' and i > 0 \
                    and toks[i - 1].kind == 'id' and toks[i - 1].text in ('void', 'String', 'int', 'Class', 'boolean'):
                method = t.text
                break
    if chosen is None:
        return None
    m = Mapping()
    m.source = label
    m.method = method or '?'

    def warn(line, msg):
        m.warnings.append('%s:%d: %s' % (label, line, msg))

    body = toks[chosen[1] + 1:chosen[2]]
    parser = SwitchParser(body, consts, warn)
    stmts = parser.parse_list(until_close=False)
    labels = collections.OrderedDict()
    for idx, s in enumerate(stmts):
        if s.kind == 'case' and s.value is not None:
            if s.value in labels:
                warn(s.line, 'id %d appears twice in the switch' % s.value)
            else:
                labels[s.value] = idx

    seen_warn = set()

    def warn_once(line, msg):
        key = (line, msg)
        if key not in seen_warn:
            seen_warn.add(key)
            warn(line, msg)

    for cid, start in labels.items():
        per = {}
        tokens = []
        for portrait, fytver in itertools.product((False, True), (False, True)):
            ev = CondEval(warn_once)
            ev.tokens = tokens
            state = {'value': None}

            def run(seq, from_index=0):
                for s in seq[from_index:]:
                    kind = s.kind
                    if kind == 'assign':
                        what, value = s.value
                        if what != 'other':
                            state['value'] = (what, value)
                    elif kind == 'break' or kind == 'return':
                        return True
                    elif kind == 'if':
                        if ev.evaluate(s.cond, portrait, fytver):
                            if run(s.then):
                                return True
                        elif s.orelse is not None:
                            if run(s.orelse):
                                return True
                    elif kind == 'block':
                        if run(s.then):
                            return True
                return False

            run(stmts, start + 1)
            per[(portrait, fytver)] = state['value']
        m.results[cid] = per
        m.fytver_tokens[cid] = list(tokens)
    m.warnings = list(dict.fromkeys(m.warnings))
    return m


# --------------------------------------------------------------------------------------------------
# Sources: classes, references and the requests of the fuel pages
# --------------------------------------------------------------------------------------------------

class Source:
    def __init__(self, fqcn, path):
        self.fqcn = fqcn
        self.path = path
        self._text = None
        self._masked = None
        self._package = None
        self._imports = None
        self._refs = None
        self._requests = None
        self._codes = None

    @property
    def text(self):
        if self._text is None:
            self._text = read_text(self.path)
        return self._text

    @property
    def masked(self):
        if self._masked is None:
            self._masked = mask_java(self.text)
        return self._masked

    @property
    def simple(self):
        return self.fqcn.rsplit('.', 1)[-1]

    @property
    def package(self):
        return self.fqcn.rsplit('.', 1)[0] if '.' in self.fqcn else ''

    @property
    def imports(self):
        if self._imports is None:
            single, wild = {}, []
            for m in re.finditer(r'^\s*import\s+(?:static\s+)?([\w.]+?)(\.\*)?\s*;', self.masked, re.M):
                if m.group(2):
                    wild.append(m.group(1))
                else:
                    single[m.group(1).rsplit('.', 1)[-1]] = m.group(1)
            self._imports = (single, wild)
        return self._imports


class SourceIndex:
    def __init__(self, root):
        self.root = pathlib.Path(root)
        self.by_fqcn = {}
        self.by_simple = collections.defaultdict(list)
        for p in sorted(self.root.rglob('*.java')):
            rel = p.relative_to(self.root).as_posix()
            parts = rel[:-5].split('/')
            if 'com' in parts:
                fq = '.'.join(parts[parts.index('com'):])
            else:
                fq = '.'.join(parts)
            if fq in self.by_fqcn:
                continue
            src = Source(fq, p)
            self.by_fqcn[fq] = src
            self.by_simple[src.simple].append(src)
        self.refs_cache = {}

    def resolve(self, name, context):
        """The Source for a class reference `name` (simple or qualified) seen in `context`, or None."""
        if '.' in name:
            if name in self.by_fqcn:
                return self.by_fqcn[name]
            name = name.rsplit('.', 1)[-1]
        single, wild = context.imports
        if name in single and single[name] in self.by_fqcn:
            return self.by_fqcn[single[name]]
        same = context.package + '.' + name
        if same in self.by_fqcn:
            return self.by_fqcn[same]
        for w in wild:
            if w + '.' + name in self.by_fqcn:
                return self.by_fqcn[w + '.' + name]
        cands = self.by_simple.get(name, [])
        if len(cands) == 1:
            return cands[0]
        return None

    def ambiguous(self, name, context):
        return len(self.by_simple.get(name, [])) > 1

    def refs(self, src):
        """Classes of the sources that `src` refers to with X.class."""
        if src.fqcn in self.refs_cache:
            return self.refs_cache[src.fqcn]
        out = []
        for m in re.finditer(r'\b((?:[a-z]\w*\.)*[A-Z]\w*)\.class\b', src.masked):
            target = self.resolve(m.group(1), src)
            if target is not None and target.fqcn != src.fqcn and target.fqcn not in out:
                out.append(target.fqcn)
        self.refs_cache[src.fqcn] = out
        return out


def match_close(masked, open_pos, open_ch, close_ch):
    depth = 0
    for i in range(open_pos, len(masked)):
        c = masked[i]
        if c == open_ch:
            depth += 1
        elif c == close_ch:
            depth -= 1
            if depth == 0:
                return i
    return -1


def blank_nested(body):
    """The method body without anonymous classes and lambdas (replaced by spaces)."""
    chars = list(body)
    n = len(body)

    def blank(a, b):
        for k in range(a, b):
            if chars[k] != '\n':
                chars[k] = ' '

    # anonymous classes: new X(...) { ... }
    for m in re.finditer(r'\bnew\s+[\w.]+(?:<[^>()]*>)?\s*\(', body):
        op = m.end() - 1
        cl = match_close(body, op, '(', ')')
        if cl < 0:
            continue
        j = cl + 1
        while j < n and body[j].isspace():
            j += 1
        if j < n and body[j] == '{':
            end = match_close(body, j, '{', '}')
            if end > 0:
                blank(j, end + 1)
    text = ''.join(chars)
    chars = list(text)
    # lambdas: ... -> { ... }  or  ... -> expression
    for m in re.finditer(r'->', text):
        j = m.end()
        while j < n and text[j].isspace():
            j += 1
        if j < n and text[j] == '{':
            end = match_close(text, j, '{', '}')
            if end > 0:
                blank(j, end + 1)
        else:
            depth = 0
            k = j
            while k < n:
                c = text[k]
                if c in '({[':
                    depth += 1
                elif c in ')}]':
                    if depth == 0:
                        break
                    depth -= 1
                elif c in ',;' and depth == 0:
                    break
                k += 1
            blank(j, k)
    return ''.join(chars)


def split_args(text):
    out, depth, cur = [], 0, []
    for c in text:
        if c in '({[':
            depth += 1
        elif c in ')}]':
            depth -= 1
        if c == ',' and depth == 0:
            out.append(''.join(cur).strip())
            cur = []
        else:
            cur.append(c)
    last = ''.join(cur).strip()
    if last or out:
        out.append(last)
    return out


class Stats:
    def __init__(self):
        self.skipped_calls = []     # (class, method, text)
        self.dropped_dups = 0
        self.truncated = 0
        self.other_module = 0


def extract_requests(src, stats):
    """The requests a page sends directly in onCreate, onStart and onResume, in that order."""
    if src._requests is not None:
        return src._requests
    masked = src.masked
    depth_at = {}
    depth = 0
    # depth of the class body: the position of each '{' decides
    methods = {}
    for m in re.finditer(r'\b(onCreate|onStart|onResume)\s*\(([^()]*)\)\s*(?:throws\s+[\w.,\s]+)?\{', masked):
        # the depth at the start of the match
        pre = masked[:m.start()]
        d = pre.count('{') - pre.count('}')
        if d != 1:
            continue
        brace = m.end() - 1
        end = match_close(masked, brace, '{', '}')
        if end < 0:
            continue
        methods.setdefault(m.group(1), (brace, end))
    reqs = []
    for name in ('onCreate', 'onStart', 'onResume'):
        if name not in methods:
            continue
        a, b = methods[name]
        body = blank_nested(masked[a:b + 1])
        for m in re.finditer(r'((?:\w+\s*\.\s*)*)\bPROXY\s*\.\s*cmd\s*\(', body):
            prefix = re.sub(r'\s+', '', m.group(1))
            if prefix not in ('', 'DataCanbus.'):
                stats.other_module += 1
                continue
            op = m.end() - 1
            cl = match_close(body, op, '(', ')')
            if cl < 0:
                continue
            args = split_args(body[op + 1:cl])
            parsed = parse_cmd_args(args)
            if parsed is None:
                stats.skipped_calls.append((src.fqcn, name, 'cmd(' + ', '.join(args) + ')'))
                continue
            reqs.append(parsed)
    uniq = []
    for r in reqs:
        if r in uniq:
            stats.dropped_dups += 1
        else:
            uniq.append(r)
    if len(uniq) > MAX_REQS_PER_LINE:
        stats.truncated += 1
        uniq = uniq[:MAX_REQS_PER_LINE]
    src._requests = uniq
    return uniq


def is_electric_name(simple):
    """Whether a class name has an electric-car word: `EV`, `Electric` or `Battery` as a whole CamelCase word
    (`EVMile` yes, `Level` no)."""
    words = re.findall(r'[A-Z]+(?![a-z])|[A-Z][a-z]+|[a-z]+|[0-9]+', simple)
    return any(w.lower() in ELECTRIC_WORDS for w in words)


def extract_codes(src):
    """The fuel and range codes of a page, by the names of its methods: {'fuel': [(code, method)...], 'range': [...]}.
    The code of a method is the first DataCanbus.DATA[n] with n < 1000 in its body (1000 and above are general
    codes, such as the car id)."""
    if src._codes is not None:
        return src._codes
    masked = src.masked
    out = {'fuel': [], 'range': []}
    depth = 0
    last = 0
    for m in METHOD_RE.finditer(masked):
        name = m.group(1)
        if name in NOT_METHODS:
            continue
        depth += masked.count('{', last, m.start()) - masked.count('}', last, m.start())
        last = m.start()
        if depth != 1:
            continue
        brace = m.end() - 1
        end = match_close(masked, brace, '{', '}')
        if end < 0:
            continue
        # "drivenable" holds "driven", which the range rule leaves out
        role = None
        if FUEL_NAME_RE.search(name) and not FUEL_NOT_RE.search(name):
            role = 'fuel'
        elif RANGE_NAME_RE.search(name) and not RANGE_NOT_RE.search(re.sub(r'(?i)drivenable', '', name)):
            role = 'range'
        if role is None:
            continue
        for c in DATA_CODE_RE.finditer(masked, brace, end):
            if int(c.group(1)) < 1000:
                out[role].append((int(c.group(1)), name))
                break
    src._codes = out
    return out


def parse_cmd_args(args):
    """(cmd, (ints...)) for the forms the library has, or None for a call it cannot represent."""
    if not args or not args[0]:
        return None
    cmd = parse_java_int(args[0])
    if cmd is None or not 0 <= cmd <= 9999:
        return None
    n = len(args)
    ints = None
    if n == 1:
        ints = ()
    elif n == 4:
        if args[2] != 'null' or args[3] != 'null':
            return None
        a = args[1]
        if a == 'null':
            ints = ()
        else:
            m = re.fullmatch(r'new\s+int\s*\[\s*\]\s*\{(.*)\}', a, re.S)
            if m:
                inner = m.group(1).strip()
                items = split_args(inner) if inner else []
                if items and items[-1] == '':
                    items = items[:-1]
                vals = [parse_java_int(x) for x in items]
                if any(v is None for v in vals):
                    return None
                ints = tuple(vals)
            else:
                m = re.fullmatch(r'new\s+int\s*\[\s*([0-9]+)\s*\]', a)
                if not m:
                    return None
                ints = (0,) * int(m.group(1))
    elif n == 2:
        v = parse_java_int(args[1])
        if v is None:
            return None
        ints = (v,)
    elif n == 3:
        a, b = parse_java_int(args[1]), parse_java_int(args[2])
        if a is None or b is None:
            return None
        ints = (a, b)
    else:
        return None
    if len(ints) > MAX_INTS or any(not -65536 <= v <= 65536 for v in ints):
        return None
    return (cmd, ints)


def pair_text(pair):
    return '%s | %s' % tuple('-' if c is None else c for c in pair)


def pairs_text(pairs):
    return ' | '.join(pair_text(p) for p in pairs)


def req_text(req):
    cmd, ints = req
    if not ints:
        return str(cmd)
    return '%d:%s' % (cmd, ','.join(str(v) for v in ints))


# --------------------------------------------------------------------------------------------------
# The library: records, text, validation
# --------------------------------------------------------------------------------------------------

def crc_of_lines(lines):
    crc = 0
    for ln in lines:
        crc = zlib.crc32((ln + '\n').encode('utf-8'), crc)
    return crc & 0xFFFFFFFF


def seal_lines(lines):
    """`lines` (header ... last record, no footer) plus the footer."""
    records = sum(1 for ln in lines if ln[:2] in ('C ', 'R ', 'N ', 'S '))
    return lines + ['end %d %08x' % (records, crc_of_lines(lines))]


def parse_ids(text):
    if not re.fullmatch(r'\s*[0-9]+(\s*,\s*[0-9]+)*\s*', text):
        return None, 'ids must be decimal numbers separated by commas'
    ids = [int(x) for x in text.split(',')]
    if len(ids) > MAX_IDS_PER_LINE:
        return None, 'more than %d ids' % MAX_IDS_PER_LINE
    if any(not 1 <= v <= 2147483647 for v in ids):
        return None, 'an id outside 1..2147483647'
    if len(set(ids)) != len(ids):
        return None, 'an id repeated in the line'
    return ids, None


def parse_request(text):
    m = re.fullmatch(r'\s*([0-9]{1,6})(?::\s*(-?[0-9]+(?:\s*,\s*-?[0-9]+)*))?\s*', text)
    if not m:
        return None, 'bad request "%s"' % text.strip()
    cmd = int(m.group(1))
    if cmd > 9999:
        return None, 'cmd %d outside 0..9999' % cmd
    ints = ()
    if m.group(2) is not None:
        ints = tuple(int(x) for x in m.group(2).split(','))
        if len(ints) > MAX_INTS:
            return None, 'more than %d numbers in a request' % MAX_INTS
        if any(not -65536 <= v <= 65536 for v in ints):
            return None, 'a number outside -65536..65536'
    return (cmd, ints), None


class Checked:
    def __init__(self):
        self.errors = []          # (line, reason)
        self.classes = {}         # id -> (class, alt, cond, tokens)
        self.pages = {}           # id -> OrderedDict(page -> reqs)
        self.no_request = set()
        self.codes = {}           # id -> (pair, ...) in order of preference, a pair is (fuel, range), None = unknown
        self.version = 0
        self.records = 0
        self.dups = 0
        self.declared = None
        self.crc = None

    def err(self, line, reason):
        if len(self.errors) < MAX_ERRORS:
            self.errors.append((line, reason))


def check_text(raw):
    """Validates the file the way the launcher does. `raw` is bytes."""
    res = Checked()
    if len(raw) > MAX_BYTES:
        res.err(0, 'file larger than %d bytes' % MAX_BYTES)
        return res
    text = raw.decode('utf-8', errors='replace')
    if text.startswith('﻿'):
        text = text[1:]
    lines = text.split('\n')
    if lines and lines[-1] == '':
        lines.pop()
    if len(lines) > MAX_LINES:
        res.err(0, 'more than %d lines' % MAX_LINES)
        return res
    lines = [ln[:-1] if ln.endswith('\r') else ln for ln in lines]
    header_at = None
    footer_at = None
    for no, ln in enumerate(lines, 1):
        s = ln.strip()
        if footer_at is not None:
            if s:
                res.err(no, 'content after the footer')
            continue
        if not s or s.startswith('#'):
            continue
        if header_at is None:
            header_at = no
            hm = re.fullmatch(r'canbus_library\s+([12])', s)
            if not hm:
                res.err(no, 'missing or unsupported header (expected "canbus_library 1" or "canbus_library 2")')
                return res
            res.version = int(hm.group(1))
            continue
        m = re.fullmatch(r'end\s+([0-9]+)\s+([0-9a-f]{8})', s)
        if m:
            footer_at = no
            res.declared = int(m.group(1))
            res.crc = m.group(2)
            continue
        if re.match(r'end\b', s):
            res.err(no, 'bad footer (expected "end <records> <crc32>")')
            footer_at = no
            continue
        kind = s[0]
        if kind not in 'CRNS' or (len(s) > 1 and not s[1].isspace()):
            res.err(no, 'unknown record "%s"' % s[:20])
            continue
        res.records += 1
        fields = [f.strip() for f in s[1:].split('|')]
        ids, why = parse_ids(fields[0]) if fields else (None, 'missing ids')
        if why:
            res.err(no, why)
            continue
        if kind == 'N':
            if len(fields) != 1:
                res.err(no, 'N takes only ids')
                continue
            for i in ids:
                if i in res.pages:
                    res.err(no, 'id %d has both N and R records' % i)
                elif i in res.no_request:
                    res.dups += 1
                else:
                    res.no_request.add(i)
            continue
        if kind == 'C':
            if len(fields) not in (2, 4):
                res.err(no, 'C takes "ids | class" or "ids | class | alt | condition"')
                continue
            cls = fields[1]
            if not (CLASS_RE.fullmatch(cls) and len(cls) <= 200):
                res.err(no, 'bad class name "%s"' % cls[:60])
                continue
            alt, cond, toks = None, 'NONE', ()
            if len(fields) == 4:
                alt = fields[2]
                if alt != '-' and not (CLASS_RE.fullmatch(alt) and len(alt) <= 200):
                    res.err(no, 'bad alternative class "%s"' % alt[:60])
                    continue
                if alt == '-':
                    alt = ''
                c = fields[3]
                if c == 'portrait':
                    cond = 'PORTRAIT'
                elif c.startswith('fytver:'):
                    toks = tuple(x.strip() for x in c[7:].split(','))
                    if not 1 <= len(toks) <= 8 or any(not TOKEN_RE_FYTVER.fullmatch(x) for x in toks):
                        res.err(no, 'bad fytver tokens "%s"' % c[7:][:60])
                        continue
                    cond = 'FYTVER'
                else:
                    res.err(no, 'bad condition "%s" (portrait or fytver:tokens)' % c[:40])
                    continue
            rec = (cls, alt, cond, toks)
            for i in ids:
                old = res.classes.get(i)
                if old is None:
                    res.classes[i] = rec
                elif old == rec:
                    res.dups += 1
                else:
                    res.err(no, 'id %d has two different C records' % i)
            continue
        if kind == 'S':
            if res.version < 2:
                res.err(no, 'S records need version 2')
                continue
            if len(fields) != 3:
                res.err(no, 'S takes "ids | fuel code | range code"')
                continue
            pair, bad = [], False
            for f in fields[1:]:
                if f == '-':
                    pair.append(None)
                elif re.fullmatch(r'[0-9]{1,4}', f) and int(f) <= MAX_CODE:
                    pair.append(int(f))
                else:
                    res.err(no, 'bad code "%s" (0..%d or -)' % (f[:20], MAX_CODE))
                    bad = True
                    break
            if bad:
                continue
            if pair[0] is None and pair[1] is None:
                res.err(no, 'S with nothing to say ("- | -")')
                continue
            pairs = (tuple(pair),)
            for i in ids:
                old = res.codes.get(i)
                if old is None:
                    res.codes[i] = pairs
                elif old == pairs:
                    res.dups += 1
                else:
                    res.err(no, 'id %d has two different S records' % i)
            continue
        # R
        if len(fields) != 3:
            res.err(no, 'R takes "ids | page | requests"')
            continue
        page = fields[1]
        if not (CLASS_RE.fullmatch(page) and len(page) <= 200):
            res.err(no, 'bad page class "%s"' % page[:60])
            continue
        parts = fields[2].split(';')
        if not 1 <= len(parts) <= MAX_REQS_PER_LINE:
            res.err(no, 'R takes 1 to %d requests' % MAX_REQS_PER_LINE)
            continue
        reqs, bad = [], False
        for p in parts:
            r, why = parse_request(p)
            if why:
                res.err(no, why)
                bad = True
                break
            reqs.append(r)
        if bad:
            continue
        reqs = tuple(reqs)
        for i in ids:
            if i in res.no_request:
                res.err(no, 'id %d has both N and R records' % i)
                continue
            pages = res.pages.setdefault(i, collections.OrderedDict())
            if page in pages:
                if pages[page] == reqs:
                    res.dups += 1
                else:
                    res.err(no, 'id %d page %s has two different request lists' % (i, page.rsplit('.', 1)[-1]))
            elif len(pages) >= MAX_PAGES_PER_ID:
                res.err(no, 'id %d has more than %d pages' % (i, MAX_PAGES_PER_ID))
            else:
                pages[page] = reqs
    if header_at is None:
        res.err(0, 'empty file: missing header "canbus_library 1" or "canbus_library 2"')
    elif footer_at is None:
        res.err(len(lines), 'missing footer "end <records> <crc32>"')
    elif res.declared is not None:
        body = [ln for ln in lines[header_at - 1:footer_at - 1]]
        if res.declared != res.records:
            res.err(footer_at, 'footer says %d records, the file has %d' % (res.declared, res.records))
        actual = '%08x' % crc_of_lines(body)
        if actual != res.crc:
            res.err(footer_at, 'CRC32 mismatch: footer %s, computed %s' % (res.crc, actual))
    return res


# --------------------------------------------------------------------------------------------------
# Building
# --------------------------------------------------------------------------------------------------

def id_chunks(ids):
    for i in range(0, len(ids), MAX_IDS_PER_LINE):
        yield ids[i:i + MAX_IDS_PER_LINE]


def record_lines(class_records, no_request, pages_of, codes_of):
    """The C, N, R and S lines of a library, in the order the script writes them. `class_records`: id -> (class, alt,
    condition, tokens), `pages_of`: id -> [(page, requests)], `codes_of`: id -> (pair, ...), a pair is (fuel, range), None = unknown.
    Returns (lines, C lines, N lines, R lines, the pages used, S lines)."""
    out = []
    by_rec = collections.OrderedDict()
    for cid in sorted(class_records):
        by_rec.setdefault(class_records[cid], []).append(cid)
    c_lines = 0
    for rec, ids in sorted(by_rec.items(), key=lambda kv: kv[1][0]):
        cls, alt, cond, toks = rec
        for part in id_chunks(ids):
            ids_txt = ','.join(str(i) for i in part)
            if cond == 'NONE':
                out.append('C %s | %s' % (ids_txt, cls))
            elif cond == 'PORTRAIT':
                out.append('C %s | %s | %s | portrait' % (ids_txt, cls, alt or '-'))
            else:
                out.append('C %s | %s | %s | fytver:%s' % (ids_txt, cls, alt or '-', ','.join(toks)))
            c_lines += 1
    n_lines = 0
    for part in id_chunks(sorted(no_request)):
        out.append('N %s' % ','.join(str(i) for i in part))
        n_lines += 1
    r_lines = 0
    page_names = set()
    groups = collections.OrderedDict()
    for cid in sorted(pages_of):
        groups.setdefault(tuple(pages_of[cid]), []).append(cid)
    for sig, ids in sorted(groups.items(), key=lambda kv: kv[1][0]):
        for fq, reqs in sig:
            page_names.add(fq)
            for part in id_chunks(ids):
                out.append('R %s | %s | %s' % (','.join(str(i) for i in part), fq, '; '.join(req_text(r) for r in reqs)))
                r_lines += 1
    s_lines = 0
    by_codes = collections.OrderedDict()
    for cid in sorted(codes_of):
        by_codes.setdefault(codes_of[cid], []).append(cid)
    for pairs, ids in sorted(by_codes.items(), key=lambda kv: kv[1][0]):
        for part in id_chunks(ids):
            out.append('S %s | %s' % (','.join(str(i) for i in part), pairs_text(pairs)))
            s_lines += 1
    return out, c_lines, n_lines, r_lines, page_names, s_lines


def classify(per, tokens, cid, warn):
    """(class, alt, condition) for the 4 results of one id; condition 'NONE', 'PORTRAIT' or 'FYTVER'.
    class/alt None = no class."""
    ff, ft, tf, tt = per[(False, False)], per[(False, True)], per[(True, False)], per[(True, True)]
    if ff == ft == tf == tt:
        return ff, None, 'NONE'
    by_orientation = ff == ft and tf == tt
    by_fytver = ff == tf and ft == tt
    if by_orientation:
        return ff, tf, 'PORTRAIT'
    if by_fytver:
        return ff, ft, 'FYTVER'
    warn('id %d depends on both the orientation and the firmware; the library keeps the portrait alternative' % cid)
    return ff, tf, 'PORTRAIT'


def build(args, root, mapping_path, consts, label, index, out_path, log, asset=None):
    """`asset`: a Checked of the library built into the launcher. Its C and N records are taken as they are and
    only the pages are computed; otherwise the classes are simulated from the switch in `mapping_path`."""
    if asset is None:
        mapping = build_mapping(mapping_path, consts, label)
        if mapping is None:
            log('error: no switch with class assignments found in %s' % mapping_path)
            return 1
        log('Mapping: %s (method %s)' % (mapping.source, mapping.method))
        warnings = list(mapping.warnings)
        source_line = '# Source: %s (method %s)' % (mapping.source, mapping.method)
    else:
        mapping = None
        warnings = []
        log('Classes: %s' % label)
        source_line = '# Source: %s (classes) + decompiled_carinfo (pages)' % label

    def warn(msg):
        warnings.append(msg)

    # resolve the class references
    def resolve_ref(ref, cid):
        if ref is None:
            return None
        what, value = ref
        if what == 'name':
            if CLASS_RE.fullmatch(value) and len(value) <= 200:
                return value
            warn('id %d: class name "%s" is not a com.syu class, skipped' % (cid, value))
            return None
        src = index.resolve(value, ctx_src)
        if src is None:
            warn('id %d: cannot resolve %s.class, skipped' % (cid, value))
            return None
        if not (CLASS_RE.fullmatch(src.fqcn) and len(src.fqcn) <= 200):
            warn('id %d: %s is not a com.syu class, skipped' % (cid, src.fqcn))
            return None
        return src.fqcn

    # X.class references are resolved in the context of the file that holds the switch
    ctx_src = None
    if mapping is not None:
        pkg = re.search(r'^\s*package\s+([\w.]+)\s*;', read_text(mapping_path), re.M)
        ctx_src = Source((pkg.group(1) if pkg else '') + '.' + pathlib.Path(mapping_path).stem, mapping_path)
    class_records = {}   # id -> (cls, alt, cond, tokens)
    cond_counts = collections.Counter()
    no_request = set()
    if asset is not None:
        for cid in sorted(asset.classes):
            cls, alt, cond, toks = asset.classes[cid]
            class_records[cid] = (cls, alt or '', cond, tuple(toks)) if cond != 'NONE' else (cls, '', 'NONE', ())
            cond_counts[cond] += 1
        no_request = set(asset.no_request)
    for cid in sorted(mapping.results if mapping is not None else ()):
        per = {k: resolve_ref(v, cid) for k, v in mapping.results[cid].items()}
        cls, alt, cond = classify(per, mapping.fytver_tokens.get(cid, []), cid, warn)
        if cls is None:
            if alt is not None:
                warn('id %d: no class in the default combination but one in an alternative, no C record' % cid)
            continue
        toks = ()
        if cond == 'FYTVER':
            toks = tuple(mapping.fytver_tokens.get(cid, []))
            if not 1 <= len(toks) <= 8 or any(not TOKEN_RE_FYTVER.fullmatch(t) for t in toks):
                warn('id %d: unusable firmware tokens %r, condition dropped' % (cid, toks))
                alt, cond, toks = None, 'NONE', ()
        class_records[cid] = (cls, alt or '', cond, toks) if cond != 'NONE' else (cls, '', 'NONE', ())
        cond_counts[cond] += 1

    # pages and requests
    stats = Stats()
    reach_cache = {}

    def reach(fq):
        if fq in reach_cache:
            return reach_cache[fq]
        depth = {}
        src0 = index.by_fqcn.get(fq)
        if src0 is not None:
            depth[fq] = 0
            frontier = [fq]
            for d in range(1, 4):
                nxt = []
                for cur in frontier:
                    for ref in index.refs(index.by_fqcn[cur]):
                        if ref not in depth:
                            depth[ref] = d
                            nxt.append(ref)
                frontier = nxt
        reach_cache[fq] = depth
        return depth

    pages_of = {}
    page_keys = {}
    moved = {}       # id -> (the main page by the old key, the main page now)
    codes_of = {}    # id -> ((fuel, range),), None = unknown
    for cid, (cls, alt, cond, toks) in class_records.items():
        depth = {}
        for fq in (cls, alt):
            if fq:
                for k, d in reach(fq).items():
                    if k not in depth or d < depth[k]:
                        depth[k] = d
        low = cid & 0xFFFF

        def key(item):
            simple = item[0].rsplit('.', 1)[-1]
            found_codes = extract_codes(index.by_fqcn[item[0]])
            # the page named after the car first (as before), then the pages that give a fuel or range code, then the
            # pages of a combustion car, then the rest of the old rule
            return (('_%d_' % low) not in simple, not (found_codes['fuel'] or found_codes['range']),
                    is_electric_name(simple), 'Page1' not in simple, 'Index' not in simple, item[1], simple)

        candidates = [(fq, d) for fq, d in depth.items() if PAGE_NAME_RE.search(index.by_fqcn[fq].simple)]
        candidates.sort(key=key)
        # the codes: from the first page that gives each of them, whether or not it sends a request
        pair = [None, None]
        for fq, d in candidates:
            found_codes = extract_codes(index.by_fqcn[fq])
            for slot, role in ((0, 'fuel'), (1, 'range')):
                if pair[slot] is None and found_codes[role]:
                    pair[slot] = found_codes[role][0][0]
                    if len({c for c, _ in found_codes[role]}) > 1:
                        warn('%s: several %s codes %s, the first (%s) is used' % (
                            fq.rsplit('.', 1)[-1], role, ', '.join('%d (%s)' % cm for cm in found_codes[role]),
                            found_codes[role][0][1]))
        if pair != [None, None]:
            codes_of[cid] = (tuple(pair),)
        if cid in no_request:
            continue
        found = []
        for fq, d in candidates:
            reqs = extract_requests(index.by_fqcn[fq], stats)
            if reqs:
                found.append((fq, d, reqs))
        if not found:
            continue
        if len(found) > MAX_PAGES_PER_ID:
            warn('id %d: %d fuel pages, only the first %d kept' % (cid, len(found), MAX_PAGES_PER_ID))
            found = found[:MAX_PAGES_PER_ID]
        # the main page by the old key, without the fuel and the electric rules
        old_first = min(found, key=lambda it: key(it)[:1] + key(it)[3:])[0]
        if old_first != found[0][0]:
            moved[cid] = (old_first.rsplit('.', 1)[-1], found[0][0].rsplit('.', 1)[-1])
        pages_of[cid] = [(fq, tuple(reqs)) for fq, d, reqs in found]
        page_keys[cid] = [key(it) for it in found]

    # groups: ids with an identical list of pages
    groups = collections.OrderedDict()
    for cid in sorted(pages_of):
        sig = tuple(pages_of[cid])
        groups.setdefault(sig, []).append(cid)

    ambiguous_groups = []
    for sig, ids in groups.items():
        keys = page_keys[ids[0]]
        if len(keys) > 1 and keys[0][:5] == keys[1][:5]:
            tied = [sig[i][0].rsplit('.', 1)[-1] for i in range(len(keys)) if keys[i][:5] == keys[0][:5]]
            ambiguous_groups.append((ids, tied))

    # text
    out = [HEADER,
           '# Canbus library: the screen class of each car id and the requests of its fuel screens.',
           source_line,
           '# C: car ids and the class of their screen (optionally another class for a portrait screen or for a firmware).',
           '# R: car ids and a fuel page with the requests it sends when it opens, in order.',
           '# S: car ids and the codes of their fuel consumption and range (DataCanbus.DATA indices, - = unknown).',
           '# Cars with a class: %d, with a request: %d, request groups: %d, with fuel/range codes: %d' % (
               len(class_records), sum(len(v) for v in groups.values()), len(groups), len(codes_of))]

    body, c_lines, n_lines, r_lines, page_names, s_lines = record_lines(class_records, no_request, pages_of, codes_of)
    out.extend(body)
    sealed = seal_lines(out)
    pathlib.Path(out_path).parent.mkdir(parents=True, exist_ok=True)
    with open(out_path, 'w', encoding='utf-8', newline='\n') as f:
        f.write('\n'.join(sealed) + '\n')

    # the same checks as the launcher
    chk = check_text(pathlib.Path(out_path).read_bytes())
    if mapping is not None:
        log('IDs in the mapping: %d' % len(mapping.results))
    else:
        log('IDs in the library: %d with a class, %d marked N' % (len(class_records), len(no_request)))
    log('C records: %d lines for %d ids with a class (portrait: %d, firmware: %d)' % (
        c_lines, len(class_records), cond_counts['PORTRAIT'], cond_counts['FYTVER']))
    log('R records: %d lines; ids with a request: %d; groups: %d; pages: %d' % (
        r_lines, sum(len(v) for v in groups.values()), len(groups), len(page_names)))
    log('S records: %d lines; ids with both codes: %d, only fuel: %d, only range: %d' % (
        s_lines, sum(1 for v in codes_of.values() if None not in v[0]),
        sum(1 for v in codes_of.values() if v[0][1] is None), sum(1 for v in codes_of.values() if v[0][0] is None)))
    log('Requests: %d calls skipped (not literal or not representable), %d duplicate requests dropped, '
        '%d pages cut to %d requests, %d calls on other modules ignored' % (
            len(stats.skipped_calls), stats.dropped_dups, stats.truncated, MAX_REQS_PER_LINE, stats.other_module))
    for cls, method, text in stats.skipped_calls[:50]:
        log('  skipped in %s.%s: %s' % (cls.rsplit('.', 1)[-1], method, text[:100]))
    if len(stats.skipped_calls) > 50:
        log('  ... and %d more' % (len(stats.skipped_calls) - 50))
    log('Groups with an ambiguous main page: %d' % len(ambiguous_groups))
    for ids, tied in ambiguous_groups:
        log('  ids %s...: %s' % (','.join(str(i) for i in ids[:4]), ' / '.join(tied)))
    moved_groups = []
    for sig, ids in groups.items():
        changed = [i for i in ids if i in moved]
        if changed:
            moved_groups.append((ids, changed))
    log('main page changed by the fuel rule: %d groups (%d ids)' % (
        len(moved_groups), sum(len(c) for _, c in moved_groups)))
    for ids, changed in moved_groups:
        by_move = collections.Counter(moved[i] for i in changed)
        for (was, now), n in sorted(by_move.items()):
            log('  group of ids %s... (%d of %d ids): %s -> %s' % (
                ','.join(str(i) for i in ids[:3]), n, len(ids), was, now))
    warnings = list(dict.fromkeys(warnings))
    log('Warnings: %d' % len(warnings))
    for w in warnings[:200]:
        log('  ' + w)
    if len(warnings) > 200:
        log('  ... and %d more' % (len(warnings) - 200))
    if chk.errors:
        log('error: the file written does not validate:')
        for ln, why in chk.errors[:20]:
            log('  line %d: %s' % (ln, why))
        return 1
    log('Written: %s (%d records, footer ok)' % (pathlib.Path(out_path).resolve(), chk.records))
    return 0


# --------------------------------------------------------------------------------------------------
# Comparing and merging libraries
# --------------------------------------------------------------------------------------------------

DIFF_EXAMPLES = 50
MERGE_EXAMPLES = 20
EXIT_DIFFERENT = 3


def load_checked(path, log):
    """The Checked of a library file, or (None, exit code)."""
    p = pathlib.Path(path)
    if not p.is_file():
        log('error: %s is not a file' % path)
        return None, 1
    res = check_text(p.read_bytes())
    if res.errors:
        log('INVALID %s: %d error(s)' % (path, len(res.errors)))
        for ln, why in res.errors[:20]:
            log('  line %d: %s' % (ln, why))
        return None, 2
    return res, 0


def class_text(rec):
    cls, alt, cond, toks = rec
    if cond == 'NONE':
        return cls
    if cond == 'PORTRAIT':
        return '%s | %s | portrait' % (cls, alt or '-')
    return '%s | %s | fytver:%s' % (cls, alt or '-', ','.join(toks))


def requests_text(reqs):
    return '; '.join(req_text(r) for r in reqs)


def page_name(fq):
    return fq.rsplit('.', 1)[-1]


def diff_libraries(a, b):
    """The differences of two Checked libraries: {kind: {'a': [(key, value)], 'b': [...], 'diff': [(key, va, vb)]}}.
    Kinds: C (key = id), R (key = (id, page)), N, S (key = id) and `order` (key = id; the ids that have pages in both
    and keep a different main page or a different order of the pages they share)."""
    out = {}

    def compare(kind, ma, mb):
        only_a = sorted((k, ma[k]) for k in ma if k not in mb)
        only_b = sorted((k, mb[k]) for k in mb if k not in ma)
        changed = sorted((k, ma[k], mb[k]) for k in ma if k in mb and ma[k] != mb[k])
        out[kind] = {'a': only_a, 'b': only_b, 'diff': changed}

    compare('C', {i: class_text(r) for i, r in a.classes.items()}, {i: class_text(r) for i, r in b.classes.items()})
    compare('R', {(i, pg): requests_text(r) for i, ps in a.pages.items() for pg, r in ps.items()},
            {(i, pg): requests_text(r) for i, ps in b.pages.items() for pg, r in ps.items()})
    compare('N', {i: 'no request' for i in a.no_request}, {i: 'no request' for i in b.no_request})
    compare('S', {i: pairs_text(p) for i, p in a.codes.items()}, {i: pairs_text(p) for i, p in b.codes.items()})
    order = []
    for i in sorted(set(a.pages) & set(b.pages)):
        pa, pb = list(a.pages[i]), list(b.pages[i])
        common_a = [x for x in pa if x in b.pages[i]]
        common_b = [x for x in pb if x in a.pages[i]]
        if common_a != common_b or pa[0] != pb[0]:
            order.append((i, ' / '.join(page_name(x) for x in pa), ' / '.join(page_name(x) for x in pb)))
    out['order'] = {'a': [], 'b': [], 'diff': order}
    return out


def key_text(kind, key):
    if kind == 'R':
        return '%d %s' % (key[0], page_name(key[1]))
    return str(key)


def state_of(res, cid):
    """The lines that describe one car id in a library."""
    lines = []
    rec = res.classes.get(cid)
    lines.append('C  %s' % (class_text(rec) if rec else '(none)'))
    if cid in res.no_request:
        lines.append('N  no request')
    pages = res.pages.get(cid)
    if pages:
        for n, (pg, reqs) in enumerate(pages.items(), 1):
            lines.append('R%d %s | %s' % (n, pg, requests_text(reqs)))
    elif cid not in res.no_request:
        lines.append('R  (none)')
    codes = res.codes.get(cid)
    lines.append('S  %s' % (pairs_text(codes) if codes else '(none)'))
    return lines


def cmd_diff(path_a, path_b, ids_text, log):
    ids = []
    if ids_text:
        ids, why = parse_ids(ids_text)
        if why:
            log('error: --ids: %s' % why)
            return 1
    a, rc = load_checked(path_a, log)
    if a is None:
        return rc
    b, rc = load_checked(path_b, log)
    if b is None:
        return rc
    d = diff_libraries(a, b)
    log('A: %s (version %d)' % (path_a, a.version))
    log('B: %s (version %d)' % (path_b, b.version))
    total = 0
    log('%-22s %9s %9s %9s' % ('', 'only in A', 'only in B', 'different'))
    names = (('C', 'C classes (ids)'), ('R', 'R pages (id, page)'), ('N', 'N no request (ids)'),
             ('S', 'S codes (ids)'), ('order', 'R main page / order'))
    for kind, title in names:
        e = d[kind]
        total += len(e['a']) + len(e['b']) + len(e['diff'])
        log('%-22s %9d %9d %9d' % (title, len(e['a']), len(e['b']), len(e['diff'])))
    for kind, title in names:
        e = d[kind]
        for label, rows in (('only in A', e['a']), ('only in B', e['b'])):
            if not rows:
                continue
            log('')
            log('%s, %s: %d' % (title, label, len(rows)))
            for k, v in rows[:DIFF_EXAMPLES]:
                log('  %s: %s' % (key_text(kind, k), v))
            if len(rows) > DIFF_EXAMPLES:
                log('  ... and %d more' % (len(rows) - DIFF_EXAMPLES))
        if e['diff']:
            log('')
            log('%s, different (A -> B): %d' % (title, len(e['diff'])))
            for row in e['diff'][:DIFF_EXAMPLES]:
                log('  %s: %s -> %s' % (key_text(kind, row[0]), row[1], row[2]))
            if len(e['diff']) > DIFF_EXAMPLES:
                log('  ... and %d more' % (len(e['diff']) - DIFF_EXAMPLES))
    for cid in ids:
        for tag, res in (('A', a), ('B', b)):
            log('')
            log('id %d in %s:' % (cid, tag))
            for ln in state_of(res, cid):
                log('  ' + ln)
    log('')
    log('%s' % ('No differences.' if total == 0 else 'Differences: %d.' % total))
    return 0 if total == 0 else EXIT_DIFFERENT


def merge_libraries(base, fil):
    """`base` merged with `fil` the way the launcher does (README section 6). Returns (classes, pages, no_request, codes,
    counts, replaced): the records as a library holds them, {kind: [new, duplicate, replaced]} and the replaced records
    as (kind, id, page or None, old, new)."""
    classes = dict(base.classes)
    pages = {i: collections.OrderedDict(p) for i, p in base.pages.items()}
    no_request = set(base.no_request)
    codes = dict(base.codes)
    counts = {k: [0, 0, 0] for k in 'CRNS'}
    replaced = []

    def tally(kind, old, new):
        if old is None:
            counts[kind][0] += 1
        elif old == new:
            counts[kind][1] += 1
        else:
            counts[kind][2] += 1
            return True
        return False

    for i in sorted(fil.classes):
        old = classes.get(i)
        if tally('C', old, fil.classes[i]):
            replaced.append(('C', i, None, class_text(old), class_text(fil.classes[i])))
        classes[i] = fil.classes[i]
    for i in sorted(fil.pages):
        base_pages = pages.get(i)
        merged = collections.OrderedDict()
        for pg, reqs in fil.pages[i].items():
            old = base_pages.get(pg) if base_pages else None
            if tally('R', old, reqs):
                replaced.append(('R', i, pg, requests_text(old), requests_text(reqs)))
            merged[pg] = reqs
        if base_pages:
            for pg, reqs in base_pages.items():
                if pg not in fil.pages[i] and len(merged) < MAX_PAGES_PER_ID:
                    merged[pg] = reqs
        pages[i] = merged
        no_request.discard(i)
    for i in sorted(fil.no_request):
        if i in no_request:
            counts['N'][1] += 1
        elif i in pages:
            counts['N'][2] += 1
            gone = pages.pop(i)
            replaced.append(('N', i, None, ' / '.join('%s %s' % (page_name(pg), requests_text(r))
                                                       for pg, r in gone.items()), 'no request'))
        else:
            counts['N'][0] += 1
        no_request.add(i)
        pages.pop(i, None)
    for i in sorted(fil.codes):
        old = codes.get(i)
        if tally('S', old, fil.codes[i]):
            replaced.append(('S', i, None, pairs_text(old), pairs_text(fil.codes[i])))
        codes[i] = fil.codes[i]
    return classes, pages, no_request, codes, counts, replaced


def library_lines(classes, pages, no_request, codes, comments):
    """The sealed lines of a library held as `merge_libraries` returns it."""
    pages_of = {i: [(pg, tuple(r)) for pg, r in p.items()] for i, p in pages.items()}
    body = record_lines(classes, no_request, pages_of, codes)[0]
    out = [HEADER] + comments + body
    return seal_lines(out)


def cmd_merge(base_path, file_path, out_path, log):
    base, rc = load_checked(base_path, log)
    if base is None:
        return rc
    fil, rc = load_checked(file_path, log)
    if fil is None:
        return rc
    classes, pages, no_request, codes, counts, replaced = merge_libraries(base, fil)
    out_path = out_path or 'canbus_library_merged_%s.txt' % datetime.datetime.now().strftime('%Y-%m-%d_%H-%M-%S')
    comments = ['# Canbus library: %s merged with %s (the second one wins).' % (
        pathlib.Path(base_path).name, pathlib.Path(file_path).name)]
    sealed = library_lines(classes, pages, no_request, codes, comments)
    pathlib.Path(out_path).resolve().parent.mkdir(parents=True, exist_ok=True)
    with open(out_path, 'w', encoding='utf-8', newline='\n') as f:
        f.write('\n'.join(sealed) + '\n')
    chk = check_text(pathlib.Path(out_path).read_bytes())
    if chk.errors:
        log('error: the file written does not validate:')
        for ln, why in chk.errors[:20]:
            log('  line %d: %s' % (ln, why))
        return 1
    log('Merged %s with %s' % (base_path, file_path))
    log('%-4s %8s %10s %9s' % ('', 'new', 'duplicate', 'replaced'))
    for kind in 'CRNS':
        log('%-4s %8d %10d %9d' % ((kind,) + tuple(counts[kind])))
    for kind, i, pg, old, new in replaced[:MERGE_EXAMPLES]:
        log('  replaced %s %d%s: %s -> %s' % (kind, i, ' ' + page_name(pg) if pg else '', old, new))
    if len(replaced) > MERGE_EXAMPLES:
        log('  ... and %d more (--diff BASE OUT lists them)' % (len(replaced) - MERGE_EXAMPLES))
    log('Written: %s (%d records, footer ok)' % (pathlib.Path(out_path).resolve(), chk.records))
    return 0


def cmd_check(path, log):
    p = pathlib.Path(path)
    if not p.is_file():
        log('error: %s is not a file' % path)
        return 1
    res = check_text(p.read_bytes())
    if res.errors:
        log('INVALID %s: %d error(s)' % (path, len(res.errors)))
        for ln, why in res.errors:
            log('  line %d: %s' % (ln, why))
        return 2
    log('OK %s (version %d): %d records, %d cars with a class, %d with a request, %d with fuel/range codes, '
        '%d duplicates' % (path, res.version, res.records, len(res.classes), len(res.pages), len(res.codes), res.dups))
    return 0


def cmd_seal(path, log):
    p = pathlib.Path(path)
    if not p.is_file():
        log('error: %s is not a file' % path)
        return 1
    text = p.read_text(encoding='utf-8', errors='replace')
    if text.startswith('﻿'):
        text = text[1:]
    lines = [ln.rstrip('\r') for ln in text.split('\n')]
    while lines and lines[-1] == '':
        lines.pop()
    # drop an old footer (the last significant line, if it is one)
    for k in range(len(lines) - 1, -1, -1):
        s = lines[k].strip()
        if not s:
            continue
        if re.match(r'end\b', s):
            lines = lines[:k]
        break
    first = next((k for k, ln in enumerate(lines) if ln.strip() and not ln.strip().startswith('#')), None)
    if first is None or not re.fullmatch(r'canbus_library\s+[12]', lines[first].strip()):
        log('error: no "canbus_library 1" or "canbus_library 2" header')
        return 1
    body = lines[first:]
    sealed = seal_lines([ln.rstrip() for ln in body])
    with open(path, 'w', encoding='utf-8', newline='\n') as f:
        f.write('\n'.join(sealed) + '\n')
    log('Sealed %s: %s' % (path, sealed[-1]))
    return cmd_check(path, log)


def main(argv=None):
    ap = argparse.ArgumentParser(description='Builds, validates and seals a canbus library for the FYT launcher.')
    ap.add_argument('src', nargs='?', help='a decompiled com.syu.canbus: the "sources" folder or any folder above it')
    ap.add_argument('--out', help='the file to write')
    ap.add_argument('--mapping', help='the java file that holds the switch on the car id (default: found in <src>)')
    ap.add_argument('--launcher', metavar='REPO', help='build the library built into the launcher from REPO')
    ap.add_argument('--seal', metavar='FILE', help='recompute the footer of FILE')
    ap.add_argument('--check', metavar='FILE', help='validate FILE like the launcher')
    ap.add_argument('--diff', nargs=2, metavar=('A', 'B'), help='what differs between two library files')
    ap.add_argument('--ids', help='with --diff: car ids (comma separated) whose full state is printed from both files')
    ap.add_argument('--merge', nargs=2, metavar=('BASE', 'FILE'), help='BASE merged with FILE the way the launcher does')
    args = ap.parse_args(argv)

    def log(msg):
        try:
            print(msg)
        except UnicodeEncodeError:
            print(msg.encode('ascii', 'replace').decode('ascii'))

    if args.check:
        return cmd_check(args.check, log)
    if args.seal:
        return cmd_seal(args.seal, log)
    if args.diff:
        return cmd_diff(args.diff[0], args.diff[1], args.ids, log)
    if args.merge:
        return cmd_merge(args.merge[0], args.merge[1], args.out, log)

    if args.launcher:
        repo = pathlib.Path(args.launcher)
        asset_path = repo / 'app/src/main/assets/canbus_library.txt'
        sources = repo / 'decompiled_carinfo'
        if not asset_path.is_file():
            log('error: %s not found' % asset_path)
            return 1
        if not sources.is_dir():
            log('error: %s not found' % sources)
            return 1
        asset = check_text(asset_path.read_bytes())
        if asset.errors:
            log('error: %s does not validate:' % asset_path)
            for ln, why in asset.errors[:20]:
                log('  line %d: %s' % (ln, why))
            return 1
        out = args.out or str(asset_path)
        index = SourceIndex(sources)
        log('Sources: %s (%d classes)' % (sources, len(index.by_fqcn)))
        return build(args, repo, None, {}, 'app/src/main/assets/canbus_library.txt', index, out, log, asset=asset)

    if not args.src:
        ap.print_usage()
        return 1
    root = pathlib.Path(args.src)
    if not root.is_dir():
        log('error: %s is not a folder' % args.src)
        return 1
    index = SourceIndex(root)
    log('Sources: %s (%d classes)' % (root, len(index.by_fqcn)))
    if not index.by_fqcn:
        log('error: no .java files under %s' % root)
        return 1
    final = None
    for p in root.rglob('FinalCanbus.java'):
        final = p
        break
    if args.mapping:
        mapping_path = pathlib.Path(args.mapping)
        if not mapping_path.is_file():
            log('error: %s not found' % args.mapping)
            return 1
    else:
        mapping_path = None
        for p in root.rglob('ActivityLauncher.java'):
            if p.as_posix().endswith('com/syu/canbus/ActivityLauncher.java') \
                    and 'switch (DataCanbus.DATA[1000])' in read_text(p):
                mapping_path = p
                break
        if mapping_path is None:
            best, best_n = None, 0
            for p in root.rglob('*.java'):
                text = read_text(p)
                if 'DATA[1000]' not in text or 'switch' not in text:
                    continue
                toks = lex(text)
                for sw in find_switches(toks):
                    if 'DataCanbus.DATA[1000]' in sw[3]:
                        n = count_pairs(toks, sw[1], sw[2])
                        if n > best_n:
                            best, best_n = p, n
            mapping_path = best
        if mapping_path is None:
            log('error: mapping not found: no switch (DataCanbus.DATA[1000]) with class assignments under %s. '
                'Pass the file with --mapping, e.g. --mapping ...\\com\\syu\\canbus\\ActivityLauncher.java' % root)
            return 1
    try:
        label = mapping_path.relative_to(root).as_posix()
    except ValueError:
        label = mapping_path.name
    out = args.out or ('canbus_library_%s.txt' % datetime.datetime.now().strftime('%Y-%m-%d_%H-%M-%S'))
    return build(args, root, mapping_path, load_constants(final), label, index, out, log)


if __name__ == '__main__':
    sys.exit(main())
