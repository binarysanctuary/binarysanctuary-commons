package com.binarysanctuary.commons.coreext;

/**
 * Utility methods for arrays.
 */
public class Array {
    /**
     * Convenient method for creating an array.
     *
     * @param params Params to put into array.
     * @param <T> Type of parameters.
     * @return An array.
     */
    @SafeVarargs
    public static <T> T[] $(T... params) {
        return params;
    }

    /**
     *
     * @param array
     * @param idx
     */
    public static void rshift(Object[] array, int idx) {
        if (idx < array.length && idx >= 0) {
            System.arraycopy(array, idx, array, idx + 1, array.length - idx - 1);
        } else {
            throw new IllegalArgumentException("Attempt to shift an array providing invalid start index");
        }
    }
}
