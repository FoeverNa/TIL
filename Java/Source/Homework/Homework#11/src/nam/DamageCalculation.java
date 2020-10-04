package nam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

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
    // 무기 구현
    BARE_HANDS(5), DAGGER(40), LONG_SWORD(100), DRAGON_SLAYER(250);
    private int damage;
    Weapon(int damage) {
        this.damage = damage;
    }
    DoubleSupplier damageOp = () -> this.damage;
}

enum Item {
    // 소비 아이템 구현
    MUSHROOM((x) -> x + 20, 0),
    BLACK_POTION((x) -> x * 1.1, 1),
    WHITE_POTION((x) -> x + 200, 2);
    private final DoubleUnaryOperator op;
    private final int priority;
    Item(DoubleUnaryOperator op, int priority) {
        this.op = op;
        this.priority = priority;
    }
    public int getPriority() { return priority; }
    public DoubleUnaryOperator getOp() { return op; }
}

class Player {
    Weapon currentWeapon;
    List<Item> items;
    double totalDamage;

    public Player() {
        this(Weapon.BARE_HANDS, new ArrayList<>(), 0.0);
    }
    public Player(Weapon weapon) {
        this(weapon, new ArrayList<>(), 0.0);
    }
    public Player(Weapon weapon, List<Item> items) {
        this(weapon, items, 0.0);
    }
    public Player(Weapon weapon, List<Item> items, double totalDamage) {
        this.currentWeapon = weapon;
        this.items = items;
        this.totalDamage = weapon.damageOp.getAsDouble();
    }

    // TODO: Player에 필요한 메소드 구현
    public void changeWeapon(Weapon weapon) {
        currentWeapon = weapon;
        totalDamage = weapon.damageOp.getAsDouble();
    }
    public void addItems(Item item) {
        items.add(item);
    }
    public double getTotalDamage() {
        items.sort(Comparator.comparingInt(Item::getPriority));
        DoubleUnaryOperator op = x -> x;
        for (Item item: items) {
            op = op.andThen(item.getOp());
        }
        totalDamage = op.applyAsDouble(currentWeapon.damageOp.getAsDouble());
        return totalDamage;
    }
}

public class DamageCalculation {
    public static void main(String[] args) {
        // 무기 및 아이템 장착/사용 시나리오 및 플레이어 공격력 출력
        Player player = new Player(Weapon.LONG_SWORD, new ArrayList<>());
        player.addItems(Item.BLACK_POTION);
        player.addItems(Item.MUSHROOM);
        player.addItems(Item.WHITE_POTION);
        System.out.println(player.getTotalDamage());
    }
}