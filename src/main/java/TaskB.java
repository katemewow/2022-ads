import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskB {
    private TaskB() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        String command;
        Queue queue = new Queue();
        while (true) {
            command = in.next();
            switch (command) {
                case "push" -> {
                    queue.push(in.nextInt());
                    out.println("ok");
                }
                case "pop" -> {
                    if (queue.first == null) {
                        out.println("error");
                    } else {
                        out.println(queue.pop());
                    }
                }
                case "front" -> {
                    if (queue.first == null) {
                        out.println("error");
                    } else {
                        out.println(queue.front());
                    }
                }
                case "size" -> {
                    out.println(queue.size());
                }
                case "clear" -> {
                    queue.clear();
                    out.println("ok");
                }
                case "exit" -> {
                    out.println("bye");
                    return;
                }
            }
        }
    }

    private static class Queue{
        private Node first;
        private Node last;
        private int size;

        public void push(int value){
            size++;
            if (first == null){
                first = new Node(value);
                last = first;
                return;
            }
            last.next = new Node(value);
            last = last.next;
        }

        public int pop(){
            size--;
            int value = first.value;
            first = first.next;
            return value;
        }

        public int front(){
            return first.value;
        }

        public int size(){
            return size;
        }

        public void clear(){
            first = null;
            last = null;
            size = 0;
        }

        private static class Node {
            private int value;
            private Node next;

            public Node(int value){
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
