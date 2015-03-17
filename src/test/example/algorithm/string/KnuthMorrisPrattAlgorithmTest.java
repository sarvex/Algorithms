package test.example.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for KnuthMorrisPrattAlgorithm.
 */
public class KnuthMorrisPrattAlgorithmTest {
  @Test
  public void test1() {
    String needle = "needle";
    String haystack = "It's like searching for a needle in a haystack.";
    Assert
        .assertEquals(haystack.indexOf(needle), new KnuthMorrisPrattAlgorithm(
            needle).execute(haystack));
  }

  @Test
  public void test2() {
    String needle = "01012";
    String haystack = "010101012";
    Assert
        .assertEquals(haystack.indexOf(needle), new KnuthMorrisPrattAlgorithm(
            needle).execute(haystack));
  }

  @Test
  public void test3() {
    String needle = "0101";
    String haystack = "0102020101";
    Assert
        .assertEquals(haystack.indexOf(needle), new KnuthMorrisPrattAlgorithm(
            needle).execute(haystack));
  }

  @Test
  public void test4() {
    String needle = "aaaaaaa";
    String haystack = "aaaaaab";
    Assert
        .assertEquals(haystack.indexOf(needle), new KnuthMorrisPrattAlgorithm(
            needle).execute(haystack));
  }

  @Test
  public void test5() {
    String needle = "aaaaaaa";
    String haystack = "aaaaaaa";
    Assert.assertEquals(haystack.indexOf(needle, 1),
                        new KnuthMorrisPrattAlgorithm(needle).execute(haystack,
                                                                      1));
  }

  @Test
  public void test6() {
    String needle = "aa";
    String haystack = "aaaaaaa";
    Assert.assertEquals(haystack.indexOf(needle, 1),
                        new KnuthMorrisPrattAlgorithm(needle).execute(haystack,
                                                                      1));
  }
}
