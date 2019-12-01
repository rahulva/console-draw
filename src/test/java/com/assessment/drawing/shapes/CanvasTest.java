package com.assessment.drawing.shapes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.assessment.drawing.shapes.Canvas;

public class CanvasTest {

	@Test
	public void testDrawCanvas() {
		Canvas canvas = new Canvas(20, 4);

		String expectedOutput = //
				"----------------------\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"----------------------";
		assertThat(canvas.getPrintable()).isEqualTo(expectedOutput);
	}

	@Test
	public void testDrawHLine() {

		String expectedOutput = //
				"----------------------\n" + //
						"|                    |\n" + //
						"|xxxxxx              |\n" + //
						"|                    |\n" + //
						"|                    |\n" + //
						"----------------------";

		int x1 = 1, y1 = 2;
		int x2 = 6, y2 = 2;

		Canvas canvas = new Canvas(20, 4);
		canvas.drawLine(x1, y1, x2, y2);

		assertThat(canvas.getPrintable()).isEqualTo(expectedOutput);
	}

	@Test
	public void testDrawVLine() {

		String expectedOutput = //
				"----------------------\n" + //
						"|                    |\n" + //
						"|xxxxxx              |\n" + //
						"|     x              |\n" + //
						"|     x              |\n" + //
						"----------------------";

		int x1 = 6, y1 = 3;
		int x2 = 6, y2 = 4;

		Canvas canvas = new Canvas(20, 4);
		canvas.drawLine(1, 2, 6, 2);
		canvas.drawLine(x1, y1, x2, y2);

		assertThat(canvas.getPrintable()).isEqualTo(expectedOutput);
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

		int x1 = 14, y1 = 1;
		int x2 = 18, y2 = 3;

		Canvas canvas = new Canvas(20, 4);
		canvas.drawLine(1, 2, 6, 2);
		canvas.drawLine(6, 3, 6, 4);
		canvas.drawRectangle(x1, y1, x2, y2);

		assertThat(canvas.getPrintable()).isEqualTo(expectedOutput);
	}

	@Test
	public void testFillColour() {
		String expectedOutput = //
				"----------------------\n" + //
						"|         ooo        |\n" + //
						"|         ooo        |\n" + //
						"|         ooo        |\n" + //
						"|                    |\n" + //
						"----------------------";

		Canvas canvas = new Canvas(20, 4);
		canvas.bucketFill(10, 3, "o");

		assertThat(canvas.getPrintable()).isEqualTo(expectedOutput);
	}
}
