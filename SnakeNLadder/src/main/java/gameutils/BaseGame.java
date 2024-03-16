package gameutils;

import cell.ICell;
import dice.IMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class BaseGame {
    private Board board;

    private GameState gameState;

    private IMoveStrategy moveStrategy;

    private List<Player> playerList;
    private int currentPlayerIndex;

    public BaseGame(){
        playerList = new ArrayList<>();
        gameState = GameState.NOT_STARTED;
        currentPlayerIndex = 0;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setMoveStrategy(IMoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayer(Player p){
        if(p!=null)
            playerList.add(p);
    }

    private void play() throws InterruptedException {
        Player p = playerList.get(currentPlayerIndex);
        currentPlayerIndex = (currentPlayerIndex+1)%playerList.size();
        if(p.getPosition() == board.getWinningIndex()){
            return;
        }

        int move = moveStrategy.getMove();
        System.out.println("Got "+move+"on the dice");
        ICell nextPostionCelltion = board.getCellType(p.getPosition()+move);

        if(nextPostionCelltion !=null) {
            nextPostionCelltion.printMessage();
            int nextPos = nextPostionCelltion.goTo();
            System.out.println("At "+(nextPos+1)+" now.");
            p.setPosition(nextPos);
        } else {
            System.out.println("Cannot progress");
        }
        Thread.sleep(1000);
        if(p.getPosition()== board.getWinningIndex()){
            System.out.println("Congratulations !! "+p.getName()+" wins!!");
        }

    }

    public void start() throws InterruptedException {
        if(gameState == GameState.NOT_STARTED){
            gameState = GameState.RUNNING;
            while (!isComplete()){
                this.play();
            }
            gameState = GameState.FINISHED;
        }
    }

    private boolean isComplete(){
        boolean isComplete =true;
        for(Player player: playerList){
            isComplete = isComplete && (player.getPosition()==board.getWinningIndex());
        }

        return isComplete;
    }
}
