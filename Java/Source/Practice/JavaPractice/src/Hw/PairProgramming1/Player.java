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

    public String getName() {
        return name;
    }

    @Override
    public void getKeyboardInput() {
        Scanner scan = new Scanner(System.in);
        while(true){
        System.out.println("player "+ name+" 차례입니다(x,y)");
        String s = scan.nextLine();
        if(s.equals("q")||s.equals("Q")){

        }else{


            int i = s.indexOf(",");
            int x = Integer.parseInt(s.substring(0,i));
            int y = Integer.parseInt(s.substring(i+1));

            if(x>=Gomoku.table_Width || x<0 || y>=Gomoku.table_Width || y<0){
                System.out.println("범위를 벗어났습니다 좌표를 다시 입력해주세요("+Gomoku.table_Width+"X"+Gomoku.table_Width+")");
                continue;
            }else{
                pos = new Position(x,y);
                break;
            }
        }
        }
    }
}
