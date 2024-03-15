package cell;

public class SafeCell implements ICell{
    private int targetLocation;

    public SafeCell(int targetLocation){
        this.targetLocation=targetLocation;
    }
    @Override
    public int goTo() {
        return targetLocation;
    }

    public String toString(){
        return "|"+Integer.toString(targetLocation)+"|";
    }
}
