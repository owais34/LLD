package gameutils;

import cell.ICell;
import cell.LadderHead;
import cell.SafeCell;
import cell.SnakeHead;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    private List<Integer> safeCells;

    private int n;
    private boolean isSnakesAdded;
    private boolean isLaddersAdded;

    private ICell boardArray[];

    public Board(int n){
        boardArray=new ICell[n*n];
        isSnakesAdded=false;
        isLaddersAdded=false;
        this.n=n;
        safeCells = new ArrayList<>();
        for(int i=0;i<n*n;i++){
            if(i!=0 && i!= (n*n-1))
                safeCells.add(i);
            boardArray[i]=new SafeCell(i);
        }
    }

    public void addLadders(int n){
        if(isLaddersAdded)
            return;

        for(int i=0;i<n;i++){
            List<Integer> pair = getRandomPairs();
            if(pair==null)
                continue;
            boardArray[pair.get(0)]=new LadderHead(pair.get(1));
        }

        isLaddersAdded=true;
    }

    public void addSnakes(int n){
        if(isSnakesAdded)
            return;
        for(int i=0;i<n;i++){
            List<Integer> pair = getRandomPairs();
            if(pair == null)
                continue;
            boardArray[pair.get(1)]=new SnakeHead(pair.get(0));
        }
    }

    private List<Integer> getRandomPairs(){
        List<Integer> pair = new ArrayList<>();
        while (pair.size()!=2){
            int choices = safeCells.size();
            if(choices<1)
                break;
            int indexToChoose = (int)(choices * Math.random());
            pair.add(safeCells.get(indexToChoose));
            safeCells.remove(indexToChoose);
        }

        if(pair.size()==2)
        {
            Collections.sort(pair);
            return pair;
        }
        else
            return null;
    }

    public void printBoard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(boardArray[i*n+j]);
            }
            System.out.println();
        }
    }

    public ICell getCellType(int i){
        if(i< boardArray.length && i >= 0)
            return boardArray[i];
        else
            return null;
    }

    public int getWinningIndex(){
        return boardArray.length-1;
    }


}
