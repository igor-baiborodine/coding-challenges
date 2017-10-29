package com.kiroule.javacodingskills.codility.lesson1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Igor Baiborodine
 */
public class BinaryGapTest {

  @Test
  public void solution() {
    BinaryGap binaryGap = new BinaryGap();
    assertThat(binaryGap.solution(5), is(1));
    assertThat(binaryGap.solution(5728), is(2));
    assertThat(binaryGap.solution(9), is(2));
    assertThat(binaryGap.solution(529), is(4));
    assertThat(binaryGap.solution(20), is(1));
    assertThat(binaryGap.solution(15), is(0));
    assertThat(binaryGap.solution(1041), is(5));
  }

}