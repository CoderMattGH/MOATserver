package com.moat.highscores;

import com.moat.entity.Score;
import com.moat.profanityfilter.ProfanityFilterService;
import com.moat.service.ScoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoresTest {
    private final static Logger logger = LoggerFactory.getLogger(HighScoresTest.class);

    private final List<Score> leaderboard = new ArrayList<>();

    public HighScoresTest() {
        logger.info("Constructing HighScoresTest.");
    }

    @BeforeEach
    public void initLeaderBoard() {
        Score score1 = new Score(100, "mattd");
        leaderboard.add(score1);

        Score score2 = new Score(3000, "bobby");
        leaderboard.add(score2);

        Score score3 = new Score(5000, "timmy");
        leaderboard.add(score3);

        Score score4 = new Score(10000, "tommy");
        leaderboard.add(score4);

        Score score5 = new Score(120000, "alan5");
        leaderboard.add(score5);
    }

    @Test
    public void testGetTopTenSortedScores() {
        ScoreService scoreService = Mockito.mock(ScoreService.class);
        ProfanityFilterService profanityFilterService = Mockito.mock(ProfanityFilterService.class);

        Mockito.when(scoreService.findTopTenScoresSorted()).thenReturn(leaderboard);

        HighScores highScores = new HighScoresImpl(scoreService, profanityFilterService);

        Score[] leaderboard = highScores.getTopTenSortedScores();

        assertEquals(5, leaderboard.length);
    }

    @Test
    public void testCheckAndSaveIfTopTenScore() {
        ScoreService scoreService = Mockito.mock(ScoreService.class);
        ProfanityFilterService profanityFilterService = Mockito.mock(ProfanityFilterService.class);


    }
}
