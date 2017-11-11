package com.kiroule.javacodingskills.codility.lesson3;

/**
 * @author Igor Baiborodine
 *
 * @see ../FROG_JMP_README.md
 */
public class FrogJmp {

  public int solution(int X, int Y, int D) {
    final int jump = Y - X;
    if (jump == 0) {
      return 0;
    } else if (jump < D) {
      return 1;
    } else if (jump % D == 0) {
      return jump / D;
    } else {
      return (int) Math.ceil(((double) jump) / D);
    }
  }

}
