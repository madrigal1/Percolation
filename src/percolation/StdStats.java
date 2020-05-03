package percolation;

public final class StdStats {
    private StdStats() { };

    public static double mean(double[] a) {
        validateNotNull(a);

        if (a.length == 0) return Double.NaN;
        double sum = sum(a);
        return sum / a.length;
    }

    /**
     * Returns the average value in the specified subarray.
     *
     * @param a the array
     * @param lo the left endpoint of the subarray (inclusive)
     * @param hi the right endpoint of the subarray (exclusive)
     * @return the average value in the subarray {@code a[lo..hi)};
     *         {@code Double.NaN} if no such value
     * @throws IllegalArgumentException if {@code a} is {@code null}
     * @throws IllegalArgumentException unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
     */
    public static double mean(double[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);

        int length = hi - lo;
        if (length == 0) return Double.NaN;

        double sum = sum(a, lo, hi);
        return sum / length;
    }

    /**
     * Returns the average value in the specified array.
     *
     * @param  a the array
     * @return the average value in the array {@code a[]};
     *         {@code Double.NaN} if no such value
     */
    public static double mean(int[] a) {
        validateNotNull(a);

        if (a.length == 0) return Double.NaN;
        int sum = sum(a);
        return 1.0 * sum / a.length;
    }


    // throw an IllegalArgumentException if x is null
    // (x is either of type double[] or int[])
    private static void validateNotNull(Object x) {
        if (x == null)
            throw new IllegalArgumentException("argument is null");
    }

    // throw an exception unless 0 <= lo <= hi <= length
    private static void validateSubarrayIndices(int lo, int hi, int length) {
        if (lo < 0 || hi > length || lo > hi)
            throw new IllegalArgumentException("subarray indices out of bounds: [" + lo + ", " + hi + ")");
    }

      /*  * Returns the sum of all values in the specified array.
            *
            * @param  a the array
     * @return the sum of all values in the array {@code a[]};
     *         {@code 0.0} if no such value
     */
    private static double sum(double[] a) {
        validateNotNull(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    /**
     * Returns the sum of all values in the specified subarray.
     *
     * @param  a the array
     * @param lo the left endpoint of the subarray (inclusive)
     * @param hi the right endpoint of the subarray (exclusive)
     * @return the sum of all values in the subarray {@code a[lo..hi)};
     *         {@code 0.0} if no such value
     * @throws IllegalArgumentException if {@code a} is {@code null}
     * @throws IllegalArgumentException unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
     */
    private static double sum(double[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);

        double sum = 0.0;
        for (int i = lo; i < hi; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static double var(double[] a) {
        validateNotNull(a);

        if (a.length == 0) return Double.NaN;
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (a.length - 1);
    }

    /**
     * Returns the sample variance in the specified subarray.
     *
     * @param  a the array
     * @param lo the left endpoint of the subarray (inclusive)
     * @param hi the right endpoint of the subarray (exclusive)
     * @return the sample variance in the subarray {@code a[lo..hi)};
     *         {@code Double.NaN} if no such value
     * @throws IllegalArgumentException if {@code a} is {@code null}
     * @throws IllegalArgumentException unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
     */
    public static double var(double[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);

        int length = hi - lo;
        if (length == 0) return Double.NaN;

        double avg = mean(a, lo, hi);
        double sum = 0.0;
        for (int i = lo; i < hi; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (length - 1);
    }

    /**
     * Returns the sample variance in the specified array.
     *
     * @param  a the array
     * @return the sample variance in the array {@code a[]};
     *         {@code Double.NaN} if no such value
     */
    public static double var(int[] a) {
        validateNotNull(a);
        if (a.length == 0) return Double.NaN;
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (a.length - 1);
    }

    /**
     * Returns the sum of all values in the specified array.
     *
     * @param  a the array
     * @return the sum of all values in the array {@code a[]};
     *         {@code 0.0} if no such value
     */
    private static int sum(int[] a) {
        validateNotNull(a);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static double stddev(double[] a) {
        validateNotNull(a);
        return Math.sqrt(var(a));
    }

    /**
     * Returns the sample standard deviation in the specified array.
     *
     * @param  a the array
     * @return the sample standard deviation in the array {@code a[]};
     *         {@code Double.NaN} if no such value
     */
    public static double stddev(int[] a) {
        validateNotNull(a);
        return Math.sqrt(var(a));
    }

    /**
     * Returns the sample standard deviation in the specified subarray.
     *
     * @param  a the array
     * @param lo the left endpoint of the subarray (inclusive)
     * @param hi the right endpoint of the subarray (exclusive)
     * @return the sample standard deviation in the subarray {@code a[lo..hi)};
     *         {@code Double.NaN} if no such value
     * @throws IllegalArgumentException if {@code a} is {@code null}
     * @throws IllegalArgumentException unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
     */
    public static double stddev(double[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);

        return Math.sqrt(var(a, lo, hi));
    }



};
