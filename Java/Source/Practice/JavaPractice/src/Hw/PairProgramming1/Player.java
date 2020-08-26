package Hw.PairProgramming1;

import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s=="q"||s=="Q"){

        }else{
        int i = s.indexOf(",");
        int j = Integer.parseInt(s.substring(0,i));
        int k = Integer.parseInt(s.substring(i+1));
        pos = new Position(j,k);
        }

        sc.close();
    }
}
