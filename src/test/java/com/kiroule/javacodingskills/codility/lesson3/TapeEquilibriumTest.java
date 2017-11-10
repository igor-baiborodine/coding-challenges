package com.kiroule.javacodingskills.codility.lesson3;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Igor Baiborodine
 */
public class TapeEquilibriumTest {

  private TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();

  @Test
  public void solution() throws Exception {
    assertThat(tapeEquilibrium.solution(new int[]{0, 0}), is(0));
    assertThat(tapeEquilibrium.solution(new int[]{1, 0}), is(1));
    assertThat(tapeEquilibrium.solution(new int[]{-1, 0}), is(1));
    assertThat(tapeEquilibrium.solution(new int[]{1, -1}), is(2));
    assertThat(tapeEquilibrium.solution(new int[]{1, 1}), is(0));

    assertThat(tapeEquilibrium.solution(new int[]{1, 1, 1}), is(1));
    assertThat(tapeEquilibrium.solution(new int[]{1, -1, 1}), is(1));
    assertThat(tapeEquilibrium.solution(new int[]{1, 2, 3}), is(0));

    assertThat(tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}), is(1));
    assertThat(tapeEquilibrium.solution(new int[]{1, 1, 10, 10, 1, 10}), is(9));
    assertThat(tapeEquilibrium.solution(new int[]{1, 1, 10, 10, 1, -10}), is(9));
    assertThat(tapeEquilibrium.solution(new int[]{1, 1, -10, 10, 1, -10}), is(9));
  }

}