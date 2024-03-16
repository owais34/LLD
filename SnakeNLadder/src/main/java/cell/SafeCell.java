package cell;

public class SafeCell implements ICell{
    private int targetLocation;

    public SafeCell(int targetLocation){
        this.targetLocation=targetLocation;
    }

    public int goTo() {
        return targetLocation;
    }


    public void printMessage() {
        System.out.println("Safe here");
    }

    public String toString(){
        return "|"+Integer.toString(targetLocation)+"|";
    }
}
