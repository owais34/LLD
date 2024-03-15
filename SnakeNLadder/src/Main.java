// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Board snakenladder = new Board(10);
        snakenladder.addSnakes(5);
        snakenladder.addLadders(5);
        snakenladder.printBoard();
    }
}