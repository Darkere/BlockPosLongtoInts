package darkere;

public class Main {
    private static final int NUM_X_BITS = 1 + log2(smallestEncompassingPowerOfTwo(30000000));
    private static final int NUM_Z_BITS = NUM_X_BITS;
    private static final int NUM_Y_BITS = 64 - NUM_X_BITS - NUM_Z_BITS;
    private static final int[] MULTIPLY_DE_BRUIJN_BIT_POSITION = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
    private static final int field_218292_j = NUM_Y_BITS;
    private static final int field_218293_k = NUM_Y_BITS + NUM_Z_BITS;

    public static void main(String[] args) {
        fromLong(Long.getLong(args[1]));
    }
    public static int unpackX(long p_218290_0_) {
        return (int)(p_218290_0_ << 64 - field_218293_k - NUM_X_BITS >> 64 - NUM_X_BITS);
    }

    public static int unpackY(long p_218274_0_) {
        return (int)(p_218274_0_ << 64 - NUM_Y_BITS >> 64 - NUM_Y_BITS);
    }

    public static int unpackZ(long p_218282_0_) {
        return (int)(p_218282_0_ << 64 - field_218292_j - NUM_Z_BITS >> 64 - NUM_Z_BITS);
    }

    public static void fromLong(long x) {
        System.out.println("X: " + unpackX(x));
        System.out.println("Y: " + unpackY(x));
        System.out.println("Z: " + unpackZ(x));
    }
    public static int smallestEncompassingPowerOfTwo(int value) {
        int i = value - 1;
        i = i | i >> 1;
        i = i | i >> 2;
        i = i | i >> 4;
        i = i | i >> 8;
        i = i | i >> 16;
        return i + 1;
    }
    public static int log2(int value) {
        return log2DeBruijn(value) - (isPowerOfTwo(value) ? 0 : 1);
    }
    public static int log2DeBruijn(int value) {
        value = isPowerOfTwo(value) ? value : smallestEncompassingPowerOfTwo(value);
        return MULTIPLY_DE_BRUIJN_BIT_POSITION[(int)((long)value * 125613361L >> 27) & 31];
    }
    private static boolean isPowerOfTwo(int value) {
        return value != 0 && (value & value - 1) == 0;
    }
}
