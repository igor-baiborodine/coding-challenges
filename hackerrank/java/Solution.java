import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {

    private static BitSet[] b;

    public static void main(String[] args) {

        if (args.length == 2) {
            try (BufferedReader br = Files.newBufferedReader(Paths.get(args[0]));
                    Stream<String> output = Files.lines(Paths.get(args[1]))) {
                String[] tokens = br.readLine().split("\\s");
                int n = Integer.parseInt(tokens[0]);
                int m = Integer.parseInt(tokens[1]);

                String[] expected = output
                        .map(String::trim)
                        .toArray(String[]::new);
                b = new BitSet[]{new BitSet(n), new BitSet(n)};

                for (int k = 0; k < m; k++) {
                    String line = br.readLine();
                    tokens = line.split("\\s");
                    String operation = tokens[0];
                    int n1 = Integer.parseInt(tokens[1]) - 1;
                    int n2 = Integer.parseInt(tokens[2]);

                    executeOperation(operation, n1, n2);
                    String actual = b[0].cardinality() + " " + b[1].cardinality();
                    System.out.printf("%s -> %s, %s%n", line, actual, expected[k]);
                    if (!actual.equals(expected[k])) {
                        throw new RuntimeException("Actual vs. expected mismatch");
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            b = new BitSet[]{new BitSet(n), new BitSet(n)};

            while (m-- > 0) {
                in.nextLine();
                String operation = in.next();
                int n1 = in.nextInt() - 1;
                int n2 = in.nextInt();

                executeOperation(operation, n1, n2);
                System.out.println(b[0].cardinality() + " " + b[1].cardinality());
            }
        }
    }

    private static void executeOperation(String operation, int n1, int n2) {

        switch (operation) {
        case "AND":
            b[n1].and(b[n2 - 1]);
            break;
        case "OR":
            b[n1].or(b[n2 - 1]);
            break;
        case "XOR":
            b[n1].xor(b[n2 - 1]);
            break;
        case "FLIP":
            b[n1].flip(n2);
            break;
        case "SET":
            b[n1].set(n2);
            break;
        default:
            // do nothing
        }
    }
}
