# 자료형(Data Type)

## 자료형이란
- 변수의 종류와 타입을 나타내는 용어
- 변수의 선언할 때 리터럴에 따라 자료형을 필수로 표기해야함
- 자료형은 기본형(Primitive Type), 참조형 (Reference Type)으로 구분함
- 기본형 자료형에는 정수형, 실수형, 문자형, 논리형이 있음
- 참조형에는 String(문자형)외 여러가지가 있음

### 정수형

- 정수형에는 byte, short, int, long이 있음
- 각 자료형 별로 메로리의 크기와 그에 따른 표현범위가 다름
- 메모리의 효율적 사용을 위해서 범위에 맞는 자료형을 사용함
- 정수 자료형의 기본 형은 int이기에 다른 자료형을 쓸때는 별도로 표기히야함
- 정수 자료형은 값의 변동에 따라 overflow가 발생할 수 있으니 유의해야함
- 정수 자료형은 10진수 뿐 아니라 2진수 8진수 16진수로도 표현 가능함

```
        // 정수 자료형 

        System.out.println(Byte.BYTES);
        System.out.println("Byte");
        System.out.println(Byte.BYTES); //1 // Byte자료형은 1BYTE라는 뜻 = 8bit
        byte byteValue = 42;
        System.out.println(byteValue);
        System.out.println(Byte.MAX_VALUE); //2^7 -1  싸인비트를 포현해야되서 (8비트-1비트) 7승
                                            // 0을 표현 해야 되기 떄문에 -1 해준다.(정수= 음수,양수,0)
        System.out.println(Byte.MIN_VALUE); //-2^7  음수까지의 범위를 포함
        // byte byteValue1 = 128; //범위를 넘어선 정수는 에러발생
        System.out.println(""); // 줄바꿈 기능


        System.out.println("Short"); // 2byte = 16bit
        System.out.println(Short.BYTES);//2
        System.out.println(Short.MAX_VALUE);// 2^15 -1
        System.out.println(Short.MIN_VALUE);// -2^15
        System.out.println("");

        System.out.println("Int");
        System.out.println(Integer.BYTES); // 4byte = 32bit
        System.out.println(Integer.MAX_VALUE);// 2^31 -1
        System.out.println(Integer.MIN_VALUE);// -2^31
        System.out.println("");

        System.out.println("Long");
        System.out.println(Long.BYTES); // 8
        System.out.println(Long.MAX_VALUE);// 2^63 -1
        System.out.println(Long.MIN_VALUE);// -2^63
        System.out.println("");

        //왜 다 Long으로 자료형을 안하냐 - 메모리 효율성위해, 필요에 따라 사용하여야 한다.

        //정수자료형의 유의할 점

        //Overflow
        // 32676 = 2^15 - 1 ==> 0111111111111111
        // 64000 => 10011111101111011110111 (엄밀하지않은수, 랜덤숫자)
        // 64000을 short로 바꾸면서 중간에 잘라버리고 앞자리가 1로바뀌어 음수가되고 남아있는 비트만큼 숫자가잡힘
        // ==> 음수로출력 , 이런현상을 overflow현상이라고함
        short shortValue = (short) 64000; //숫자를 short형으로 바꿈
        System.out.println(shortValue); // -1536,

        // 정수형은 기본적으로 int이기 때문에 다른 유형의 정수 선언시 별도로 표기해주어야함

        // byte byteValue3 = 144; // byte지만 기본 형인 int형으로 표현됨 so 4byte자료형으로표현됨

        short shortA = 10;
        short shortB = 20;
        // short shortC = shortA + shortB; //에러, 둘다 shortA와 shortB의 값이 int이기 때문에 shortC에들어갈수가 없음
        short shortC = (short)(shortA + shortB); // 더한값을 캐스팅해줘야 short로 들어갈수가 있음
        // shortA는 인티저가 아니라 변수가 맞다. 근데 언어에서 변수의값이 Integer가 기본값이다.  
        //정확한 연산과정
        // shortA와 showrB가 int로 먼저 변환이 된다.
        // +연산이 이루어진다
        // 연산된 값이 short로 변환된다

        int bigInt = Integer.MAX_VALUE;
        int biggerInt = bigInt + 1;
        System.out.println(biggerInt); // - 2147483648 int의 범위넘어서서 값이 잘려서 음수가됨
                                        // int의경우 에러도 안뜸 기본형이라.. so 직접 overflow조심해야함

        //long veryBigInt = 100000000000; //에러발생 너무커서
        long veryBigInt = 100000000000L; // 라지 L을 붙여줘서 Long인것을 알려줘야함 왜? 앞에서 Long은 자료형이고 값에붙은 Long은 리터럴이기때문
        long veryBigint2 = 100_000_000_000L; // 숫자의 가시성을위해 언더바로 구분할 수 있다. 3개씩 아니라 다양하게 할수있지만 3개씩만하늘걸로
        System.out.println(veryBigInt);
        System.out.println("");

        //진수법- Binary(2진수), Octal(8), Decimal(10), Hexadecimal(16)

        System.out.println(0b1101); // 0b하면 2진수 입력  //13
        System.out.println(071);// 0만있으면 8진수 // 57 //10진수랑 비슷해서 해깔려서 가능하면 쓰지마세요
        System.out.println(1424); // 숫자는 그냥입력
        System.out.println(0x10); //0x를 하면 16진수입력, 0~9까지는 숫자 10~16 : a,b,c,d,e,f 까지쓰면됨
        System.out.println(0xff); //

      
        //리터럴은 어던 변수의 대입되지 않은 순수한 값 64000은 리터럴  대입이된 수는 리터럴이 아님


```

