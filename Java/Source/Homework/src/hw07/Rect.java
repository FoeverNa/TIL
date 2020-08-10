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

    }
}
