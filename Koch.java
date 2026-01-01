/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function. Uncomment the
		/// second code block to test the snowflake function. Uncomment only one block in
		/// each test, and remember to compile the class whenever you change the test.

		/*
		 * // Tests the curve function:
		 * // Gets n, x1, y1, x2, y2,
		 * // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		 * curve(Integer.parseInt(args[0]),
		 * Double.parseDouble(args[1]), Double.parseDouble(args[2]),
		 * Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		 */

		/*
		 * // Tests the snowflake function:
		 * // Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		 * snowFlake(Integer.parseInt(args[0]));
		 */
	}

	/**
	 * Gets n, x1, y1, x2, y2,
	 * and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
	 */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		if (n == 0) {
			return;
		}

		double thirdX = x1 + (x2 - x1) / 3.0;
		double thirdY = y1 + (y2 - y1) / 3.0;

		double twoThirdsX = x1 + 2 * (x2 - x1) / 3.0;
		double twoThirdsY = y1 + 2 * (y2 - y1) / 3.0;

		double peakX = (x1 + x2) / 2.0 + (Math.sqrt(3) / 6.0) * (y1 - y2);
		double peakY = (y1 + y2) / 2.0 + (Math.sqrt(3) / 6.0) * (x2 - x1);

		curve(n - 1, x1, y1, thirdX, thirdY);
		curve(n - 1, thirdX, thirdY, peakX, peakY);
		curve(n - 1, peakX, peakY, twoThirdsX, twoThirdsY);
		curve(n - 1, twoThirdsX, twoThirdsY, x2, y2);
	}

	public static void snowFlake(int n) {
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		double x1 = 0.2, y1 = 0.35;
		double x2 = 0.8, y2 = 0.35;
		double x3 = 0.5, y3 = 0.35 + Math.sqrt(3) * 0.3;

		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}
