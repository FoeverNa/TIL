package Hw.PairProgramming1;

import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {

    private final int table_Width = 15;
    private final int table_Height = 15;
    Player player_One;
    Player player_Two;


    public Gomoku(){

    }


    @Override
    public void initialize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Plyaer1에 이름 입력 :");
        player_One = new Player(sc.next());
        System.out.println("Plyaer2에 이름 입력 :");
        player_Two = new Player(sc.next());
        sc.close();
    }

    public Player whosTurn(){
        if (player_One.turn == player_Two.turn){
            return player_One;
        } else{
            return player_Two;
        }
    }

    public void putStone(Player player){
        player.getKeyboardInput();

    }

    @Override
    public void play(Player player, Position pos) {
        player.getKeyboardInput();

    }

    @Override
    public void printStatus() {

    }


    @Override
    public void isFinished() {

    }

    @Override
    public void reset() {

    }

    @Override
    public Player getWinner() {
        return null;
    }
}
