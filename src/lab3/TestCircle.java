package lab3;

import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class TestCircle {

    public static void main(String[] args) {
	List<Circle> circleList = new ArrayList<>();
	Circle circle1 = new Circle(50, 40, 2, Color.BLUE);
	Circle circle2 = new Circle(30, 10, 2, Color.RED);
	Circle circle3 = new Circle(200, 99, 2, Color.YELLOW);

	circleList.add(circle1);
	circleList.add(circle2);
	circleList.add(circle3);

	for(Circle circle : circleList) {
	    System.out.println(circle.getX() + ", " + circle.getY());
	}
    }

}
