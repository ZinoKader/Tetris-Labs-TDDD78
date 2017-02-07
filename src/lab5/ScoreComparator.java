package lab5;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Highscore>
{

    public int compare(Highscore o1, Highscore o2) {
        if(o1.getScore() == o2.getScore()) {
            return 0;
	} else if(o1.getScore() > o2.getScore()) {
            return 1;
	} else {
            return -1;
	}
    }
}