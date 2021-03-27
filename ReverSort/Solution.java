package ReverSort;

import java.math.BigInteger;
import java.util.Scanner;

/** Solution */
public class Solution {
  private static final Scanner SCANNER = new Scanner(System.in);

  private static int[] createArray(int len) {
    int[] array = new int[len];

    for (int i = 0; i < len; i++) array[i] = SCANNER.nextInt();

    return array;
  }

  private static void reverse(int fromIdx, int toIdx, int[] array) {
    while (fromIdx <= toIdx) {
      int temp = array[fromIdx];
      array[fromIdx] = array[toIdx];
      array[toIdx] = temp;

      ++fromIdx;
      --toIdx;
    }
  }

  private static BigInteger costOfReverseSort(int[] array) {
    BigInteger cost = new BigInteger("0");
    int len = array.length;

    for (int i = 0; i < len - 1; ++i) {
      int minIdx = -1;
      int minNum = Integer.MAX_VALUE;

      for (int j = len - 1; j >= i; --j) {
        if (minNum > array[j]) {
          minNum = array[j];
          minIdx = j;
        }
      }

      reverse(i, minIdx, array);

      cost = cost.add(new BigInteger(String.valueOf(minIdx - i + 1)));
    }

    return cost;
  }

  public static void main(String[] args) {
    int testCases = SCANNER.nextInt();
    int caseNumber = 0;

    while (testCases-- > 0) {
      int n = SCANNER.nextInt();
      ++caseNumber;

      int[] array = createArray(n);

      BigInteger cost = costOfReverseSort(array);

      System.out.println("Case #" + caseNumber + ": " + cost);
    }

    SCANNER.close();
  }
}
