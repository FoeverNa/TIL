package Hw.PairProgramming1;

import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {

    public static final int table_Width = 15;
    public static final int table_Height = 15;
    Player player_One;
    Player player_Two;
    public boolean isEmpty;
    public int i = 1;
    public int[][] table;

    public Gomoku(){

    }

    // Gomoku 최상위 메서드
    public  void startGame(){

        initialize();

        while(true){

        Player player = whosTurn();
        while(!isEmpty) {
            player.getKeyboardInput();
            checkEmpty(player.pos);
        }
        play(player, player.pos);

        printStatus();
        check3x3();
        }

        }



    //게임 초기화, 실행시 한번만 실행됨
    @Override
    public void initialize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Plyaer1에 이름 입력 :");
        player_One = new Player(sc.next());
        System.out.println("Plyaer2에 이름 입력 :");
        player_Two = new Player(sc.next());

        table = new int[table_Width][table_Height];

        isEmpty = false;
    }

    // 누구의 턴인지 결정하는 메서드
    public Player whosTurn(){
        if (player_One.turn == player_Two.turn){
            return player_One;
        } else{
            return player_Two;
        }
    }

    // 바둑판이 비어있는지 확인하는 메서드드
    public void checkEmpty( Position pos) {
        if (player_One.turn + player_Two.turn == 0) {
            isEmpty = true;
        }else if (table[pos.x][pos.y] == 0 ) {
            isEmpty = true;
        }else {
            System.out.println("이미 돌이 놓아진 자리입니다");
        }
        }


    @Override
    public void play(Player player, Position pos) {
        if(player == player_One){
            table[pos.x][pos.y]=1;
        }else{
            table[pos.x][pos.y]=2;
        }
        player.turn++;
        isEmpty = false;
    }

    @Override
    public void printStatus() {
        // table 출력
        for (int i = 0; i < table_Height; i++) {
            for (int j = 0; j < table_Width; j++) {
                if (table[i][j] == 0) {
                    System.out.print("-   ");
                } else if (table[i][j] == 1) {
                    System.out.print("O   ");
                } else if (table[i][j] == 2) {
                    System.out.print("X   ");
                }
            }
            System.out.println("");
        }
    }

    public void check3x3() {
        int score = 0;
        int one3x3 = 0;
        int two3x3 = 0;


        //가로 5개
        for(int i=0 ; i < 15; i++){
            for(int j=0; j<11; j++){
                for (int k=0; k<5; k++){
                    score += table[i][j+k];
                }
                if(score==3){
                    one3x3++;
                } else if(score==30){
                    two3x3++;
                }
                score=0;
            }
        }

//        세로 5개
        for(int i=0 ; i < 11; i++){
            for(int j=0; j<15; j++){
                for (int k=0; k<5; k++){
                    score += table[i+k][j];
                }
                if(score==3){
                    one3x3++;
                } else if(score==30){
                    two3x3++;
                }
                score=0;
            }
        }
//        왼대각
        for(int i=0 ; i < 11; i++){
            for(int j=0; j <11; j++){
                for (int k=0; k<5; k++){
                    score += table[i+k][j+k];
                }
                if(score==3){
                    one3x3++;
                } else if(score==30){
                    two3x3++;
                }
                score=0;
            }
        }


        //  오른대각
        for(int i=4 ; i < 15; i++){
            for(int j=0; j <11; j++){
                for (int k=0; k<5; k++){
                    score += table[i-k][j+k];
                }
                if(score==3){
                    one3x3++;
                } else if(score==50){
                    two3x3++;
                }
                score=0;
            }
        }
        if(one3x3 == 2){
            System.out.println("one3x3");
        } else if(two3x3 ==2){
            System.out.println("two3x3");
        }
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
