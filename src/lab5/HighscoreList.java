package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HighscoreList {

    private static final HighscoreList INSTANCE = new HighscoreList();
    private List<Highscore> highScoreList = new ArrayList<>();

    private HighscoreList() {
    }

    public static HighscoreList getInstance() {
        return INSTANCE;
    }

    public void addHighscore(Highscore highscore) {
        highScoreList.add(highscore);
    }

    public List<Highscore> getHighscorelist() {
	highScoreList.sort(Collections.reverseOrder(new ScoreComparator())); //Orders descending instead of default ascending
        return highScoreList;
    }

}