package Hw.PairProgramming1;

import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {

    private final int table_Width = 15;
    private final int table_Height = 15;
    Player player_One;
    Player player_Two;
    Position[] oneStones;
    Position[] twoStones;
    public boolean isEmpty;




    public Gomoku(){

    }

    public  void startGame(){

        initialize();

        do

        while(isEmpty) {
            Player player = whosTurn();
            player.getKeyboardInput();
            checkEmpty(player.pos);
            play(player, player.pos);

            }
        }




    @Override
    public void initialize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Plyaer1에 이름 입력 :");
        player_One = new Player(sc.next());
        System.out.println("Plyaer2에 이름 입력 :");
        player_Two = new Player(sc.next());

        oneStones = new Position[table_Height * table_Width];
        twoStones = new Position[table_Height * table_Width];

        isEmpty = false;
    }

    public Player whosTurn(){
        if (player_One.turn == player_Two.turn){
            return player_One;
        } else{
            return player_Two;
        }
    }

    public void checkEmpty(Position pos){

        for(int i = 0; i < player_One.turn ; i ++) {
            if (pos.x != oneStones[i].x && pos.y != oneStones[i].y) {
                isEmpty = true;
            }
        }

        for(int i = 0; i < player_One.turn ; i ++){
                if(pos.x != oneStones[i].x && pos.y != oneStones[i].y){
                    isEmpty = true;
                }

            }
        }




    @Override
    public void play(Player player, Position pos) {
        if(player == player_One){
            oneStones[player.turn] = player.pos;
            player_One.turn++;
        }else{
            twoStones[player.turn] = player.pos;
            player_Two.turn++;
        }
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
