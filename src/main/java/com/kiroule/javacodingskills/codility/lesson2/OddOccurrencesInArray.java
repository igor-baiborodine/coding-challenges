package com.kiroule.javacodingskills.codility.lesson2;

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
    Set<Map.Entry<Integer, Integer>> entries = numberToCountMap.entrySet();
    Map.Entry<Integer, Integer> firstEntry = entries.iterator().next();
    int unpairedNumber = firstEntry.getKey();

    // special case when the input array contains 3 elements
    if (entries.size() == 2
        && firstEntry.getValue() == 2) {
      unpairedNumber = entries.iterator().next().getKey();
    }
    return unpairedNumber;
  }

}
