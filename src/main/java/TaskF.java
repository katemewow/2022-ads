import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskF {
    private TaskF() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        String command;
        Deque deque = new Deque();
        while (true) {
            command = in.next();
            switch (command) {
                case "push_front" -> {
                    deque.pushFront(in.nextInt());
                    out.println("ok");
                }
                case "push_back" -> {
                    deque.pushBack(in.nextInt());
                    out.println("ok");
                }
                case "pop_front" -> {
                    if (deque.last == null) {
                        out.println("error");
                    } else {
                        out.println(deque.popFront());
                    }
                }
                case "pop_back" -> {
                    if (deque.last == null) {
                        out.println("error");
                    } else {
                        out.println(deque.popBack());
                    }
                }
                case "front" -> {
                    if (deque.last == null) {
                        out.println("error");
                    } else {
                        out.println(deque.front());
                    }
                }
                case "back" -> {
                    if (deque.last == null) {
                        out.println("error");
                    } else {
                        out.println(deque.back());
                    }
                }
                case "size" -> {
                    out.println(deque.size());
                }
                case "clear" -> {
                    deque.clear();
                    out.println("ok");
                }
                case "exit" -> {
                    out.println("bye");
                    return;
                }
            }
        }
    }

    private static class Deque {
        private Node first;
        private Node last;
        private int size;

        public void pushFront(int value) {
            size++;
            if (first == null) {
                first = new Node(value);
                last = first;
                return;
            }
            Node node = new Node(value);
            node.next = first;
            first.prev = node;
            first = node;

        }

        public void pushBack(int value) {
            size++;
            if (first == null) {
                first = new Node(value);
                last = first;
                return;
            }
            Node node = new Node(value);
            node.prev = last;
            last.next = node;
            last = node;

        }

        public int popFront() {
            size--;
            int value = first.value;
            if (size == 0) {
                first = null;
                last = null;
            } else {
                first = first.next;
                first.prev = null;
            }
            return value;
        }

        public int popBack() {
            size--;
            int value = last.value;
            if (size == 0) {
                first = null;
                last = null;
            } else {
                last = last.prev;
                last.next = null;
            }
            return value;
        }

        public int front() {
            return first.value;
        }

        public int back() {
            return last.value;
        }

        public int size() {
            return size;
        }

        public void clear() {
            first = null;
            last = null;
            size = 0;
        }

        private static class Node {
            private int value;
            private Node next;
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
