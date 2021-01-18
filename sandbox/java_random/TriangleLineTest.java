import java.awt.geom.*;

public class TriangleLineTest {

	public static void main(String[] args) {
		Line2D myLine1 = new Line2D.Double(1, 2, 10, 11);
		Line2D myLine2 = new Line2D.Double(5, 10, 20, 21);
		System.out.printf("%b\n", myLine1.intersectsLine(myLine2));
		Rectangle2D myRectangle = new Rectangle2D.Double(0,0, 5, 10);
		System.out.printf("%b\n", myRectangle.contains(1, 1));
	}
	
}
