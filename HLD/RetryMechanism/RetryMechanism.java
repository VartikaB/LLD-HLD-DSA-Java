package HLD.RetryMechanism;

import java.util.Objects;
import java.util.concurrent.Callable;

public class RetryMechanism {
    public static <T> T execute(Callable<T> operation, int maxAttempts, long delayMillis) throws Exception {
        Objects.requireNonNull(operation, "operation");
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("maxAttempts must be at least 1");
        }
        if (delayMillis < 0) {
            throw new IllegalArgumentException("delayMillis cannot be negative");
        }

        for (int attempt = 1; ; attempt++) {
            try {
                return operation.call();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                throw exception;
            } catch (Exception exception) {
                if (attempt == maxAttempts) {
                    throw exception;
                }

                if (delayMillis > 0) {
                    try {
                        Thread.sleep(delayMillis);
                    } catch (InterruptedException interrupted) {
                        Thread.currentThread().interrupt();
                        throw interrupted;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] attempts = {0};
        String result = execute(() -> {
            attempts[0]++;
            System.out.println("Attempt " + attempts[0]);
            if (attempts[0] < 3) {
                throw new Exception("Temporary failure");
            }
            return "Operation succeeded";
        }, 3, 500);

        System.out.println(result);
    }
}
