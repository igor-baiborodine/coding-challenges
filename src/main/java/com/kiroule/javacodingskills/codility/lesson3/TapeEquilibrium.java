package com.kiroule.javacodingskills.codility.lesson3;

/**
 * @author Igor Baiborodine
 *
 * @see ../TAPE_EQUILIBRIUM_README.md
 */
public class TapeEquilibrium {

  public int solution(int[] A) {
    for (int i = 1; i < A.length; i++) {
      A[i] = A[i - 1] + A[i];
    }
    int minDiff = Math.abs(A[0] * 2 - A[A.length - 1]);
    //int minDiffIndex = 1;

    for (int i = 1; i < A.length - 1; i++) {
      int diff = Math.abs(A[i] * 2 - A[A.length - 1]);
      if (diff < minDiff) {
        minDiff = diff;
        //minDiffIndex = i + 1;
      }
    }
    //System.out.println("min diff index: " + minDiffIndex);
    return minDiff;
  }

}
