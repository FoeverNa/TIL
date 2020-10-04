package sol.prac;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;

/**
 * 열거형 타입과 함수형 프로그래밍을 이용하여 플레이어의 공격력을 계산하는 알고리즘을 구현하시오.
 *
 * 플레이어 공격력을 계산하는 과정은 아래와 같다.
 * 1. 플레이어의 무기에 따라 공격력이 변화한다. 무기는 최근에 장착한 무기의 공격력 만으로 계산된다.
 *   1-1. BARE_HANDS - 공격력 5
 *   1-2. DAGGER - 공격력 40
 *   1-3. LONG_SWORD - 공격력 100
 *   1-4. DRAGON_SLAYER -  공격력 250
 * 2. 플레이어의 공격력에 영향을 주는 아이템에 따라 공격력 증가 방식이 다르며, 아이템은 중복 적용된다.
 *   2-1. BLACK_POTION - 공격력 10% 증가
 *   2-2. WHITE_POTION - 모든 공격력 계산이 끝난 후에 공격력 + 200
 *   2-3. MUSHROOM - 무기 공격력 + 20
 *
 */

enum Weapon {
    BARE_HANDS(5), DAGGER(40), LONG_SWORD(100), DRAGON_SLAYER(250);

    private final int damage;

    Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}

enum Item {

    MUSHROOM(x -> x+20 , 0),
    BLACK_POTION(x -> (int) (x*1.1), 1),
    WHITE_POTION(x -> x+200, 2);

    private IntUnaryOperator op;
    private int priority;

    private Item(IntUnaryOperator op, int priority){
        this.op = op;
        this.priority = priority;
    }

    public IntUnaryOperator getOp() {
        return op;
    }

    public int getPriority() {
        return priority;
    }
}

class Player {
    Weapon currentWeapon = Weapon.BARE_HANDS;
    List<Item> items  = new ArrayList<>();

    void changeWeapon (Weapon weapon){
        currentWeapon = weapon;
    }
    void useItem (Item item){
        items.add(item);
    }

    int calcDam (){
        items.sort(Comparator.comparingInt(Item::getPriority));
        IntUnaryOperator op = x -> x;
        for(Item item : items){
            op = op.andThen(item.getOp());
        }

        return op.applyAsInt(currentWeapon.getDamage());
    }

    }

public class DamageCalculation {
    public static void main(String[] args) {

        Player player = new Player();

        System.out.println( player.calcDam());

        player.changeWeapon(Weapon.DAGGER);
        System.out.println( player.calcDam());
        player.useItem(Item.MUSHROOM);
        System.out.println( player.calcDam());
        player.useItem(Item.MUSHROOM);
        player.useItem(Item.MUSHROOM);
        player.useItem(Item.MUSHROOM);
        System.out.println( player.calcDam());
        player.useItem(Item.BLACK_POTION);
        System.out.println( player.calcDam());
        player.useItem(Item.BLACK_POTION);
        System.out.println( player.calcDam());
        player.useItem(Item.BLACK_POTION);
        System.out.println( player.calcDam());
        player.changeWeapon(Weapon.LONG_SWORD);
        System.out.println( player.calcDam());


    }
}