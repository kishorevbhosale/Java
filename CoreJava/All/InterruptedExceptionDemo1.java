package mt;

import java.math.BigInteger;

public class InterruptedExceptionDemo1 {
    public static void main(String[] args) {
        Thread t = new Thread(new LongComputationalTask(new BigInteger("200089898900"), new BigInteger("22089898900")));
        t.start();
        t.interrupt();
    }

    private static class LongComputationalTask implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputationalTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + getResult(base, power));
        }

        private BigInteger getResult(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}
