package com.kiroule.javacodingskills.codility.lesson2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

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
    assertArrayEquals(input, result);
  }

  @Test
  public void solution_fiveElementArrayAndTenRotations_arrayRotatedFiveTimes() throws Exception {
    // given
    int[] input = new int[] {1, 2, 3, 4, 5};
    int rotations = 10;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertArrayEquals(input, result);
  }

  @Test
  public void solution_fourElementArrayAndOneRotation_arrayRotatedOneTime() throws Exception {
    // given
    int[] input = new int[] {1, 2, 3, 4};
    int rotations = 1;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertArrayEquals(new int[] {4, 1, 2, 3}, result);
  }

  @Test
  public void solution_fourElementArrayAndTwoRotations_arrayRotatedTwoTimes() throws Exception {
    // given
    int[] input = new int[] {1, 2, 3, 4};
    int rotations = 2;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertArrayEquals(new int[] {3, 4, 1, 2}, result);
  }

  @Test
  public void solution_fourElementArrayAndThreeRotations_arrayRotatedThreeTimes() throws Exception {
    // given
    int[] input = new int[] {1, 2, 3, 4};
    int rotations = 3;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertArrayEquals(new int[] {2, 3, 4, 1}, result);
  }

  @Test
  public void solution_fourElementArrayAndSixRotations_arrayRotatedTwoTimes() throws Exception {
    // given
    int[] input = new int[] {1, 2, 3, 4};
    int rotations = 6;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertArrayEquals(new int[] {3, 4, 1, 2}, result);
  }

  @Test
  public void solution_fiveElementArrayAndThreeRotations_arrayRotatedThreeTimes() throws Exception {
    // given
    int[] input = new int[] {3, 8, 9, 7, 6};
    int rotations = 3;
    // when
    int[] result = cyclicRotation.solution(input, rotations);
    // then
    assertArrayEquals(new int[] {9, 7, 6, 3, 8}, result);
  }

}