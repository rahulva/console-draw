package com.assessment.drawing.shapes;

import com.assessment.drawing.DrawingException;

public class DrawingKit {

	/**
	 * Frame of a Canvas
	 * 
	 * @param width
	 *            int width
	 * @param height
	 *            int height
	 * @return
	 */
	public String[][] drawFrame(int width, int height) {

		int intentedWidth = width + 2; // (y)
		int intentedHight = height + 2; // (x)
		String topBottom = "-";
		String sides = "|";

		String arr[][] = new String[intentedWidth][intentedHight];

		for (int x = 0; x < intentedHight; x++) {
			for (int y = 0; y < intentedWidth; y++) {

				// Top border
				if (x == 0) {
					arr[y][x] = topBottom;
				}

				// Left border (at first index && not touching the edges)
				if (y == 0 && (x > 0 && x < (intentedHight - 1))) {
					arr[y][x] = sides;
				}

				// Right border (at last index && not touching the edges)
				if (y == (intentedWidth - 1) && (x > 0 && x < (intentedHight - 1))) {
					arr[y][x] = sides;
				}

				// Right end break
				if (y == (intentedWidth - 1)) {
					arr[y][x] = arr[y][x] + "\n";
				}

				// Bottom Border
				if (x == (intentedHight - 1)) {
					arr[y][x] = topBottom;
				}

				// Fill up
				if (arr[y][x] == null) {
					arr[y][x] = " ";
				}
			}
		}

		return arr;
	}

	/**
	 * Draws horizontal and vertical lines with in the given frame.
	 * 
	 * @param frame
	 *            Frame((2 dimensional array)) to draw in
	 * @param x1
	 *            x point of start
	 * @param y1
	 *            y point of start
	 * @param x2
	 *            x point of end
	 * @param y2
	 *            y point of end
	 * @return Frame(2 dimensional array) with the drawn line.
	 */
	public String[][] drawLine(String[][] frame, int x1, int y1, int x2, int y2, String character) {
		validateFrame(frame);
		validateRange(frame, x1, y1);
		validateRange(frame, x2, y2);

		int diff;
		int startPoint;
		int lengthToEndPoint;
		if (y1 == y2) {
			// Horizontal Line
			diff = x2 - x1 + 1;
			startPoint = x1;
			lengthToEndPoint = x1 + diff;

			for (int i = startPoint; i < lengthToEndPoint; i++) {
				frame[i][y2] = character;
			}

		} else if (x1 == x2) {
			// Vertical line
			diff = y2 - y1 + 1;
			startPoint = y1;
			lengthToEndPoint = y1 + diff;

			for (int i = startPoint; i < lengthToEndPoint; i++) {
				frame[x1][i] = character;
			}
		}

		return frame;

	}

	/**
	 * Draws a rectangle inside the given frame.
	 * 
	 * @param frame
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * 
	 * @return
	 */
	public String[][] drawRectangle(String[][] frame, int x1, int y1, int x2, int y2, String val) {
		validateFrame(frame);
		validateRange(frame, x1, y1);
		validateRange(frame, x2, y2);

		int width = x2 - x1 + 1;
		int hight = y2 - y1 + 1;

		int xEndPoint = x1 + width;
		int yEndPoint = y1 + hight;

		for (int x = x1; x < xEndPoint; x++) {
			for (int y = y1; y < yEndPoint; y++) {

				// Top Border
				if (y == y1) {
					frame[x][y] = val;
				}

				// Left Border
				if (x == x1) {
					frame[x][y] = val;
				}

				// Bottom Border
				if (y == (yEndPoint - 1)) {
					frame[x][y] = val;
				}

				// Right Border
				if (x == (xEndPoint - 1)) {
					frame[x][y] = val;
				}
			}
		}

		return frame;
	}

	/**
	 * Fills the entire area connected to (x10,y3) with colour.
	 * 
	 * @param frame
	 * @param x
	 * @param y
	 * @param colour
	 * @return
	 */
	public String[][] fillColour(String[][] frame, int x1, int y1, String colour) {
		validateFrame(frame);
		validateRange(frame, x1, y1);
		int xStartPoint = x1;
		int xEndPoint = xStartPoint + y1 - 1;

		int yStartPoint = 1;
		int yEndPoint = y1;

		for (int x = xStartPoint; x <= xEndPoint; x++) {
			for (int y = yStartPoint; y <= yEndPoint; y++) {
				if (frame[x][y] == null || frame[x][y].trim().isEmpty()) {
					frame[x][y] = colour;
				}
			}
		}

		return frame;
	}

	/**
	 * Generates the printable string for the canvas frame.
	 * 
	 * @param canvas
	 *            Canvas- array of 2 dimension
	 * @return String
	 */
	public String printableCanvas(String[][] canvas) {
		validateFrame(canvas);

		int width = canvas.length;
		int hight = canvas[0].length;

		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < hight; x++) {
			for (int y = 0; y < width; y++) {
				builder.append(canvas[y][x]);
			}
		}
		return builder.toString();
	}

	private void validateFrame(String[][] frame) {
		if (frame == null) {
			throw new DrawingException("Frame is null. Plese provide a valid frame");
		}
	}

	private void validateRange(String[][] frame, int x, int y) {

		if (x < 1 || y < 1) {
			throw new DrawingException("Invalid min range of x or y. Minimum allowed value is 1");
		}

		int maxX = frame.length - 2; // (width)
		int maxY = frame[0].length - 2; // (height)
		if (x > maxX || y > maxY) {
			throw new DrawingException("Invalid max range of x or y. Provided x:" + x + ", y:" + y
					+ " grater than allowed x : " + maxX + " or y: " + maxY);
		}
	}
}
