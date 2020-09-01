package Hw.PairProgramming1;

import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {

    public static final int table_Width = 15;
    public static final int table_Height = 15;
    Player player_One;
    Player player_Two;
    public boolean isEmpty;
    public int[][] table;
    public boolean isCorret = false;
    public int score = 0;
    int black33=0;
    int white33=0;

    public Gomoku() {

    }

    // Gomoku 최상위 메서드
    public void startGame() {

        initialize();
        getWinner();
        outer:
        while (true) {
            while (true) {
                Player player = whosTurn();
                while (!isEmpty) {
                    player.getKeyboardInput();
                    checkQuitGame(player.pos);
                    if (isCorret) break outer;

                    checkEmpty(player.pos);
                }
                play(player, player.pos);
                printStatus();
                check3x3(player.pos);
                if (isCorret) break;
                isFinished();
                if (isCorret) break;
            }
            reset();
       }
        getWinner();
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
    public Player whosTurn() {
        if (player_One.turn == player_Two.turn) {
            return player_One;
        } else {
            return player_Two;
        }
    }

    //사용자가 q를 입력했는지
    public void checkQuitGame(Position pos) {
        if (pos.x == 999) {
            isCorret = true;
        }

    }

    // 바둑판이 비어있는지 확인하는 메서드드
    public void checkEmpty(Position pos) {
        if (player_One.turn + player_Two.turn == 0) {
            isEmpty = true;
        } else if (table[pos.x][pos.y] == 0) {
            isEmpty = true;
        } else {
            System.out.println("이미 돌이 놓아진 자리입니다");
        }
    }


    @Override
    public void play(Player player, Position pos) {
        if (player == player_One) {
            table[pos.x][pos.y] = 1;
        } else {
            table[pos.x][pos.y] = 10;
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
                    System.out.print("X   ");
                } else if (table[i][j] == 10) {
                    System.out.print("O   ");
                }
            }
            System.out.println("");
        }
    }

    public void check3x3(Position pos) {
        int sum = 0;
        int sum_Blank = 0;


        //가로
        //왼쪽 끝
        if (pos.y==2){
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x][pos.y+i];
            }
            for(int i =1 ; i<=2 ; i++){
                sum_Blank += table[pos.x][pos.y-i];
            }
            if(sum_Blank ==0 && sum == 3 ){
                black33++;
            }else if(sum_Blank ==0 && sum == 30 ){
                white33++;
            }
            sum=0;
            sum_Blank=0;
        }else if (pos.y==12){ //오른쪽 끝
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=2 ; i++){
                sum_Blank += table[pos.x][pos.y+i];
            }
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x][pos.y-i];
            }
            if(sum_Blank ==0 && sum == 3 ){
                black33++;
            }else if(sum_Blank ==0 && sum == 30 ){
                white33++;
            }
            sum=0;
            sum_Blank=0;
        } else if(pos.y>2 && pos.y<12){ //중간
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x][pos.y+i];
                sum += table[pos.x][pos.y-i];
            }
            if(sum==3){
                black33++;
            } else if( sum==30){
                white33++;
            }
            sum=0;
        }
        is33();



        //세로
        //위쪽 끝
        if (pos.x==2){
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x+i][pos.y];
            }
            for(int i =1 ; i<=2 ; i++){
                sum_Blank += table[pos.x-i][pos.y];
            }
            if(sum_Blank ==0 && sum == 3 ){
                black33++;
            }else if(sum_Blank ==0 && sum == 30 ){
                white33++;
            }
            sum=0;
            sum_Blank=0;
        }else if (pos.x==12){ //오른쪽 끝
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=2 ; i++){
                sum_Blank += table[pos.x+i][pos.y];
            }
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x-i][pos.y];
            }
            if(sum_Blank ==0 && sum == 3 ){
                black33++;
            }else if(sum_Blank ==0 && sum == 30 ){
                white33++;
            }
            sum=0;
            sum_Blank=0;
        } else if(pos.x>2 && pos.x<12){ //중간
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x+i][pos.y];
                sum += table[pos.x-i][pos.y];
            }
            if(sum==3){
                black33++;
            } else if( sum==30){
                white33++;
            }
            sum=0;
        }
        is33();

        //왼대각
        //왼쪽 위 끝
        if (pos.x==2 && pos.y> 1 && pos.y<11
            || pos.x >2 && pos.x <10 && pos.y==2){

            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x+i][pos.y+i];
            }
            for(int i =1 ; i<=2 ; i++){
                sum_Blank += table[pos.x-i][pos.y-i];
            }
            if(sum_Blank ==0 && sum == 3 ){
                black33++;
            }else if(sum_Blank ==0 && sum == 30 ){
                white33++;
            }
            sum=0;
            sum_Blank=0;
        }else if (pos.x>3 && pos.x<12 && pos.y==12
                  || pos.x ==12 && pos.y>3 && pos.y<13){ //오른쪽아래 끝
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=2 ; i++){
                sum_Blank += table[pos.x+i][pos.y+i];
            }
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x-i][pos.y-i];
            }
            if(sum_Blank ==0 && sum == 3 ){
                black33++;
            }else if(sum_Blank ==0 && sum == 30 ){
                white33++;
            }
            sum=0;
            sum_Blank=0;
        } else if(pos.x>2&&pos.x<12 && pos.y>2 && pos.y<12){ //중간
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x+i][pos.y+i];
                sum += table[pos.x-i][pos.y-i];
            }
            if(sum==3){
                black33++;
            } else if( sum==30){
                white33++;
            }
            sum=0;
        }
        is33();


        //오른대각대각
        if (pos.x==2 && pos.y> 3 && pos.y<13
            || pos.x>2&& pos.x<11 && pos.y ==12){

            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x+i][pos.y-i];
            }
            for(int i =1 ; i<=2 ; i++){
                sum_Blank += table[pos.x-i][pos.y+i];
            }
            if(sum_Blank ==0 && sum == 3 ){
                black33++;
            }else if(sum_Blank ==0 && sum == 30 ){
                white33++;
            }
            sum=0;
            sum_Blank=0;
        }else if (pos.x>3 && pos.x<12 && pos.y==2
                || pos.x ==12 && pos.y>1 && pos.y<11){ //오른쪽아래 끝
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=2 ; i++){
                sum_Blank += table[pos.x+i][pos.y-i];
            }
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x-i][pos.y+i];
            }
            if(sum_Blank ==0 && sum == 3 ){
                black33++;
            }else if(sum_Blank ==0 && sum == 30 ){
                white33++;
            }
            sum=0;
            sum_Blank=0;
        } else if(pos.x>2&&pos.x<12 && pos.y>2 && pos.y<12){
            sum+=table[pos.x][pos.y];
            for(int i =1 ; i<=3 ; i++){
                sum += table[pos.x-i][pos.y+i];
                sum += table[pos.x+i][pos.y-i];
            }
            if(sum==3){
                black33++;
            } else if( sum==30){
                white33++;
            }
            sum=0;
        }
        is33();
    }

    public void is33(){
        if (black33==2){
            player_Two.numCount();
            System.out.println("3X3으로 X가 패배했습니다");
            isCorret=true;
        }
        if (white33==2){
            player_One.numCount();
            System.out.println("3X3으로 O가 패배했습니다");
            isCorret=true;
        }
    }



    @Override
    public void isFinished() {


        //가로 5개
        for (int i = 0; i < table_Height; i++) {
            for (int j = 0; j < table_Width - 4; j++) {
                for (int k = 0; k < 5; k++) {
                    score += table[i][j + k];
                }
                checkScore();
            }
        }

//        세로 5개
        for (int i = 0; i < table_Height - 4; i++) {
            for (int j = 0; j < table_Width; j++) {
                for (int k = 0; k < 5; k++) {
                    score += table[i + k][j];
                }
                checkScore();
            }
        }
//          오른쪽대각
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 5; k++) {
                    score += table[i + k][j + k];
                }
                checkScore();
            }
        }
//              왼쪽대각
        for (int i = 4; i < table_Height; i++) {
            for (int j = 0; j < table_Width - 4; j++) {
                for (int k = 0; k < 5; k++) {
                    score += table[i - k][j + k];
                }
                checkScore();
            }
        }
    }

    public void checkScore() {
        if (score == 5) {
            player_One.numCount();
            System.out.println(player_One.getName() + ": " + player_One.getNumWin() + "번 이겼다!");
            isCorret = true;
        } else if (score == 50) {
            player_Two.numCount();
            System.out.println(player_Two.getName() + ": " + player_Two.getNumWin() + "번 이겼다!");
            isCorret = true;
        }
        score = 0;
    }


    @Override
    public void reset() {
        System.out.println("게임을 다시 시작 합니다");
        isEmpty = false;
        isCorret = false;

        for (int i = 0; i < table_Height; i++) {
            for (int j = 0; j < table_Width; j++) {
                table[i][j] = 0;
            }

        }
    }

        @Override
        public Player getWinner () {
            System.out.println(
                     player_One.getName()+ " " + player_One.getNumWin() + "  -  "
                     + player_Two.getNumWin()+ " " + player_Two.getName());
            return null;
        }
    }

