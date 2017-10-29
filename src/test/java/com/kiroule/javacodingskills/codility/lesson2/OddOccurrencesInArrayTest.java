package com.kiroule.javacodingskills.codility.lesson2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Igor Baiborodine
 */
public class OddOccurrencesInArrayTest {
  @Test
  public void solution() throws Exception {
    OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
    assertThat(oddOccurrencesInArray.solution(new int[]{ }), is(0));
    assertThat(oddOccurrencesInArray.solution(new int[]{1, 1}), is(0));
    assertThat(oddOccurrencesInArray.solution(new int[]{1}), is(1));

    assertThat(oddOccurrencesInArray.solution(new int[]{1, 2, 1}), is(2));
    assertThat(oddOccurrencesInArray.solution(new int[]{2, 1, 1}), is(2));
    assertThat(oddOccurrencesInArray.solution(new int[]{1, 1, 2}), is(2));

    assertThat(oddOccurrencesInArray.solution(new int[]{1, 1, 2, 2, 3}), is(3));
    assertThat(oddOccurrencesInArray.solution(new int[]{3, 2, 2, 1, 1}), is(3));
    assertThat(oddOccurrencesInArray.solution(new int[]{1, 1, 3, 2, 2}), is(3));

    assertThat(oddOccurrencesInArray.solution(new int[]{1, 2, 1, 2, 3}), is(3));
    assertThat(oddOccurrencesInArray.solution(new int[]{3, 1, 2, 1, 2}), is(3));
    assertThat(oddOccurrencesInArray.solution(new int[]{1, 2, 3, 2, 1}), is(3));

    assertThat(oddOccurrencesInArray.solution(new int[] {4, 4, 5, 4, 4}), is(5));
    assertThat(oddOccurrencesInArray.solution(new int[] {9, 3, 9, 3, 9, 7, 9}), is(7));
    assertThat(oddOccurrencesInArray.solution(new int[] {1, 2, 2, 1, 3, 3, 4}), is(4));
    assertThat(oddOccurrencesInArray.solution(new int[] {1, 2, 3, 4, 1, 2, 3}), is(4));
  }

}