package Colletion.set;

public class MemberHashSetTest {
    public static void main(String[] args) {

        MemberHashSet manager = new MemberHashSet();

        Member memberLee = new Member(100, "Lee");
        Member memberKim = new Member(200, "Kim");
        Member memberPark = new Member(300, "Park");
        Member memberPark2 = new Member(300, "Park");

        manager.addMember(memberLee);
        manager.addMember(memberKim);
        manager.addMember(memberPark);
        manager.addMember(memberPark2);// equals와 hashcode 오버라이딩 하니 자동으로 안들어감..wow
//
        manager.showAllmember();
//
//        manager.removeMember(100);
//        manager.showAllmember();


        //set을 쓸때 set에 사용할 객체가 논리적으로 같은지 정의가 되어있는지 확인하고 안되어있으면 해주어야함
        //그렇지 않으면 set이 유지가 안된다.Integer나 String같이 이미 기존에 있는 클래스들은 정의가 되어있어서 사요가능하다
    }
}
