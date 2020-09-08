package Colletion.treeset;

public class MemberTreeSetTest {
    public static void main(String[] args) {

        MemberTreeSet manager = new MemberTreeSet();

        Member memberLee = new Member(300, "Lee");
        Member memberKim = new Member(100, "Kim");
        Member memberPark = new Member(200, "Park");

        manager.addMember(memberLee);
        manager.addMember(memberKim);
        manager.addMember(memberPark);

        manager.showAllmember();
        //Kim회원님의 아이디는 100입니다.
        //Park회원님의 아이디는 200입니다.
        //Lee회원님의 아이디는 300입니다.
    }
}
