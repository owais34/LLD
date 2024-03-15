package cell;

public class LadderHead implements ICell{
    private int targetLocation;

    public LadderHead(int targetLocation) {
        this.targetLocation=targetLocation;
    }

    @Override
    public int goTo() {
        return targetLocation;
    }

    public String toString(){
        return "|L"+Integer.toString(targetLocation)+"|";
    }
}
