package my.pack.addressbook;

import my.pack.sandbox.Equation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

    @Test (description = "Квадратное уравнение не имеет корней, дискриминант меньше нуля")
    public void testDiscriminantLessThanZero() {
        Equation e = new Equation(1, 1, 1);
        Assert.assertEquals(e.rootNubmer(), 0);
    }

    @Test (description = "Квадратное уравнение имеет один корень, дискриминант равен нулю")
    public void testDiscriminantEqualsZero() {
        Equation e = new Equation(1, 2, 1);
        Assert.assertEquals(e.rootNubmer(), 1);
    }

    @Test (description = "Квадратное уравнение имеет два корня, дискриминант больше нуля")
    public void testDiscriminantGraterThanZero() {
        Equation e = new Equation(1, 5, 6);
        Assert.assertEquals(e.rootNubmer(), 2);
    }

    @Test (description = "Линейное уравнение")
    public void testLinearEquation() {
        Equation e = new Equation(0, 1, 1);
        Assert.assertEquals(e.rootNubmer(), 1);
    }

    @Test (description = "Константа")
    public void testConstant() {
        Equation e = new Equation(0, 0, 1);
        Assert.assertEquals(e.rootNubmer(), 0);
    }

    @Test (description = "0 = 0")
    public void testZero() {
        Equation e = new Equation(0, 0, 0);
        Assert.assertEquals(e.rootNubmer(), -1);
    }
}
