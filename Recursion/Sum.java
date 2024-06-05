public class Sum {

  public static void main(String[] args) {
      Sum sumCalculator = new Sum();
      System.out.println(sumCalculator.sum(5)); // Example usage, should output 15
  }

  // Method to find the sum of values from 0 to n
  public int sum(int n) {
      // Base case: if n is 0, the sum is 0
      if (n == 0) {
          return 0;
      } else {
          // Recursive case: add n to the sum of values from 0 to (n - 1)
          return n + sum(n - 1);
      }
  }
}
//Error the recursive call sum(n) does not reduce the value of n. This will cause infinite recursion if n is not zero, leading to a StackOverflowError.
//This will print 15 because sum(5) calculates 5 + 4 + 3 + 2 + 1 + 0, which equals 15.
