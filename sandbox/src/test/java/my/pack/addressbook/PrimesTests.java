package my.pack.addressbook;

import my.pack.sandbox.Equation;
import my.pack.sandbox.Primes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {

    @Test(description = "Число простое")
    public void testNumberIsPrime() {
        /*boolean isPrime = Primes.isPrime(7);
        Assert.assertEquals(isPrime, true);*/
        Assert.assertTrue(Primes.isPrime(7));
    }

    @Test(description = "Число не простое")
    public void testNumberIsNotPrime() {
        /*boolean isPrime = Primes.isPrime(8);
        Assert.assertEquals(isPrime, false);*/
        Assert.assertFalse(Primes.isPrime(9));
    }

    @Test(description = "Число простое")
    public void testNumberIsPrimeWhile() {
        /*boolean isPrime = Primes.isPrime(7);
        Assert.assertEquals(isPrime, true);*/
        Assert.assertTrue(Primes.isPrimeWhile(7));
    }

    @Test(description = "Число не простое")
    public void testNumberIsNotPrimeWhile() {
        /*boolean isPrime = Primes.isPrime(8);
        Assert.assertEquals(isPrime, false);*/
        Assert.assertFalse(Primes.isPrimeWhile(9));
    }
}
