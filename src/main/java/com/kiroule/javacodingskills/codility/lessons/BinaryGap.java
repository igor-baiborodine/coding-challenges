package com.kiroule.javacodingskills.codility.lessons;

/**
 * @author Igor Baiborodine
 *
 * Reference: https://codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class BinaryGap {

  public int solution(int N) {

    int maxBinaryGap = 0;
    int currentBinaryGap = 0;
    int previousRemainder = -1;

    while (N != 0) {
      int currentRemainder = N % 2;

      if (currentRemainder == 0) {
        if (previousRemainder == 1) { // started new binary gap
          currentBinaryGap = 1;
        } else if (previousRemainder == 0
            && currentBinaryGap > 0) { // continue current binary gap
          currentBinaryGap++;
        }
      } else { // currentRemainder == 1
        if (previousRemainder == 0) { // completed current binary gap
          if (currentBinaryGap > maxBinaryGap) {
            maxBinaryGap = currentBinaryGap;
            currentBinaryGap = 0;
          }
        }
      }
      previousRemainder = currentRemainder;
      N /= 2;
    }

    return maxBinaryGap;
  }

}