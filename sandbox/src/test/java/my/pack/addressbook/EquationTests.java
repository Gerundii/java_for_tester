package my.pack.addressbook;

import my.pack.sandbox.Equation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

    @Test (description = "Квадратное уравнение не имеет корней, дискриминант меньше нуля")
    public void test0() {
        Equation e = new Equation(1, 1, 1);
        Assert.assertEquals(e.rootNubmer(), 0);
    }

    @Test (description = "Квадратное уравнение имеет один корень, дискриминант равен нулю")
    public void test1() {
        Equation e = new Equation(1, 2, 1);
        Assert.assertEquals(e.rootNubmer(), 1);
    }

    @Test (description = "Квадратное уравнение имеет два корня, дискриминант больше нуля")
    public void test2() {
        Equation e = new Equation(1, 5, 6);
        Assert.assertEquals(e.rootNubmer(), 2);
    }
}
