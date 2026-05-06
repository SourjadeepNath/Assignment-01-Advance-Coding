import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextLong();
        }

        long k = fs.nextLong();

        long remainder = a[0] % k;
        for (int i = 1; i < n; i++) {
            if (a[i] % k != remainder) {
                System.out.println(-1);
                return;
            }
        }

        long[] normalized = new long[n];
        for (int i = 0; i < n; i++) {
            normalized[i] = (a[i] - remainder) / k;
        }

        Arrays.sort(normalized);
        long median = normalized[n / 2];

        long operations = 0;
        for (int i = 0; i < n; i++) {
            operations += Math.abs(normalized[i] - median);
        }

        System.out.println(operations);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return value * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
