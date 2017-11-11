package com.kiroule.javacodingskills.codility.lesson3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Igor Baiborodine
 */
public class FrogJmpTest {

  private FrogJmp frogJmp = new FrogJmp();

  @Test
  public void solution() throws Exception {
    assertThat(frogJmp.solution(1, 1, 1), is(0));
    assertThat(frogJmp.solution(1, 2, 1), is(1));
    assertThat(frogJmp.solution(1, 2, 2), is(1));
    assertThat(frogJmp.solution(1, 3, 1), is(2));
    assertThat(frogJmp.solution(1, 6, 2), is(3));
    assertThat(frogJmp.solution(10, 85, 30), is(3));
  }

}