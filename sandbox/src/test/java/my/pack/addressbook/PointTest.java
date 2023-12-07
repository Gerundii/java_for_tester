package my.pack.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test (description = "Расстояние между точками")
    public void testDistance() {
        Point a = new Point(3, 4);
        Point b = new Point (-1, 7);
        Assert.assertEquals(a.distance(b), 5.0);
    }
}
