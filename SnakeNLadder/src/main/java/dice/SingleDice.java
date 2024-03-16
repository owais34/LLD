package dice;

public class SingleDice implements IMoveStrategy{
    @Override
    public int getMove() {
        return (int)(1+Math.random()*6);
    }
}
