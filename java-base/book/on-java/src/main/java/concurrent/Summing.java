package concurrent;

import onjava.Timer;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * @author lh
 */
public class Summing {
    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.println(id + ": ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue) {
            System.out.println(timer.duration() + "ms");
        } else {
            System.out.format("result: %d%ncheckValue: %d%n", result, checkValue);
        }
    }

    public static final int SZ = 1_00_000_000;
    // this even works:
    // public static final int SZ =1_000_000_000;
    public static final long CHECK = (long) SZ * ((long) SZ + 1) / 2; // Gauss's formula

    public static void main(String[] args) {
        System.out.println(CHECK);
        timeTest("Sun Stream", CHECK, () -> LongStream.rangeClosed(0, SZ).sum());
        timeTest("Sum Stream Parallel", CHECK, () -> LongStream.rangeClosed(0, SZ)
                .parallel()
                .sum());
        timeTest("Sum Iterated", CHECK, () -> LongStream.iterate(0, i -> i + 1)
                .limit(SZ + 1)
                .sum());
        timeTest(
                "Sun Iterated Parallel",
                CHECK,
                () -> LongStream.iterate(0, i -> i + 1).parallel().limit(SZ + 1).sum());
    }
}
