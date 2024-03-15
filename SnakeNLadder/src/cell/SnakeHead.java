package cell;

public class SnakeHead implements ICell{

    private int targetLocation;
    public SnakeHead(int targetLocation){
        this.targetLocation=targetLocation;
    }
    @Override
    public int goTo() {
        return targetLocation;
    }

    public String toString(){
        return "|S"+Integer.toString(targetLocation)+"|";
    }

}
