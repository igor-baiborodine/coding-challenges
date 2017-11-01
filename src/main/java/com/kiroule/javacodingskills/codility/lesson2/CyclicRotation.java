package com.kiroule.javacodingskills.codility.lesson2;

/**
 * @author Igor Baiborodine
 *
 * @see ../CYCLIC_ROTATION_README.md
 */
public class CyclicRotation {

  public int[] solution(int[] A, int K) {
    if (A.length <= 1
        || (K >= A.length && K % A.length == 0)) {
      return A;
    }
    if (K > A.length) {
      K = K % A.length;
    }

    rotations:
    for (int i = 0; i < K; i++) {
      int lastElement = A[A.length - 1];
      elements:
      for (int j = A.length - 1; j > 0; j--) {
        A[j] = A[j - 1];
      }
      A[0] = lastElement;
    }
    return A;
  }

}