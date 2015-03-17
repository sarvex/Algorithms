package test.example.algorithm.structure;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for OrderLinkedRedBlackTree.
 */
public class OrderLinkedRedBlackTreeTest {
  @Test
  public void testNull() {
    OrderLinkedRedBlackTree<Integer> tree = new OrderLinkedRedBlackTree<Integer>();
    try {
      tree.insert(null);
      Assert.fail();
    } catch (NullPointerException e) {

    }
    try {
      tree.getPredecessor(null);
      Assert.fail();
    } catch (NullPointerException e) {

    }
    try {
      tree.getSuccessor(null);
      Assert.fail();
    } catch (NullPointerException e) {

    }
    Assert.assertNull(tree.delete(null));
    Assert.assertNull(tree.getNode(null));
    Assert.assertFalse(tree.contains(null));

    tree.insert(0);
    try {
      tree.insert(null);
      Assert.fail();
    } catch (NullPointerException e) {

    }
    try {
      tree.getPredecessor(null);
      Assert.fail();
    } catch (NullPointerException e) {

    }
    try {
      tree.getSuccessor(null);
      Assert.fail();
    } catch (NullPointerException e) {

    }
    Assert.assertNull(tree.delete(null));
    Assert.assertNull(tree.getNode(null));
    Assert.assertFalse(tree.contains(null));
  }

  @Test
  public void testPredecessor() {
    List<Integer> master = new ArrayList<Integer>();
    OrderLinkedRedBlackTree<Integer> tree = new OrderLinkedRedBlackTree<Integer>();
    for (int j = 0; j < 100; j++) {
      tree.insert(j);
      master.add(j);
    }
    while (!master.isEmpty()) {
      for (int j = 1; j < master.size(); j++) {
        Assert.assertEquals(master.get(j - 1),
                            tree.getPredecessor(tree.getNode(master.get(j)))
                                .getValue());
      }
      Assert.assertNull(tree.getPredecessor(tree.getNode(master.get(0))));
      int index = master.size() >> 1;
      tree.delete(master.get(index));
      master.remove(index);
    }
  }

  @Test
  public void testSuccessor() {
    List<Integer> master = new ArrayList<Integer>();
    OrderLinkedRedBlackTree<Integer> tree = new OrderLinkedRedBlackTree<Integer>();
    for (int j = 0; j < 100; j++) {
      tree.insert(j);
      master.add(j);
    }
    while (!master.isEmpty()) {
      for (int j = 0; j < master.size() - 1; j++) {
        Assert.assertEquals(master.get(j + 1),
                            tree.getSuccessor(tree.getNode(master.get(j)))
                                .getValue());
      }
      Assert
          .assertNull(tree.getSuccessor(tree.getNode(master.get(master.size() - 1))));
      int index = master.size() >> 1;
      tree.delete(master.get(index));
      master.remove(index);
    }
  }
}
