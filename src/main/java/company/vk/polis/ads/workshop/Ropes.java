package company.vk.polis.ads.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ropes {
    private Ropes() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] ropes = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            ropes[i] = in.nextLong();
            sum += ropes[i];
        }
        if (sum < k) {
            out.println(0);
            return;
        }
        long l = 1;
        long r = sum / k + 1;
        while (l < r) {
            long mid = (l + r) >>> 1;
            int houseCount = 0;
            for (long length : ropes) {
                houseCount += length / mid;
            }
            if (houseCount < k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        out.println(l - 1);
    }

    private static final class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
