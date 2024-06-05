public class Mystery {
public static void main(String[] args) {
   Mystery mystery = new Mystery();
   System.out.println(mystery.mystery(5, 3)); // Example usage
}
public int mystery(int a, int b) {

   //Base case if b is 1, return a 
 if (b == 1) {
 return a;
 }
//Rescuresive case: add a to the result of mystery(a, b - 1)
 else {

 return a + mystery(a, b - 1);

    }

 }
}
//The base case is when b is 1. In this case, the function returns a.
//In the recursive case, the function returns a plus the result of calling itself with a and b - 1.
//Effectively, this function is multiplying a by b by adding a to itself b times.