### 실수형

- 실수 자료형으로는 float과 double이 있음
- 기본형이 double이기에 연산할 때 double형으로 변환되어 연산됨
- float 변수를 선언할때는 리터럴 끝에 f(F) 붙여줘야함
- 실수 리터럴은 지수형으로 표현 가능


```$xslt
        // 실수형 float, double
        System.out.println("float");
        System.out.println(Float.BYTES); // 4
        System.out.println(Float.MAX_VALUE); // 3.4028235 * 10^38
        System.out.println(Float.MIN_VALUE); // 1.4 * 10^-45 :resoulution (가장작게 구분할수있는수)
        System.out.println("");

        System.out.println("double");
        System.out.println(Double.BYTES); // 8
        System.out.println(Double.MAX_VALUE); // 1.8 * 10^308
        System.out.println(Double.MIN_VALUE); // 4.9 * 10^-324
         //: resoulution=해상도=단위 이수보다 더 작아질수가 없다.(정수에 resoultion은 1) (가장작게 구분할수있는수)
         //0에서 resoultion만큼 간 수가 MIN_VALUE = 0보다크면서 가장작은값
        System.out.println("");               // 정밀도 증가
        
        //일반적으로는 double로 바뀌어서 연산되기때문에 이것도 캐스팅해줘야함

        float floatVal = 1.4234f;
        float floatval2 = (float)1.4234;

        double doubleVal = 104.424132341234;
        // 실수 리터럴은 지수형으로도 표현 가능함
        double doubleVal2 = 1.423e8; //e8 = 10^8  //10 몇승 포함해서
        double doubleVal3 = 1.423E8; // 대문자 소문자 둘다 가능

```

### 문자형

- 문자형엔 Char 타입이 있음
- 문자열이 아닌 문자형임으로 한개의 문자 리터럴만 대입가능
- ''작은 따옴표를 사용함
- Char을 int형으로 캐스팅할 수 있고 각 문자마다 숫자가 배정되어 있음
- 문자에 배정된 숫자를 테이블로 정리한 것을 아스키코드/유니코드 라고 함

```$xslt
        //문자형
        System.out.println("Char");
        System.out.println(Character.BYTES);
        System.out.println((int)Character.MAX_VALUE); // 캐스팅을해줘야 정수로 값을 볼수 있음 / 2^16 - 1 싸인비트가 없어서 정직하게들어감
                                                        // 맥스 숫자에 배정된 문자가 없어서 캐스팅안하면 출력이 안됨
        System.out.println((int)Character.MIN_VALUE); // 0
        System.out.println("");

        char charVal = 'A';
        System.out.println(charVal); // A
        System.out.println((int)'A'); // 65, 숫자를 외울필요는 없지만 문자를 숫자로 찍어보면 나온다 이정도만 알면됨
                                    // 이것 확장해서 숫자와 문자열을 표로 만든 것을 아스키코드/유니코드 라고한다
        System.out.println('C'); //작은따옴표 안에 1개이상은 입력 불가,
        System.out.println('\''); //작은따옴표 넣기위해 \를 사용해야함함
        System.out.println('"'); //이것도 가능하긴해 그래도 역슬래시쓰는게조음
        System.out.println('\"');

        System.out.println('\u0041'); //유니코드 칠땐 /u을 붙이고 뒤에 숫자는 16진수를 사용함// 16진수 41 => 65 == 'A'
        System.out.println((char)65);
```

