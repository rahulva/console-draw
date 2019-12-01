package com.assessment.drawing.shapes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

import com.assessment.drawing.DrawingException;
import com.assessment.drawing.shapes.DrawingKit;

public class DrawingKitTest {

	private DrawingKit service = new DrawingKit();

	@Test
	public void testDrawFrame() {
		String expectedOutput = //
				"----------------------\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"----------------------";
		assertThat(service.printableCanvas(service.drawFrame(20, 4))).isEqualTo(expectedOutput);
	}

	@Test
	public void testCreateCanvas_HightIsHigherThanWidth() {

		String expectedOutput = //
				"------\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"|    |\n" + //
						"------";
		String[][] frame = service.drawFrame(4, 10);

		assertThat(service.printableCanvas(frame)).isEqualTo(expectedOutput);

	}

	@Test
	public void testDrawLine_Horizontal() {

		String expectedOutput = //
				"----------------------\n" + //
						"|                    |\n" + //
						"|xxxxxx              |\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"----------------------";

		int x1 = 1, y1 = 2;
		int x2 = 6, y2 = 2;

		String[][] hLine = service.drawLine(service.drawFrame(20, 4), x1, y1, x2, y2, "x");
		String printableCanvas = service.printableCanvas(hLine);

		assertThat(printableCanvas).isEqualTo(expectedOutput);
	}

	@Test
	public void testDrawLine_Vertical() {
		String expectedOutput = //
				"----------------------\n" + //
						"|                    |\n" + //
						"|xxxxxx              |\n" + //
						"|     x              |\n" + //
						"|     x              |\n" + //
						"----------------------";

		String[][] drawWithLineH = service.drawLine(service.drawFrame(20, 4), 1, 2, 6, 2, "x");

		int x1 = 6, y1 = 3;
		int x2 = 6, y2 = 4;
		String[][] drawWithLineV = service.drawLine(drawWithLineH, x1, y1, x2, y2, "x");
		String printableCanvas = service.printableCanvas(drawWithLineV);

		assertThat(printableCanvas).isEqualTo(expectedOutput);
	}

	@Test
	public void testDrawLine_NotAMatchOfBoth() {
		String expectedOutput = //
				"----------------------\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"|     x              |\n" + //
						"|     x              |\n" + //
						"----------------------";

		String[][] canvas = service.drawFrame(20, 4);
		String[][] drawWithLineH = service.drawLine(canvas, 1, 2, 6, 3, "x");

		int x1 = 6, y1 = 3;
		int x2 = 6, y2 = 4;
		String[][] drawWithLineV = service.drawLine(drawWithLineH, x1, y1, x2, y2, "x");
		String printableCanvas = service.printableCanvas(drawWithLineV);

		assertThat(printableCanvas).isEqualTo(expectedOutput);
	}

	@Test
	public void testDrawRectacngle() {

		String expectedOutput = //
				"----------------------\n" + //
						"|             xxxxx  |\n" + //
						"|xxxxxx       x   x  |\n" + //
						"|     x       xxxxx  |\n" + //
						"|     x              |\n" + //
						"----------------------";

		String[][] frame = service.drawFrame(20, 4);
		String[][] drawWithLineH = service.drawLine(frame, 1, 2, 6, 2, "x");
		String[][] drawWithLineV = service.drawLine(drawWithLineH, 6, 3, 6, 4, "x");

		// R x1 y1 x2 y2
		// R 14 1 18 3
		int x1 = 14, y1 = 1;
		int x2 = 18, y2 = 3;
		String printableCanvas = service.printableCanvas(service.drawRectangle(drawWithLineV, x1, y1, x2, y2, "x"));

		assertThat(printableCanvas).isEqualTo(expectedOutput);
	}

	@Test
	public void testDrawRectacngle_minError() {
		String[][] frame = service.drawFrame(20, 4);
		assertThatThrownBy(() -> {
			service.drawRectangle(frame, 0, 0, 1, 1, "x");
		}).isInstanceOf(DrawingException.class).hasMessage("Invalid min range of x or y. Minimum allowed value is 1");
	}

	@Test
	public void testDrawRectacngle_minErrorCase2() {
		String[][] frame = service.drawFrame(20, 4);
		assertThatThrownBy(() -> {
			service.drawRectangle(frame, 1, 0, 1, 0, "x");
		}).isInstanceOf(DrawingException.class).hasMessage("Invalid min range of x or y. Minimum allowed value is 1");
	}

	@Test
	public void testDrawRectacngle_maxXase() {

		String[][] frame = service.drawFrame(20, 4);
		assertThatThrownBy(() -> {
			service.drawRectangle(frame, 21, 10, 1, 0, "x");
		}).isInstanceOf(DrawingException.class)
				.hasMessage("Invalid max range of x or y. Provided x:21, y:10 grater than allowed x : 20 or y: 4");
	}

	@Test
	public void testFillColour() {
		String[][] frame = service.drawFrame(20, 4);
		// String[][] rectangle = service.drawRectangle(frame, 14, 1, 18, 3);

		int x = 10, y = 3;
		String colour = "o";
		String printableCanvas = service.printableCanvas(service.fillColour(frame, x, y, colour));

		String expectedOutput = //
				"----------------------\n" + //
						"|         ooo        |\n" + //
						"|         ooo        |\n" + //
						"|         ooo        |\n" + //
						"|                    |\n" + //
						"----------------------";

		assertThat(printableCanvas).isEqualTo(expectedOutput);
	}

	@Test
	public void testPrintableCanvas_nullFrame() {
		assertThatThrownBy(() -> {
			service.printableCanvas(null);
		}).isInstanceOf(DrawingException.class).hasMessage("Frame is null. Plese provide a valid frame");
	}

}