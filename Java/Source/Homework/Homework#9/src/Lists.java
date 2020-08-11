/**
 * List 인터페이스를 구현하여 IntArrayList 클래스를 완성하시오.
 * 
 * List는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 *
 * - append(): List의 마지막에 value를 삽입한다.
 * - prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index의 value를 반환한다.
 * - length(): List의 길이를 출력한다.
 * 
 * IntArrayList는 int []를 이용하여 List를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List {
    public void append(int value);
    public void prepend(int value);
    public void insert(int index, int value);
    public void remove(int index);
    public int get(int index);
    public void length();
}

class IntArrayList implements List {

    private int capacity;
    protected int length;
    private int[] array;

    public IntArrayList (int capacity){
        this.capacity = capacity ;
        length = 0;
        array = new int[capacity];
    }

    @Override
    public void append(int value) {

        if(capacity == length){
            int[] newarray = new int[capacity*2];
            capacity *= 2 ;

            System.arraycopy(array, 0, newarray, 0, array.length);
             array = newarray;
        }
             array[length] = value;
             length++;
    }

    @Override
    public void prepend(int value) {
        if (capacity == length + 1) {
            int[] newarray = new int[capacity * 2];
            capacity *= 2;

            for (int i = 0; i < array.length; i++) {
                newarray[i] = array[i];
            }
            array = newarray;
        }

        int[] newarray2 = new int[length+2];
        for(int i = 0; i < length+1; i++){

            newarray2[i+1] = array[i];
            array[i] = newarray2[i];
        }

        array[0] = value;
        length++;
    }

    @Override
    public void insert(int index, int value) {
        if(index>length) {
            System.out.println("Out of range");
        }
        else{
        if (capacity == length + 1) {
            int[] newarray = new int[capacity * 2];
            capacity *= 2;

            System.arraycopy(array, 0, newarray, 0, array.length);
            array = newarray;
        }

            int[] newarray2 = new int[length+2];
            for(int i = index ; i < length+1; i++){

                newarray2[i+1] = array[i];
                array[i] = newarray2[i];
            }

            array[index] = value;
            length++;
        }
    }

    @Override
    public void remove(int index) {

        if(index>length) {
            System.out.println("Out of range");
        } else {
            int[] newarray = new int[length];

            for (int i = index; i < length - 1; i++) {
                newarray[i] = array[i + 1];
                array[i] = newarray[i];
            }

            length--;
        }
    }

    @Override
    public int get(int index) {
        if(index> length-1){
            return -1;
        } else {
            return array[index];
        }

    }

    @Override
    public void length() {
        System.out.println(length);

    }
}

class Main{
    public static void main(String[] args) {
        IntArrayList list = new IntArrayList(4);

        for(int i=0; i < 20 ; i ++){
            list.append(i);
        }

        //get Test

//        for(int i =0; i<15 ; i++){
//            Syste1m.out.println(list.get(i));
//        }

        // prepend Test
//        list.prepend(55);
//
//        for(int i =0; i<21 ; i++){
//            System.out.println(list.get(i));
//        }

        //insert Test
//        list.insert(4,1231);
//
//        for(int i =0; i<21 ; i++){
//            System.out.println(list.get(i));
//        }

        //remove Test
//        list.remove(23);
//
        for(int i =0; i< 25; i++){
            System.out.println(list.get(i));
        }

        //length Test
//        list.length();

        list.remove(29);


    }
}
