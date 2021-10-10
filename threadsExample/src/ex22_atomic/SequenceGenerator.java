package ex22_atomic;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SequenceGenerator {
    private static BigInteger MULTIPLIER;
    private final AtomicReference<BigInteger> element;

    public SequenceGenerator() {
        if (MULTIPLIER == null)
            MULTIPLIER = BigInteger.valueOf(2);
        element = new AtomicReference<>(BigInteger.ONE);
    }

    public BigInteger next() {
        BigInteger value;
        BigInteger next;
        do {
            value = element.get();
            next = value.multiply(MULTIPLIER);
        } while (!element.compareAndSet(value, next));
        return value;
    }
}
