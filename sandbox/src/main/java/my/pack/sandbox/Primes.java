package my.pack.sandbox;

public class Primes {
    public static boolean isPrime(int m) {
        for (int n = 2; n < m; n++){
            if(m % n == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPrimeWhile(int m) {
        int n = 2;
        while (n < m) {
            if (m % n == 0) {
                return false;
            }
            n++;
        }
        return true;
    }
}