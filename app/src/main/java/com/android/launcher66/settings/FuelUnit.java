package com.android.launcher66.settings;

import java.util.ArrayList;
import java.util.List;

/**
 * Where a car's protocol reports the unit of the instantaneous consumption, from the {@code U} record of the canbus
 * library: in a code of its own ({@link Kind#CODE}: the value of the code says the unit), in a bit of the consumption
 * code itself ({@link Kind#BIT}: the consumption is the code masked, the bit says the unit) or always the same
 * ({@link Kind#FIXED}). Plain Java (no android.*), so that it runs in JVM tests.
 */
public final class FuelUnit {

    public enum Kind { CODE, BIT, FIXED }

    /** What a protocol reports: L/100 km, L/h, or something the launcher does not use (gallons, mpg, km/L). */
    public enum Unit { L100, LH, OTHER }

    /** The largest code a record may name, as in the rest of the library. */
    static final int MAX_CODE = 1199;
    private static final int MAX_VALUES = 16;

    public final Kind kind;
    /** CODE: the code the unit is in; else -1. */
    public final int code;
    /** BIT: the bit of the consumption code and the mask of its value; else -1. */
    public final int bit;
    public final int mask;
    /** CODE: the values with a unit, ascending, and the unit of every other value (null = unknown). */
    private final int[] values;
    private final Unit[] units;
    private final Unit otherwise;
    /** BIT: the unit when the bit is 0 and when it is 1. FIXED: {@code zero}. */
    private final Unit zero;
    private final Unit one;

    private FuelUnit(Kind kind, int code, int bit, int mask, int[] values, Unit[] units, Unit otherwise, Unit zero, Unit one) {
        this.kind = kind;
        this.code = code;
        this.bit = bit;
        this.mask = mask;
        this.values = values;
        this.units = units;
        this.otherwise = otherwise;
        this.zero = zero;
        this.one = one;
    }

    public static FuelUnit fixed(Unit unit) {
        return new FuelUnit(Kind.FIXED, -1, -1, -1, new int[0], new Unit[0], null, unit, null);
    }

    public static FuelUnit bit(int bit, int mask, Unit whenZero, Unit whenOne) {
        return new FuelUnit(Kind.BIT, -1, bit, mask, new int[0], new Unit[0], null, whenZero, whenOne);
    }

    /** A unit in a code; {@code values} and {@code units} are the same length, in any order, {@code otherwise} may be null. */
    public static FuelUnit code(int code, int[] values, Unit[] units, Unit otherwise) {
        Integer[] order = new Integer[values.length];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        java.util.Arrays.sort(order, (a, b) -> Integer.compare(values[a], values[b]));
        int[] v = new int[values.length];
        Unit[] u = new Unit[values.length];
        for (int i = 0; i < order.length; i++) {
            v[i] = values[order[i]];
            u[i] = units[order[i]];
        }
        return new FuelUnit(Kind.CODE, code, -1, -1, v, u, otherwise, null, null);
    }

