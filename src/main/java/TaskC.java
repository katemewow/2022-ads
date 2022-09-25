import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskC {
    private TaskC() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        String command;
        Stack stack = new Stack();
        while (true) {
            command = in.next();
            switch (command) {
                case "push" -> {
                    stack.push(in.nextInt());
                    out.println("ok");
                }
                case "pop" -> {
                    if (stack.last == null) {
                        out.println("error");
                    } else {
                        out.println(stack.pop());
                    }
                }
                case "back" -> {
                    if (stack.last == null) {
                        out.println("error");
                    } else {
                        out.println(stack.back());
                    }
                }
                case "size" -> {
                    out.println(stack.size());
                }
                case "clear" -> {
                    stack.clear();
                    out.println("ok");
                }
                case "exit" -> {
                    out.println("bye");
                    return;
                }
            }
        }
    }

    private static class Stack {
        private Node last;
        private int size;

        public void push(int value) {
            size++;
            Node node = new Node(value);
            if (last != null) {
                node.prev = last;
            }
            last = node;
        }

        public int pop() {
            size--;
            int value = last.value;
            last = last.prev;
            return value;
        }

        public int back() {
            return last.value;
        }

        public int size() {
            return size;
        }

        public void clear() {
            last = null;
            size = 0;
        }

        private static class Node {
            private int value;
            private Node prev;

            public Node(int value) {
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
