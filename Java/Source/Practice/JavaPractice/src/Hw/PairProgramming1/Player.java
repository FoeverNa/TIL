package Hw.PairProgramming1;

public class Player implements Inputtable {
    private String name;
    private int numWin;
    public Position pos;
    public int turn;

    public Player(String name){
        this.name = name;
    }

    @Override
    public void getKeyboardInput() {

    }
}
