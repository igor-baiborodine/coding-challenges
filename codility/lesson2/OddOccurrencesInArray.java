import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Igor Baiborodine (dfo5057)
 *
 * @see ../ODD_OCCURENCES_IN_ARRAY_README.md
 */
public class OddOccurrencesInArray {

  public int solution(int[] A) {
    if (A.length % 2 == 0) {
      return 0;
    }
    HashMap<Integer, Integer> numberToCountMap = new HashMap<>();

    for (int i = 0; i < A.length; i++) {
      int count = numberToCountMap.getOrDefault(A[i], 0);
      if (count == 0) {
        numberToCountMap.put(A[i], 1);
      } else if (count == 1) {
        numberToCountMap.remove(A[i]);
      }
    }
    return numberToCountMap.keySet().iterator().next();
  }

}