    /**
     * The fields of a U record after the ids ({@code f[from..]}): {@code code x | v=U,...,*=U},
     * {@code bit b | mask m | 0=U,1=U} or {@code fixed U}. Throws {@link IllegalArgumentException} with the reason.
     */
    public static FuelUnit parse(String[] f, int from) {
        int count = f.length - from;
        if (count < 1) {
            throw new IllegalArgumentException(usage());
        }
        String[] head = f[from].trim().split("\\s+");
        switch (head[0]) {
            case "fixed":
                if (count != 1 || head.length != 2) {
                    throw new IllegalArgumentException("U fixed takes one unit (L100, LH or OTHER)");
                }
                return fixed(unit(head[1]));
            case "code": {
                if (count != 2 || head.length != 2 || !head[1].matches("[0-9]{1,4}") || Integer.parseInt(head[1]) > MAX_CODE) {
                    throw new IllegalArgumentException("U code takes \"code x | map\" with x in 0.." + MAX_CODE);
                }
                List<Integer> values = new ArrayList<>();
                List<Unit> units = new ArrayList<>();
                Unit otherwise = null;
                String[] parts = f[from + 1].split(",", -1);
                if (parts.length > MAX_VALUES) {
                    throw new IllegalArgumentException("more than " + MAX_VALUES + " values in the unit map");
                }
                boolean star = false;
                for (String part : parts) {
                    String[] kv = part.split("=", -1);
                    if (kv.length != 2) {
                        throw new IllegalArgumentException("bad unit \"" + clip(part.trim()) + "\" (value=LH, value=L100 or value=OTHER)");
                    }
                    String k = kv[0].trim();
                    Unit u = unit(kv[1].trim());
                    if (k.equals("*")) {
                        if (star) {
                            throw new IllegalArgumentException("a value repeated in the unit map");
                        }
                        star = true;
                        otherwise = u;
                    } else if (k.matches("-?[0-9]{1,6}")) {
                        int v = Integer.parseInt(k);
                        if (values.contains(v)) {
                            throw new IllegalArgumentException("a value repeated in the unit map");
                        }
                        values.add(v);
                        units.add(u);
                    } else {
                        throw new IllegalArgumentException("bad unit \"" + clip(part.trim()) + "\" (value=LH, value=L100 or value=OTHER)");
                    }
                }
                int[] v = new int[values.size()];
                for (int i = 0; i < v.length; i++) {
                    v[i] = values.get(i);
                }
                return code(Integer.parseInt(head[1]), v, units.toArray(new Unit[0]), otherwise);
            }
            case "bit": {
                if (count != 3 || head.length != 2 || !head[1].matches("[0-9]{1,2}") || Integer.parseInt(head[1]) > 30) {
                    throw new IllegalArgumentException("U bit takes \"bit b | mask m | 0=unit,1=unit\" with b in 0..30");
                }
                String[] mask = f[from + 1].trim().split("\\s+");
                if (mask.length != 2 || !mask[0].equals("mask") || !mask[1].matches("[0-9]{1,6}")
                        || Integer.parseInt(mask[1]) < 1 || Integer.parseInt(mask[1]) > 65535) {
                    throw new IllegalArgumentException("U bit takes \"mask m\" with m in 1..65535");
                }
                Unit whenZero = null;
                Unit whenOne = null;
                for (String part : f[from + 2].split(",", -1)) {
                    String[] kv = part.split("=", -1);
                    if (kv.length != 2) {
                        throw new IllegalArgumentException("bad unit \"" + clip(part.trim()) + "\" (0=unit,1=unit)");
                    }
                    String k = kv[0].trim();
                    if (k.equals("0") && whenZero == null) {
                        whenZero = unit(kv[1].trim());
                    } else if (k.equals("1") && whenOne == null) {
                        whenOne = unit(kv[1].trim());
                    } else {
                        throw new IllegalArgumentException("U bit takes exactly 0=unit and 1=unit");
                    }
                }
                if (whenZero == null || whenOne == null) {
                    throw new IllegalArgumentException("U bit takes exactly 0=unit and 1=unit");
                }
                return bit(Integer.parseInt(head[1]), Integer.parseInt(mask[1]), whenZero, whenOne);
            }
            default:
                throw new IllegalArgumentException(usage());
        }
    }

    private static String usage() {
        return "U takes \"ids | code x | map\", \"ids | bit b | mask m | 0=unit,1=unit\" or \"ids | fixed unit\"";
    }

    private static Unit unit(String text) {
        for (Unit u : Unit.values()) {
            if (u.name().equals(text)) {
                return u;
            }
        }
        throw new IllegalArgumentException("bad unit \"" + clip(text) + "\" (L100, LH or OTHER)");
    }

    private static String clip(String s) {
        return s.length() > 30 ? s.substring(0, 30) : s;
    }

    // ---------------------------------------------------------------------------------------------
    // Reading a value
    // ---------------------------------------------------------------------------------------------

    /** The code the service must listen to for the unit, or -1 (the unit is in the consumption code itself or fixed). */
    public int unitCode() {
        return kind == Kind.CODE ? code : -1;
    }

    /** The consumption (L/100 km or L/h, times 10) in the raw value of the consumption code. */
    public int consumption(int raw) {
        return kind == Kind.BIT ? raw & mask : raw;
    }

    /**
     * The unit now: {@code unitCodeValue} is the last value of the unit code (null = not reported yet), {@code raw}
     * the raw value of the consumption code. Null = unknown (also for a unit the launcher does not use).
     */
    public Unit unitNow(Integer unitCodeValue, int raw) {
        Unit u;
        switch (kind) {
            case FIXED:
                u = zero;
                break;
            case BIT:
                u = ((raw >> bit) & 1) == 0 ? zero : one;
                break;
            default:
                if (unitCodeValue == null) {
                    return null;
                }
                u = otherwise;
                for (int i = 0; i < values.length; i++) {
                    if (values[i] == unitCodeValue) {
                        u = units[i];
                        break;
                    }
                }
        }
        return u == Unit.OTHER ? null : u;
    }

    // ---------------------------------------------------------------------------------------------
    // The text of the record
    // ---------------------------------------------------------------------------------------------

    /** The record text after the ids, the way the script writes it. */
    @Override
    public String toString() {
        switch (kind) {
            case FIXED:
                return "fixed " + zero;
            case BIT:
                return "bit " + bit + " | mask " + mask + " | 0=" + zero + ",1=" + one;
            default:
                StringBuilder sb = new StringBuilder("code ").append(code).append(" | ");
                for (int i = 0; i < values.length; i++) {
                    if (i > 0) {
                        sb.append(',');
                    }
                    sb.append(values[i]).append('=').append(units[i]);
                }
                if (otherwise != null) {
                    sb.append(values.length > 0 ? "," : "").append("*=").append(otherwise);
                }
                return sb.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FuelUnit && o.toString().equals(toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
