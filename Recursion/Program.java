public class Program{

    public static void main(String[] arg){
        System.out.println(LCD(15,25));
    }

    public static int LCD(int a, int b){
        // switch a and b to be smaller and larger 
        if (a > b){
            int larger = a;
            a = b;
            b = larger;
        }

        // base case
        if (b % a == 0){
            return b;
        }
        else{
            return b * LCD(b-a, a) / (b-a);
        }
    }
}