package src;

/**
 * 3차원 벡터 클래스 구현하기
 *
 * 3차원 벡터를 클래스로 구현하시오.
 *
 * 속성
 * float타입의 x, y, z
 *
 * 생성자
 * Vector3D(float x, float y, float z)
 *
 * 메소드
 * - x, y, z에 대한 getter 및 setter
 * - add(): 벡터끼리의 덧셈, 실수와의 덧셈을 반환
 * - sub(): 벡터끼리의 뺄셈, 실수와의 뺄셈을 반환
 * - inner(): 두 벡터의 내적을 반환
 * - mul(): 실수와의 곱을 반환
 * - mag(): 벡터의 크기를 반환
 * - print(): 벡터의 내용을 "(%.3f, %.3f, %.3f)\n" 형식으로 콘솔에 출력
 */

public class Vector3D {

    float x;
    float y;
    float z;


    public Vector3D (){
    };

    public Vector3D (float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void print(){

        System.out.printf("(%.3f, %.3f, %.3f)\n",x,y,z);

    }

    public Vector3D add(Vector3D v){
        Vector3D vec = new Vector3D();

        vec.x = this.x + v.x;
        vec.y = this.y + v.y;
        vec.z = this.z + v.z;

         return vec;
    }
    public Vector3D add(float f){
        Vector3D vec = new Vector3D();

        vec.x = this.x + f;
        vec.y = this.y + f;
        vec.z = this.z + f;

        return vec;
    }

    public Vector3D sub(Vector3D v){

        Vector3D vec = new Vector3D();

        vec.x = this.x - v.x;
        vec.y = this.y - v.y;
        vec.z = this.z - v.z;

        return vec;
    }

    public Vector3D sub(float f){

        Vector3D vec = new Vector3D();

        vec.x = this.x - f;
        vec.y = this.y - f;
        vec.z = this.z - f;

        return vec;
    }

    public float inner(Vector3D v){

        float f;

        f = (this.x * v.x) + (this.y * v.y) + (this.z * v.z);

        return f;
    }

    public Vector3D mult(float f){
        Vector3D vec = new Vector3D();

        vec.x = this.x * f;
        vec.y = this.y * f;
        vec.z = this.z * f;

        return vec;
    }
    public double mag(){
        double d;

        d =  Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2));

        return d;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}

class Vector3DTest {
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(0.5f, 0.2f, 0.9f);
        Vector3D v2 = new Vector3D(0.8f, 0.1f, 1.3f);

        v1.add(v2).print();
        v2.sub(v1).print();
        v1.add(0.2f).print();
        v2.sub(0.05f).print();
        System.out.println(v1.inner(v2));
        v1.mult(1.2f).print();
        System.out.println(v2.mag());
    }
}