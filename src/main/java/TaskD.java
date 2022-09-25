import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskD {

    private TaskD() {
        // Should not be instantiated
    }

    static Map<Character, Character> brackets = Map.of('(', ')', '[', ']', '{', '}');

    private static void solve(final FastScanner in, final PrintWriter out) {
        Stack stack = new Stack();
        String str = in.next();
        for (int i = 0; i < str.length(); i++) {
            if (isOpened(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty() || str.charAt(i) != brackets.get(stack.last.value)) {
                    out.println("no");
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.size() == 0) {
            out.println("yes");
        } else {
            out.println("no");
        }
    }

    private static boolean isOpened(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static class Stack {
        private Node last;
        private int size;

        public void push(char value) {
            size++;
            Node node = new Node(value);
            if (last != null) {
                node.prev = last;
            }
            last = node;
        }

        public void pop() {
            size--;
            last = last.prev;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private static class Node {
            private char value;
            private Node prev;

            public Node(char value) {
                this.value = value;
            }
        }
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
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
