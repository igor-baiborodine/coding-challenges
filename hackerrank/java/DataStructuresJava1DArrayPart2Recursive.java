import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * This implementation is based on the Depth First Search algorithm:
 * https://algocoding.wordpress.com/2014/08/25/depth-first-search-java-and-python-implementation/
 */
public class DataStructuresJava1DArrayPart2Recursive {

    private static boolean canWinResult;

    public static void main(String[] args) {
        int leap;
        int[] game;

        if (args.length == 0) {
            Scanner scan = new Scanner(System.in);
            int q = scan.nextInt();
            while (q-- > 0) {
                int n = scan.nextInt();
                leap = scan.nextInt();

                game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }
                System.out.println((canWin(leap, game)) ? "YES" : "NO");
            }
            scan.close();
        } else {
            try (BufferedReader br = Files.newBufferedReader(Paths.get(args[0]));
                    Stream<String> output = Files.lines(Paths.get(args[1]))) {

                int q = Integer.parseInt(br.readLine());
                String[] expected = output
                        .map(String::trim)
                        .toArray(String[]::new);

                for (int i = 0; i < q; i++) {
                    String line = br.readLine();
                    leap = Integer.parseInt(line.split("\\s")[1]);
                    game = Arrays.stream(br.readLine().split("\\s"))
                            .mapToInt(Integer::parseInt)
                            .toArray();

                    String actual = (canWin(leap, game)) ? "YES" : "NO";
                    System.out.printf("%s -> %s, %s%n", line, actual, expected[i]);
                    if (!actual.equals(expected[i])) {
                        throw new RuntimeException("Actual vs. expected mismatch");
                    }
                    canWinResult = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean canWin(int leap, int[] game) {

        boolean[] visited = new boolean[game.length];
        int startIndex = 0;
        canWinRecursive(leap, game, visited, startIndex);
        return canWinResult;
    }

    public static void canWinRecursive(int leap, int[] game, boolean[] visited, int currentIndex) {
        if (canWinResult) {
            return;
        }
        visited[currentIndex] = true;
        Map<Integer, Integer> nextMoveToIndexMap = getAvailableMoveIndexes(currentIndex, leap, game);

        if (canWalkOrJumpOff(leap, game.length, nextMoveToIndexMap)) {
            canWinResult = true;
        } else {
            for (int i : nextMoveToIndexMap.values()) {
                if (!visited[i]) {
                    canWinRecursive(leap, game, visited, i);
                }
            }
        }
    }
    private static Map<Integer, Integer> getAvailableMoveIndexes(int currentIndex, int leap, int[] game) {
        Map<Integer, Integer> result = new LinkedHashMap<>();

        if (leap > 1
                && (currentIndex + leap >= game.length
                || game[currentIndex + leap] == 0)) {
            result.put(leap, currentIndex + leap);
        }
        if (currentIndex == game.length - 1
                || game[currentIndex + 1] == 0) {
            result.put(1, currentIndex + 1);
        }
        if (currentIndex > 0
                && game[currentIndex - 1] == 0) {
            result.put(-1, currentIndex - 1);
        }
        return result;
    }

    private static boolean canWalkOrJumpOff(int leap, int length, Map<Integer, Integer> moveToIndexMap) {
        return moveToIndexMap.getOrDefault(leap, 0) >= length - 1
                || moveToIndexMap.getOrDefault(1, 0) == length - 1;
    }

}
