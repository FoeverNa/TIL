package hw07;

import java.util.Arrays;

/**
 * 아래 테스트 코드가 정상 동작하도록 클래스들을 완성하시오.
 *
 * getArea(): 사각형의 넓이를 반환한다.
 * getCenterOfMass(): 사각형의 질량중심을 반환한다.
 * GetAllPoints(): 사각형의 네 점을 배열로 반환한다.
 * rot90(): Pivot을 기준으로 사각형을 90도 회전시킨다.
 */


class Vector2D {
    public float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {

        return this.x +","+this.y;
    }
}

class RectCore {
    protected Vector2D pos;
    protected float w, h;


    public RectCore(float x, float y, float w, float h) {
        this.pos = new Vector2D(x, y);
        this.w = w;
        this.h = h;
    }

    public String toString() {
        // write codes here
        return "RECTCORE";
    }
}


public class Rect extends RectCore {
    String rotRec;

    public Rect(float x, float y, float w, float h) {
        super(x, y, w, h);
        rotRec = "";
    }
    // 위에 객체가져오기위해서 super()해야했음

    public float getArea() {
        float area = this.w * this.h;
        return area;
    }

    public Vector2D getCenterOfMass() {

        float x1,y1;
        x1= pos.x + (w /2);
        y1 = pos.y +(h /2);
        return new Vector2D(x1, y1);
    }
    // 질량 중심  : 물체가 있을때 각각의 위치마다 질량의 덴서티를 곱해서, 위치마다 ...ㅏㅈ덕
    // 4점중에 평균지점을 찍으면됬데 공식은 맞은듯, // 적분을 해야하는 상황이 맞데..
    // 특정상황에 맞춰서 어떤 공식을 사용해야하는지 알아야한다..그래야 실무함..ㅠㅠㅠ //
    // 내가고민햇던거랑 마찬가지...그림그리는것조은데 그것을 가지고 구하루잇는 공식을 생각해봐봐... 수학자들이 다 해줄거야

    public Vector2D [] getAllPoints() {
        Vector2D vec00 = new Vector2D(pos.x,pos.y);
        Vector2D vec01 = new Vector2D(pos.x,(pos.y+h));
        Vector2D vec10 = new Vector2D((pos.x+w),pos.y);
        Vector2D vec11 = new Vector2D((pos.x+w),(pos.y+h));

        return new Vector2D[]{vec00,vec01,vec10,vec11};
    }


    public void rot90(Vector2D pivot) {
        Vector2D vec00 = new Vector2D(pivot.x+(pos.y-pivot.y),pivot.y-(pivot.x-pos.x));
        Vector2D vec01 = new Vector2D(pivot.x+(pos.y-pivot.y)+h,pivot.y-(pivot.x-pos.x));
        Vector2D vec10 = new Vector2D(pivot.x+(pos.y-pivot.y),pivot.y-(pivot.x-pos.x)+w);
        Vector2D vec11 = new Vector2D(pivot.x+(pos.y-pivot.y)+h,pivot.y-(pivot.x-pos.x)+w);
        Vector2D[] vec = new Vector2D[]{vec00,vec01,vec10,vec11};
        rotRec = Arrays.toString(vec);

    }

    //피벗을 중심으로 90도를 돌리라는말....
    //90도를 돈다는것은... 점들이 모두 90도로 돌거야
    // 일반적인 상황으로 적용하는건 이번에도 실패..
    //원점을 기준으로 x > -y가 되고 y -> x가 되는거래
    // 그럼 피봇을 기준으로 동작을 하려면 원점을 이동시키고 90도이동시키고 다시 피벗으로 이동시키면됨
    // 피벗 x,y를 빼주면 원점으로 옮겨간데(요백터빼기 더백터는 요백터리...몬솔)
    //  그리고 4점에 min max를 통해 위치를 유추하고
    // 다시 민민을 모아서 포지션 잡아주고 맥스에서 빼서 윗스 하이트를 계산해줌
    // 좌표계 로테이션 따로 공부하기 -> 나올대마다 배우는 습관이 좋은 습관 => 개발자는 모든걸 알아야한데 으슈바라ㅓㅏㅣㄹ머지;ㄷ겆닥;ㅣ젇ㄱ

    @Override
    public String toString() {

        return rotRec;
    }
}

class RectTest {
    public static void main(String[] args) {
        Rect rect = new Rect(0.5f, 0.7f, 1.5f, 2.3f);
        System.out.println("Area: " + rect.getArea());
        System.out.println("CoM: " + rect.getCenterOfMass());
        System.out.println("All Points: " + Arrays.toString(rect.getAllPoints()));

        rect.rot90(new Vector2D(0.4f, 0.2f));
        System.out.println("Rotated rect: " + rect);
        // toString 메서드자체가 오버라이드 되면 객체명을 썼을 때 그 출력문을 출력하게 되어있데
    }
}


// 코딩을 위한 유용한 클래스를 만들기위해선 실제 이런 문제들을 직면하게됨...으슈발
// 그래서 이런거랑 친해져야한대
// 자바키워드 암기도 중요하지만 실제 이런 문제를 해결할수있어야 실무에 투입가능하다.....맞말
// pos 는 정확히 정의되지 않았기 때문에 어디에 있는지는 우리가 선택할수 있었데
//
