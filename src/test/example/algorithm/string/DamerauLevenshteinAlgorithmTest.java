package test.example.algorithm.string;

import com.example.algorithm.string.DamerauLevenshteinAlgorithm;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for DamerauLevenshteinAlgorithm.
 */
public class DamerauLevenshteinAlgorithmTest {
  @Test
  public void test() {
    Assert.assertEquals(7, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("NawKtYu", ""));

    Assert.assertEquals(7, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("", "NawKtYu"));

    Assert.assertEquals(0, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("NawKtYu", "NawKtYu"));

    Assert.assertEquals(6, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("NawKtYu", "tKNwYua"));

    Assert.assertEquals(1, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("Jdc", "dJc"));

    Assert.assertEquals(5, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("sUzSOwx", "zsSxUwO"));

    Assert.assertEquals(7, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("eOqoHAta", "tAeaqHoO"));

    Assert.assertEquals(1, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("glSbo", "lgSbo"));

    Assert.assertEquals(4, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("NJtQKcJE", "cJEtQKJN"));

    Assert.assertEquals(5, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("GitIEVs", "EGItVis"));

    Assert.assertEquals(4, new DamerauLevenshteinAlgorithm(1, 1, 1, 1)
        .execute("MiWK", "WKiM"));
  }

  @Test
  public void testCosts() {
    /*
     * Test replace cost.
     */
    Assert.assertEquals(1, new DamerauLevenshteinAlgorithm(100, 100, 1, 100)
        .execute("a", "b"));
    /*
     * Test swap cost.
     */
    Assert.assertEquals(200,
                        new DamerauLevenshteinAlgorithm(100, 100, 100, 200)
                            .execute("ab", "ba"));
    /*
     * Test delete cost.
     */
    Assert.assertEquals(1, new DamerauLevenshteinAlgorithm(1, 100, 100, 100)
        .execute("aa", "a"));
    /*
     * Test insert cost.
     */
    Assert.assertEquals(1, new DamerauLevenshteinAlgorithm(100, 1, 100, 100)
        .execute("a", "aa"));
  }

  @Test
  public void testInvalidCosts() {
    try {
      new DamerauLevenshteinAlgorithm(1, 1, 1, 0);
      Assert.fail();
    } catch (IllegalArgumentException e) {

    }
  }
}
