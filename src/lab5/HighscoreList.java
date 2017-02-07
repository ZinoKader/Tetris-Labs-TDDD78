package lab5;

import java.util.ArrayList;
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
        highScoreList.sort(new ScoreComparator());
    }

    public List<Highscore> getHighscorelist() {
        return highScoreList;
    }

}