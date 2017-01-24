package lab2;

import java.util.Random;

public class Slump {
    public static void main(String[] args) {
	Random rnd = new Random();

	for(int i = 0; i < 25; i++) {
	    System.out.println(rnd.nextInt(100));
	}

    }
}
