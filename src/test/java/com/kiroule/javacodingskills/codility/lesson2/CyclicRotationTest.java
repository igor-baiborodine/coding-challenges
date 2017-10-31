package com.kiroule.javacodingskills.codility.lesson2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Igor Baiborodine
 */
public class CyclicRotationTest {

  private CyclicRotation cyclicRotation = new CyclicRotation();

  @Test
  public void solution_emptyArrayAndZeroRotations_emptyArray() throws Exception {
    // given
    int[] input = new int[] {};
    int rotations = 0;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertThat(result.length, is(input.length));
  }

  @Test
  public void solution_oneElementArrayAndZeroRotations_oneElementArray() throws Exception {
    // given
    int[] input = new int[] {1};
    int rotations = 0;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertThat(result.length, is(input.length));
    assertArrayEquals(input, result);
  }

  @Test
  public void solution_fiveElementArrayAndFiveRotations_arrayRotatedFiveTimes() throws Exception {
    // given
    int[] input = new int[] {1, 2, 3, 4, 5};
    int rotations = 5;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertThat(result.length, is(input.length));
    assertArrayEquals(input, result);
  }

  // TODO: implement more unit tests
  @Test
  public void solution() throws Exception {
    // given

    // when

    // then
  }

}