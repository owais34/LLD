import dice.SingleDice;
import gameutils.BaseGame;
import gameutils.Board;
import gameutils.Player;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(10);
        board.addSnakes(5);
        board.addLadders(5);
        BaseGame baseGame = new BaseGame();
        baseGame.setBoard(board);
        Player player = new Player();
        player.setName("owais");
        Player player1 = new Player();
        player1.setName("farhan");
        baseGame.addPlayer(player);
        baseGame.addPlayer(player1);
        baseGame.setMoveStrategy(new SingleDice());

        baseGame.start();
    }
}