package cell;

public class LadderHead implements ICell{
    private int targetLocation;

    public LadderHead(int targetLocation) {
        this.targetLocation=targetLocation;
    }

    public int goTo() {
        return targetLocation;
    }


    public void printMessage() {
        System.out.println("Yes!! Ladder");
    }

    public String toString(){
        return "|L"+Integer.toString(targetLocation)+"|";
    }
}
