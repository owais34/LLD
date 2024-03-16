package cell;

public class SnakeHead implements ICell{

    private int targetLocation;
    public SnakeHead(int targetLocation){
        this.targetLocation=targetLocation;
    }

    public int goTo() {
        return targetLocation;
    }


    public void printMessage() {
        System.out.println("No!! Snake");
    }

    public String toString(){
        return "|S"+Integer.toString(targetLocation)+"|";
    }

}
