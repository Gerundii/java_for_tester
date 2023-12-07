package my.pack.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {
    @Test (description = "Вычисление площади квадрата")
    public void testArea() {
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25.0);
    }
}
