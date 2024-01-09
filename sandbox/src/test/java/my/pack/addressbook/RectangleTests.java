package my.pack.addressbook;

import my.pack.sandbox.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTests {
    @Test (description = "Вычисление площади прямоугольника")
    public void testArea() {
        Rectangle r = new Rectangle(4, 7);
        Assert.assertEquals(r.area(), 28.0);
    }
}