###논리형

- 논리를 판단하는 자료형으로 true와 false값만 가짐

```$xslt
        System.out.println("boolean");
        System.out.println(Boolean.TRUE);
        System.out.println(Boolean.FALSE);

        boolean isTrue = true;
        boolean isFalse = false;

        // isTure =1; // 다른 언어에서는 1=true, 0=false로 대입이 가능하지만 Java에서는 안됨
        // isFalse = 0;
        System.out.println("");
```

###문자열

- 문자열(String)은 참조형 자료형이며 큰따옴표를 사용함
- 문자열은 덧셈(+)로 이어 붙일 수 잇음
- 문자열에 정수혹은 실수 리터럴을 더하면 자동으로 수를 문자열로 변환하여 함게 문자열로 출력 해 줌

```$xslt
        System.out.println("String");
        String s = "This is a new string.";
        System.out.println(s);

        String s1 = "This" + "is" + "also" + "a String.";
        System.out.println(s1);

        int intVal10 = 20;
        String s2 = "Stirng + Integer = " +intVal10; // 자동으로 String으로 변환후 연산
        System.out.println(s2);

        String s3 = "String + Integer= " + Integer.valueOf(intVal10).toString();//수동으로 String 변환후 연결
        System.out.println(s3);
        System.out.println("");
        //s2와 s3는 똑같은 과정을 거쳐서 STring으로변환되는것이고 자바에서 평의기능을 제공한 것임

        //다른 실수형 자료형에서도 똑같이 자동변환이 일어난다
```


### 형변환 (Type Casting)

- 변수의 자료형을 바꿔주는 것을 형변환이라고 함
- 변수앞에 (자료형)을 넣어주어 형변환을 함
- 범위가 작은쪽에서 큰쪽 혹은 정밀도가 낮은쪽에서 높은쪽으로 형변환하는 것을 업캐스팅이라고함
    - 업캐스팅의 경우 가장 가까운 자료형으로 형변환 된다 (ex int => float not double)
- 반대의 경우를 다운캐스팅이라고 하고 데이터가 소실 될 수 있음으로 주의하여야 함
    - 데이터 소실의 위험성을 프로그래머가 인지하고 있음을 표기하는 방법으로 (자료형)을 명시한다


```$xslt
/* //형변환(Type Casting)
        System.out.println("Casting");
        int intValue = (int)100.9;
        System.out.println(intValue); //100 // 캐스팅 시 값이 소실이 됨

      
        //Upcasting
        System.out.println("Upcasting"); // 범위가 작은 쪽 -> 범위가 큰 쪽
                                        //또는 정밀도가 낮은 쪽 - > 정밀도가 큰 쪽(실수)

        byte byteVal = 10;
        int intVal = byteVal;
        System.out.println(intVal); //10 // 1byte 에서 4byte로 넘어오니 자연스럽게 소실 없이 넘어옴
        intVal = (int)byteVal;//검은색안내문 redundant하다-> 자동으로 변환되기때문에 굳이 쓸필요없다.// 하지만 필요에따라서 하기도함

        intVal = 10244;
        long longVal = intVal; //자동으로 upcasting 됨
        longVal = (long)intVal; //

        float floatVal = longVal; // float: 4byte long:8byte// byte가 long이 크지만 upcasting됨// 범위가 중요하다는 얘기
        floatVal = (float)longVal;// redundant뜨진 않지만 자동으로 되는 캐스팅
        System.out.println(floatVal);

        double doubleVal = floatVal;
        doubleVal = floatVal; // 범위, 정밀도가 double이 높아서 upcasing 됨

        */


        //DownCasting

        long longVal = 104244L;
        // int intVal = longVal; // 에러//Downcasting은 자동으로 이루어지지 않습니다.
        int intVal = (int)longVal; // 직접캐스팅해줘야함 (자료형)
        System.out.println(intVal);

        longVal = 100_000_000_000L;
        intVal = (int)longVal;
        System.out.println(intVal); //1215752192 // Downcasting 하면서 상위 비트가 소실딤 -> 하위비트만으로 수표현 -> 어떤수 나올지 예측 어려움
                                    // 문제가 생길 소지가 있기에 캐스팅을 해줘야함

        char charVal = 4123; // 큰 숫자지만 char의 범위안임.
        byte byteVal = (byte)charVal; // Char의 범위 > byte의 범위
        System.out.println(byteVal); //27 // 데이터 손실 발생


```




