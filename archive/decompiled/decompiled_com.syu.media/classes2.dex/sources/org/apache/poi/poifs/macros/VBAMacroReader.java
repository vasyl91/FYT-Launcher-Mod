package org.apache.poi.poifs.macros;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.CharEncoding;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RLEDecompressingInputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class VBAMacroReader implements Closeable {
    private static final int EOF = -1;
    private static final int MODULEOFFSET = 49;
    private static final int MODULETYPE_DOCUMENT_CLASS_OR_DESIGNER = 34;
    private static final int MODULETYPE_PROCEDURAL = 33;
    private static final int MODULE_DOC_STRING = 28;
    private static final int MODULE_NAME = 25;
    private static final int MODULE_NAME_UNICODE = 71;
    private static final int PROJECTCODEPAGE = 3;
    private static final int PROJECTLCID = 2;
    private static final int PROJECTVERSION = 9;
    private static final int STREAMNAME = 26;
    private static final int STREAMNAME_RESERVED = 50;
    private static final Charset UTF_16LE = Charset.forName(CharEncoding.UTF_16LE);
    protected static final String VBA_PROJECT_OOXML = "vbaProject.bin";
    protected static final String VBA_PROJECT_POIFS = "VBA";
    private static final int VERSION_DEPENDENT_TERMINATOR = 43;
    private static final int VERSION_INDEPENDENT_TERMINATOR = 16;
    private NPOIFSFileSystem fs;

    public VBAMacroReader(InputStream inputStream) throws IOException {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        if (FileMagic.valueOf(inputStreamPrepareToCheckMagic) == FileMagic.OLE2) {
            this.fs = new NPOIFSFileSystem(inputStreamPrepareToCheckMagic);
        } else {
            openOOXML(inputStreamPrepareToCheckMagic);
        }
    }

    public VBAMacroReader(File file) throws IOException {
        try {
            this.fs = new NPOIFSFileSystem(file);
        } catch (OfficeXmlFileException unused) {
            openOOXML(new FileInputStream(file));
        }
    }

    public VBAMacroReader(NPOIFSFileSystem nPOIFSFileSystem) {
        this.fs = nPOIFSFileSystem;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        r3 = move-exception;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void openOOXML(java.io.InputStream r3) throws java.io.IOException {
        /*
            r2 = this;
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream
            r0.<init>(r3)
        L5:
            java.util.zip.ZipEntry r3 = r0.getNextEntry()
            if (r3 == 0) goto L24
            java.lang.String r3 = r3.getName()
            java.lang.String r1 = "vbaProject.bin"
            boolean r3 = org.apache.poi.util.StringUtil.endsWithIgnoreCase(r3, r1)
            if (r3 == 0) goto L5
            org.apache.poi.poifs.filesystem.NPOIFSFileSystem r3 = new org.apache.poi.poifs.filesystem.NPOIFSFileSystem     // Catch: java.io.IOException -> L1f
            r3.<init>(r0)     // Catch: java.io.IOException -> L1f
            r2.fs = r3     // Catch: java.io.IOException -> L1f
            return
        L1f:
            r3 = move-exception
            r0.close()
            throw r3
        L24:
            r0.close()
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "No VBA project found"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.poifs.macros.VBAMacroReader.openOOXML(java.io.InputStream):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fs.close();
        this.fs = null;
    }

    public Map<String, String> readMacros() throws IOException {
        ModuleMap moduleMap = new ModuleMap();
        findMacros(this.fs.getRoot(), moduleMap);
        HashMap map = new HashMap();
        for (Map.Entry<String, Module> entry : moduleMap.entrySet()) {
            Module value = entry.getValue();
            if (value.buf != null && value.buf.length > 0) {
                map.put(entry.getKey(), new String(value.buf, moduleMap.charset));
            }
        }
        return map;
    }

    protected static class Module {
        byte[] buf;
        Integer offset;

        protected Module() {
        }

        void read(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copy(inputStream, byteArrayOutputStream);
            byteArrayOutputStream.close();
            this.buf = byteArrayOutputStream.toByteArray();
        }
    }

    protected static class ModuleMap extends HashMap<String, Module> {
        Charset charset = Charset.forName("Cp1252");

        protected ModuleMap() {
        }
    }

    protected void findMacros(DirectoryNode directoryNode, ModuleMap moduleMap) throws IOException {
        if (VBA_PROJECT_POIFS.equalsIgnoreCase(directoryNode.getName())) {
            readMacros(directoryNode, moduleMap);
            return;
        }
        for (Entry entry : directoryNode) {
            if (entry instanceof DirectoryNode) {
                findMacros((DirectoryNode) entry, moduleMap);
            }
        }
    }

    private static String readString(InputStream inputStream, int i, Charset charset) throws IOException {
        byte[] bArr = new byte[i];
        return new String(bArr, 0, inputStream.read(bArr), charset);
    }

    private static void readModule(RLEDecompressingInputStream rLEDecompressingInputStream, String str, ModuleMap moduleMap) throws IOException {
        int i = rLEDecompressingInputStream.readInt();
        Module module2 = moduleMap.get(str);
        if (module2 == null) {
            Module module3 = new Module();
            module3.offset = Integer.valueOf(i);
            moduleMap.put(str, module3);
        } else {
            RLEDecompressingInputStream rLEDecompressingInputStream2 = new RLEDecompressingInputStream(new ByteArrayInputStream(module2.buf, i, module2.buf.length - i));
            module2.read(rLEDecompressingInputStream2);
            rLEDecompressingInputStream2.close();
        }
    }

    private static void readModule(DocumentInputStream documentInputStream, String str, ModuleMap moduleMap) throws IOException {
        Module module2 = moduleMap.get(str);
        if (module2 == null) {
            Module module3 = new Module();
            moduleMap.put(str, module3);
            module3.read(documentInputStream);
        } else if (module2.buf == null) {
            if (module2.offset == null) {
                throw new IOException("Module offset for '" + str + "' was never read.");
            }
            long jSkip = documentInputStream.skip(module2.offset.intValue());
            if (jSkip != module2.offset.intValue()) {
                throw new IOException("tried to skip " + module2.offset + " bytes, but actually skipped " + jSkip + " bytes");
            }
            RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(documentInputStream);
            module2.read(rLEDecompressingInputStream);
            rLEDecompressingInputStream.close();
        }
    }

    private static void trySkip(InputStream inputStream, long j) throws IOException {
        long jSkip = inputStream.skip(j);
        if (jSkip != j) {
            if (jSkip < 0) {
                throw new IOException("Tried skipping " + j + " bytes, but no bytes were skipped. The end of the stream has been reached or the stream is closed.");
            }
            throw new IOException("Tried skipping " + j + " bytes, but only " + jSkip + " bytes were skipped. This should never happen.");
        }
    }

    protected void readMacros(DirectoryNode directoryNode, ModuleMap moduleMap) throws IOException {
        for (Entry entry : directoryNode) {
            if (entry instanceof DocumentNode) {
                String name = entry.getName();
                DocumentInputStream documentInputStream = new DocumentInputStream((DocumentNode) entry);
                try {
                    if ("dir".equalsIgnoreCase(name)) {
                        RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(documentInputStream);
                        String string = null;
                        int i = 0;
                        while (true) {
                            try {
                                try {
                                    i = rLEDecompressingInputStream.readShort();
                                    if (-1 == i || 16 == i) {
                                        break;
                                        break;
                                    }
                                    int i2 = rLEDecompressingInputStream.readInt();
                                    if (i == 3) {
                                        moduleMap.charset = Charset.forName(CodePageUtil.codepageToEncoding(rLEDecompressingInputStream.readShort(), true));
                                    } else if (i == 9) {
                                        trySkip(rLEDecompressingInputStream, 6L);
                                    } else if (i == 26) {
                                        string = readString(rLEDecompressingInputStream, i2, moduleMap.charset);
                                        int i3 = rLEDecompressingInputStream.readShort();
                                        if (i3 != 50) {
                                            throw new IOException("Expected x0032 after stream name before Unicode stream name, but found: " + Integer.toHexString(i3));
                                        }
                                        readUnicodeString(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt());
                                    } else if (i == 49) {
                                        readModule(rLEDecompressingInputStream, string, moduleMap);
                                    } else {
                                        trySkip(rLEDecompressingInputStream, i2);
                                    }
                                } catch (IOException e) {
                                    throw new IOException("Error occurred while reading macros at section id " + i + " (" + HexDump.shortToHex(i) + ")", e);
                                }
                            } catch (Throwable th) {
                                rLEDecompressingInputStream.close();
                                throw th;
                            }
                        }
                        rLEDecompressingInputStream.close();
                    } else if (!StringUtil.startsWithIgnoreCase(name, "__SRP") && !StringUtil.startsWithIgnoreCase(name, "_VBA_PROJECT")) {
                        readModule(documentInputStream, name, moduleMap);
                    }
                    documentInputStream.close();
                } catch (Throwable th2) {
                    documentInputStream.close();
                    throw th2;
                }
            }
        }
    }

    private String readUnicodeString(RLEDecompressingInputStream rLEDecompressingInputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        IOUtils.readFully(rLEDecompressingInputStream, bArr);
        return new String(bArr, UTF_16LE);
    }
}
