package com.assessment.drawing.console;

import java.util.Scanner;

import com.assessment.drawing.shapes.Canvas;

public class DrawingApp {

	private Canvas canvas;

	public static void main(String[] args) {
		DrawingApp app = new DrawingApp();

		Scanner scan = new Scanner(System.in);
		String inputLine = new String();

		while (!inputLine.equalsIgnoreCase("Q")) {
			System.out.println("\nEnter command :");
			inputLine = scan.nextLine();
			app.draw(inputLine);
		}
		System.out.println("Program Exited!");
		scan.close();
	}

	private void draw(String command) throws NumberFormatException {
		char ch = command.charAt(0);
		String[] values;
		try {
			switch (ch) {
			case 'C':
				values = command.split(" ");
				this.canvas = new Canvas(Integer.parseInt(values[1]), Integer.parseInt(values[2]));
				System.out.println(this.canvas.getPrintable());
				break;
			case 'L':
				values = command.split(" ");
				this.canvas.drawLine(Integer.parseInt(values[1]), Integer.parseInt(values[2]),
						Integer.parseInt(values[3]), Integer.parseInt(values[4]));
				System.out.println(this.canvas.getPrintable());
				break;
			case 'R':
				values = command.split(" ");
				this.canvas.drawRectangle(Integer.parseInt(values[1]), Integer.parseInt(values[2]),
						Integer.parseInt(values[3]), Integer.parseInt(values[4]));
				System.out.println(this.canvas.getPrintable());
				break;
			case 'B':
				values = command.split(" ");
				this.canvas.bucketFill(Integer.parseInt(values[1]), Integer.parseInt(values[2]), values[3]);
				System.out.println(this.canvas.getPrintable());
				break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\nInvalid Input entered. Pease correct and try again!!\n");
		} catch (Exception e) {
			System.out.println("\nError Occurred : " + e.getMessage() + "\nPlease try again");
		}
	}

}
