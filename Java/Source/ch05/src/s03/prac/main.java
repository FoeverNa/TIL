package s03.prac;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static java.lang.annotation.ElementType.FIELD;


@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
        // 우리가 뭔가해보기 위해선 런타임으로 해야된다
@interface MyAnnotation {// 여기까지 하면 기본구색 완성

    String[] value(); // 애노테이션 속성(기본 생성 이름은 valeu) => 첫번째 속성은 value가 되는게 좋다

    String valueTwo() default "기본값"; // default = 사용하지 않았을 때 기본적으로 들어가는값
}

class AnnotationUsage {
    @MyAnnotation("game")// valueTwo는 기본값이 있어서 넣지 않더라도 괜찮지만 기본값이 없으면 하나라도 값을 입력해야 한다
    String gameName = "여러분의 틱택토";
    @MyAnnotation(value = {"server"}, valueTwo = "localhost")
    String ServerIP;
    @MyAnnotation("game")
    String gameMode = "AI vs AI";
    @MyAnnotation(value = "server", valueTwo = "8888")
    String serverPort;
    @MyAnnotation(value = "db", valueTwo = "localhost")
    String database;

}

public class main {
    /**
     * 멤버 변수를 대상으로 하는, Reflection API에서 쓸 수 있는 애노테이션
     * 애노테이션 속성은 String[]인 value와 "기본값" 기본값을 가지는 valueTwo로 이루어짐
     */
//    @Target({FIELD})
//    @Retention(RetentionPolicy.RUNTIME)
//            // 우리가 뭔가해보기 위해선 런타임으로 해야된다
//    @interface MyAnnotation { //여기까지하면 기본구색 완성성
//        String[] value(); // 애노테이션 속성 ( 기본 성성 이름은 value) => 첫번째 속성은 vlaue가 되는게 좋다
//
//        String valueTwo() default "기본값"; // 사용하지 않았을때 기본적으로 들어가는 값
//    }

    /**
     * - 멤버변수를 대상으로 하는, Reflection API에서 쓸 수 있는 애노테이션
     * - 애노테이션 속성은 String[]인 value와 "기본값" 기본값을 가지는 valueTwo로 이루어진다
     */


    public static void main(String[] args) throws IllegalAccessException {
//        @SuppressWarnings(value = {"unsed", "rawtypes"})
//        int x = 0;
//        @SuppressWarnings(value = "unsed")
//        int y = 0;
//        @SuppressWarnings({"unsed", "rawtypes"})
//        int z = 0;
//        @SuppressWarnings(key1 = "value1", key2 = {"value2", "value3"})
//        int w = 0;

        AnnotationUsage obj = new AnnotationUsage();
        Map<String, Object> gameProp = new HashMap<>();
        Map<String, Object> serverProp = new HashMap<>();
        Map<String, Object> dbProp = new HashMap<>();

        Field[] fields = AnnotationUsage.class.getDeclaredFields(); // 필드 정보를 가져오는 부분(Reflection API 이용)
        for (Field field : fields) {
            MyAnnotation annotation = field.getDeclaredAnnotation(MyAnnotation.class); // 필드에서 Annotation 정보 가져오는 부분(Reflection API)(멤버이름, 값정도)
            if (field.get(obj) == null) {// 필드 값이 비어있는 경우 valueTwo에서 가져온다
                field.set(obj, annotation.valueTwo());
            }

            if (annotation.value()[0].equals("game")) {
                gameProp.put(field.getName(), field.get(obj));
            } else if (annotation.value()[0].equals("server")) {
                serverProp.put(field.getName(), field.get(obj));
            } else {
                dbProp.put(field.getName(), field.get(obj));
            }

        }
        System.out.println(gameProp);
        System.out.println(serverProp);
        System.out.println(dbProp);

    }
}