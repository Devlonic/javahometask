package task1;

import org.junit.Test;
import task1.paralelograms.Rhombus;
import task1.paralelograms.rectangles.Rectangle;
import task1.paralelograms.rectangles.Square;
import task1.triangles.RightTriangle;

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
        // will never be executed
        s.getArea();
    }

    @Test
    public void testRectangleAreaMinRange() {
        Shape s = new Rectangle(1,1);
        assertEquals(1, s.getArea(), 0.000000000000001d);
    }

    @Test(expected = ShapeInvalidException.class)
    public void testRectangleAreaInvalidRange() {
        Shape s = new Rectangle(0,0);
        // will never be executed
        s.getArea();
    }

    @Test
    public void testSquareAreaValidRange() {
        Shape s = new Square(2,2);
        assertEquals(4, s.getArea(), 0.000000000000001d);
    }

    @Test(expected = ShapeInvalidException.class)
    public void testSquareAreaWrongRange() {
        Shape s = new Square(4,2);
        // will never be executed
        assertEquals(8, s.getArea(), 0.000000000000001d);
    }

    @Test
    public void testRhombusAreaMinRange() {
        Shape s = new Rhombus(2, 1);
        assertEquals(0.06980961122712853d, s.getArea(), 0.00001d);
    }
    @Test
    public void testRhombusAreaMaxRange() {
        Shape s = new Rhombus(2, 180);
        assertEquals(0, s.getArea(), 0.00001d);
    }


    @Test(expected = ShapeInvalidException.class)
    public void testRhombusAreaWrongAngle() {
        Shape s = new Rhombus(2, 181);
        assertEquals(3.4641d, s.getArea(), 0.00001d);
    }

    @Test(expected = ShapeInvalidException.class)
    public void testRhombusAreaInvalidAngle() {
        Shape s = new Rhombus(2, -1);
        assertEquals(3.4641d, s.getArea(), 0.00001d);
    }
}
