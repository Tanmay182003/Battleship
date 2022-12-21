/**
 * A class that generates a 2-D char array representing an 'X'
 *
 * <p>Purdue University -- CS18000 -- Spring 2022</p>
 *
 * @author Purdue CS
 * @version January 10, 2022
 */

public class GameLog {
    private int winningPlayer;
    private int losingPlayerHits;
    private int numTurns;
    private String boardPatternOne;
    private String boardPatternTwo;

    public GameLog(int winnerPlayer, int losingPlayerHits, int numTurns,
                   String boardPatternOne, String boardPatternTwo) {
        this.winningPlayer = winnerPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternOne = boardPatternOne;
        this.boardPatternTwo = boardPatternTwo;
    }

    @Override
    public String toString() {
        String game = "";
        if (this.winningPlayer == 1) {
            game = String.format("Battleship Game Log:\nWinning Player: Player " +
                            "%d\nHits: 17 - %d\nNumber of Turns To Win: %d\nPlayer 1 Board Pattern: %s" +
                            "\nPlayer 2 Board Pattern: %s\n", winningPlayer, losingPlayerHits,
                    numTurns, boardPatternOne, boardPatternTwo);
        } else {
            game = String.format("Battleship Game Log:\nWinning Player: Player " +
                            "%d\nHits: %d - 17\nNumber of Turns To Win: %d\nPlayer 1 Board Pattern: %s" +
                            "\nPlayer 2 Board Pattern: %s\n", winningPlayer, losingPlayerHits,
                    numTurns, boardPatternOne, boardPatternTwo);
        }
        return game;
    }
}
