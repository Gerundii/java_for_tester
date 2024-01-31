package my.pack.addressbook;

import my.pack.sandbox.Equation;
import my.pack.sandbox.Primes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {

    @Test(description = "Число простое")
    public void testNumberIsPrime() {
        Assert.assertTrue(Primes.isPrime(7));
    }

    @Test(description = "Число не простое")
    public void testNumberIsNotPrime() {
        Assert.assertFalse(Primes.isPrime(9));
    }

    @Test(description = "Число простое")
    public void testNumberIsPrimeWhile() {
        Assert.assertTrue(Primes.isPrimeWhile(7));
    }

    @Test(description = "Число не простое")
    public void testNumberIsNotPrimeWhile() {
        Assert.assertFalse(Primes.isPrimeWhile(9));
    }
}
