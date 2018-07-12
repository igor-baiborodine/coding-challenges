import java.util.*;

/**
 * @see ../data-structures_java-dequeue_task.pdf
 */
public class DataStructuresJavaDequeue {

    public static void main(String...args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> deque = new ArrayDeque<>(m);
        Set<Integer> uniqueNums = new HashSet<>(m);
        int maxUniqueNumCount = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.offerFirst(num);
            uniqueNums.add(num);

            if (deque.size() == m + 1) {
                Integer lastNum = deque.pollLast();
                if (!deque.contains(lastNum)) {
                    uniqueNums.remove(lastNum);
                }
            }

            int curUniqueNumCount = uniqueNums.size();
            if (curUniqueNumCount > maxUniqueNumCount) {
                maxUniqueNumCount = curUniqueNumCount;
            }
        }
        in.close();
        System.out.println(maxUniqueNumCount);
    }
}
