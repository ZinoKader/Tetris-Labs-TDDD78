package lab3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DiagramViewer {
    public static void main(String[] args) {


	DiagramComponent comp = new DiagramComponent();
	ArrayList<Shape> shapeList = new ArrayList<>();

	Circle circle1 = new Circle(50, 40, 2, Color.BLUE);
	Circle circle2 = new Circle(30, 10, 2, Color.RED);
	Circle circle3 = new Circle(200, 99, 2, Color.YELLOW);

	Rectangle rectangle1 = new Rectangle(250, 300, 150, 150, Color.BLACK);
	Rectangle rectangle2 = new Rectangle(350, 380, 50, 40, Color.cyan);
	Rectangle rectangle3 = new Rectangle(900, 1000, 300, 400, Color.pink);

	Text text1 = new Text(600, 400, 22, Color.BLACK, "HEJ!");
	Text text2 = new Text(600, 380, 22, Color.BLACK, "HEJDÅ!");

	shapeList.add(circle1);
	shapeList.add(circle2);
	shapeList.add(circle3);
	shapeList.add(rectangle1);
	shapeList.add(rectangle2);
	shapeList.add(rectangle3);
	shapeList.add(text1);
	shapeList.add(text2);

	for(Shape shape : shapeList) {
	    comp.addShape(shape);
	}


	JFrame frame = new JFrame("ShapeViewer");
	frame.setLayout(new BorderLayout());
	frame.add(comp, BorderLayout.CENTER);
	frame.setSize(800,600);
	frame.setVisible(true);
    }
}