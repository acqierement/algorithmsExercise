public class Recursion02 {
    public static int factorial(int n){
        if(n < 0) throw new IllegalArgumentException("必须为整数");
        if(n == 0) return 1;
        return n * factorial(n - 1);
    }

}
