package test.example.algorithm.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for ClosestPointPairAlgorithm.
 */
public class ClosestPointPairAlgorithmTest {
  private static Point2D[] sort(Point2D[] points) {
    Arrays.sort(points, (o1, o2) -> {
      double d = o1.getX() - o2.getX();
      if (d == 0) {
        d = o1.getY() - o2.getY();
      }
      return d < 0 ? -1 : d > 0 ? 1 : 0;
    });
    return points;
  }

  @Test
  public void testBaseCase2Points() {
    Point2D p1 = new Point2D.Double(.49, .5);
    Point2D p2 = new Point2D.Double(.5, .2);

    List<Point2D> list = new ArrayList<Point2D>();
    list.add(p1);
    list.add(p2);
    Assert.assertTrue(Arrays.equals(
        new Point2D[] { p1, p2 },
        sort(new ClosestPointPairAlgorithm(list).execute())));

  }

  @Test
  public void testBaseCase3Points() {
    Point2D p1 = new Point2D.Double(.49, .5);
    Point2D p2 = new Point2D.Double(.5, .2);
    Point2D p3 = new Point2D.Double(.51, .5);

    List<Point2D> list = new ArrayList<Point2D>();
    list.add(p1);
    list.add(p2);
    list.add(p3);
    Assert.assertTrue(Arrays.equals(
        new Point2D[] { p1, p3 },
        sort(new ClosestPointPairAlgorithm(list).execute())));

  }

  @Test
  public void testBasic() {
    Point2D p1 = new Point2D.Double(.49, .5);
    Point2D p2 = new Point2D.Double(.51, .5);

    List<Point2D> list = new ArrayList<Point2D>();
    list.add(p1);
    list.add(p2);
    list.add(new Point2D.Double(.6, .5));
    list.add(new Point2D.Double(.7, .5));
    list.add(new Point2D.Double(.8, .5));
    Assert.assertTrue(Arrays.equals(
        new Point2D[] { p1, p2 },
        sort(new ClosestPointPairAlgorithm(list).execute())));
  }

  @Test
  public void testSplitMergeProcedure() {
    Point2D p1 = new Point2D.Double(.49, .5);
    Point2D p2 = new Point2D.Double(.51, .5);

    List<Point2D> list = new ArrayList<Point2D>();
    list.add(p1);
    list.add(p2);
    list.add(new Point2D.Double(.5, .2));
    list.add(new Point2D.Double(.4, .5));
    list.add(new Point2D.Double(.6, .5));
    Assert.assertTrue(Arrays.equals(
        new Point2D[] { p1, p2 },
        sort(new ClosestPointPairAlgorithm(list).execute())));
  }
}
