package task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShapesTest {
    @Test
    public void testRightTriangleMinRange() {
        Shape s = new RightTriangle(1,1);
        assertEquals(0.5d, s.getArea(), 0.000000000000001d);
    }

    @Test(expected = ShapeInvalidException.class)
    public void testRightTriangleInvalidRange() {
        Shape s = new RightTriangle(0,0);
        s.getArea();
    }
}
