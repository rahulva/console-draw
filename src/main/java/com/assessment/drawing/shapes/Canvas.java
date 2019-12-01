package com.assessment.drawing.shapes;

public class Canvas {

	private DrawingKit drawingKit;

	private int height;
	private int width;

	private String[][] canvasArray;

	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		drawCanvas();
	}

	private void drawCanvas() {
		drawingKit = new DrawingKit();
		canvasArray = drawingKit.drawFrame(width, height);
	}

	public String getPrintable() {
		return drawingKit.printableCanvas(canvasArray);
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		canvasArray = drawingKit.drawLine(canvasArray, x1, y1, x2, y2, "x");
	}

	public void drawRectangle(int x1, int y1, int x2, int y2) {
		canvasArray = drawingKit.drawRectangle(canvasArray, x1, y1, x2, y2, "x");
	}

	public void bucketFill(int x, int y, String colour) {
		canvasArray = drawingKit.fillColour(canvasArray, x, y, colour);
	}

}
