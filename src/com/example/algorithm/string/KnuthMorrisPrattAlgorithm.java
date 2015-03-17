package com.example.algorithm.string;

/**
 * An implementation of the Knuth Morris Pratt substring search algorithm. An
 * instance of the algorithm is constructed around a needle string of length m,
 * a process which consumes O(m) time as well as O(m) space. Once an instance is
 * constructed, it is capable of searching for the needle string in any number
 * of haystack strings. The search process consumes O(n) time in a haystack
 * string of length n.
 */
public class KnuthMorrisPrattAlgorithm {
  private final String needle;
  private final int[] stateTransitionTable;

  /**
   * Constructor.
   * 
   * @param needle
   *          the search string for which the instance will be constructed.
   */
  public KnuthMorrisPrattAlgorithm(String needle) {
    this.needle = needle;
    this.stateTransitionTable = new int[needle.length()];
    stateTransitionTable[0] = -1;
    int state = 0;
    for (int i = 1; i < needle.length(); i++) {
      int transition = state;
      if (needle.charAt(transition) == needle.charAt(i)) {
        transition = stateTransitionTable[transition];
      }
      stateTransitionTable[i] = transition;
      if (needle.charAt(i) == needle.charAt(state)) {
        state += 1;
      } else {
        state = 0;
      }
    }
  }

  /**
   * Execute the search algorithm.
   * 
   * @param haystack
   *          the string in which to search for the needle specified at
   *          construction time.
   * @return the index of the first occurrence of the needle string within the
   *         specified haystack string, -1 if none.
   */
  public int execute(String haystack) {
    return execute(haystack, 0);
  }

  /**
   * Execute the search algorithm.
   * 
   * @param haystack
   *          the string in which to search for the needle specified at
   *          construction time.
   * @param index
   *          the index at which to begin the search within the haystack string.
   * @return the index of the first occurrence of the needle string within the
   *         specified portion of the haystack string, -1 if none.
   */
  public int execute(String haystack, int index) {
    int state = 0;
    for (int i = index; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(state)) {
        state += 1;
        if (state == needle.length()) {
          return i - needle.length() + 1;
        }
      } else {
        do {
          state = stateTransitionTable[state];
        } while (state >= 0 && haystack.charAt(i) != needle.charAt(state));
        state += 1;
      }
    }
    return -1;
  }
}
