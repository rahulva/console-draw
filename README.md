Features
---------
Console app as per the below specification.

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quite limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit


Command 		Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behavior of this is the same as that of the "bucket fill" tool in paint
                programs.
Q               Should quit the program.

Assumption(s)
-
Since the paint fill feature is not quite clear and I was unable to presume the understanding from given sample output. I made am assumption that x, y points together makes a shape (square or rectangle) and that area needs to be filled with the colour 'o'. 


Instructions for execution
------------------------------

Preconditions
-
A functioning Java 8 (or higher) and maven installed in your computer.

Execution
-
Running the app:
mvn compile exec:java -Dexec.mainClass="com.assessment.drawing.console.DrawingApp"

Test Execution
-
Run all tests:

mvn clean test

Run Specific test:

mvn -Dtest=com.assessment.drawing.shapes.DrawingKitTest test
mvn -Dtest=com.assessment.drawing.shapes.CanvasTest test