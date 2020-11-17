# SQL(Structured Query Language)

## SQL이란?

- SQL은 관계형 데이터베이스 관계 시스템(RDBMS)의 데이터를 관리하기 위해 설계된 특수목적의 프로그래밍 언어이다.
  - 관계형 데이터 베이스 관리 시스템에서 자료의 검색과 관리, 데이터베이스 스키마 생성과 수정, 데이터 베이스 객체 접근 조정 관리를 위해 고안되었다.
- SQL은 표준이라고 하지만 실제로는 많은 종류의 SQL이 존재한다. 하지만 주요 명령어는 표준화된 것을 따른다
  - 아래에 정리된 SQL은 MySQL에서 사용하는 SQL이다
- 참고자료
  - https://www.w3schools.com/sql/sql_intro.asp
  - https://ko.wikipedia.org/wiki/SQL

## SQL 구문

### 명령어 종류

#### DML(Data Manipualtion Language)

- 데이터 조작어(가장 많이 사용하는 쿼리문)
  - 데이터 검색, 삽입 수정, 삭제등에 사용된다 (이를 CRUD라고 한다)
  - SELECT, INSERT, UPDATE, DELETE
- 트랜젝션이 발생하는 SQL문
  - 트랙잭션 예)
  - ATM에서 하나의 계좌가 있다
  - ATM 1 800원인출  ATM 2 600원 인출하는상황
    - 800 <account / ok / a =800 , 600 <account /ok /b = 600
    - -400원이 되는데 이러면안되니까 트랙젝션이란 개념 만들어서 
      - 그래서 위에 3개의 절차를 하나의 절차로 묶는다 -> 그래야 하나의절차 끝나고 다음절차로 이어질 수 있기 때문이다.

#### DDL(Data Definition Language)

- 데이터 정의어
  - 관계형 데이터 베이스의 구조를 정의하는데 사용된다
  - 데이터 베이스, 테이블, 뷰, 인덱스등의 데이터 베이스 개체를 생성, 삭제, 변경에 사용된다
  - CREATE, DROP, ALTER, TRUNCATE
- 실행 즉시 DB에 적용

#### DCL(Data Control Language)

- 데이터 제어어
  - 데이터에 대한 액세스를 제어하기 위해 사용된다
    - 사용자의 권한을 부여하거나 회수할 때 사용한다
      - 루트계정 외에 여러 계정을 등록할 수 있기 때문에 사용하는 쿼리문이다.
  - GRUNT, REVORKE, DENY

### SELECT FROM

- 데이터를 검색할 때 사용되는 문법

### WHERE, IN, LIKE

- WHERE 
  - 특정 조건을 주어 데이터를 검색하는데 사용되는 문법
  - 함께사용하는 명령어
    - BETWEEN
      - 범위를 조건화 할 때 사용하는 문법
    - LIKE
      - 문자열을 조건으로 사용할 때사용
      - %을 붙여 해당 부분에 다른 문자열이 올 수 있는지 조건화 한다
    - AND,OR
    - IN,NOT IN
      - OR을 그룹화해서 사용할 수 있따

### ORDER BY

- 특정 컬럼의 값으로 데이터 정렬에 사용되는 문법이다
  - ASC는 오름찬순 DESC는 내림차순을 뜻한다
  - 여러개의 정렬기준을 동시에 적용할 수있다
    - ex ) countrycode로 먼저 정렬하고 countrycode가 같으면 population으로 정렬하는 방식

- LIMIT
  - LIMIT은 조회하는 데이터의 수를 제한할 수 있다
    - LIMIT n은 위에서 부터 n개의 데이터를 출력한다
    - LIMIT n,m은 위에서 부터 n개의 데이터를 자르고 m개의 데이터를 출력한다

### GROUP BY, HAVING

- GROUP BY 
  - 여러개의 동일한 데이터를 가지는 특정 칼럼을 합쳐주는 역할을 하는 명령어이다
  - 그룹함수
    - COUNT: 개수를 세어서 출력해주는 함수
    - MAX: 최대값을 출력해주는 함수
    - MIN: 최소값을 출력해주는 함수
    - AVG: 평균값을 출력해주는 함수
    - VAR_SAMP: 표본 분산을 출력해주는 함수
    - STDDEV: 표준 편차를 출력해주는 함수
  - HAVING
    - GROPU BY 에서 반환되는 결과에 조건을 줄 수 있다

### CREATE USE ALTER DROP

- CREATE

  - CREATE DATABASE : DB 생성

  - CREATE TABLE : TABLE 생성

    - 테이블 생성 예시

      CRETAE TABLE <table name>(

       colmun_name_1 column_data_type_1 colmn_constrain_1,

       colmun_name_1 column_data_type_1 colmn_constrain_1,

      ...			

      )

- USE: 데이터 베이스 사용

- ALTER

  - DB 인코딩 설정 변경
    - ALTER DATABASE test2 CHARACTER SET = utf8;
    - SHOW VARIABLES LIKE "character_set_database"
  - Table
    - ALTER TABLE <table name> ADD column name column_data_type column_constarin
    - ALTER TABLE <table name> MODIFY COLUMN column name column_data_type column_constarin
    - ALTER TABLE <table name> drop column name 

- DROP

  - DROP DATABASE <databse name>
  - DROP TABLE <table name>

### DATA TYPE

데이터 베이스의 테이블을 생성할 때 각 컬럼(열)은 데이터 타입을 가진다

참고자료 :https://dev.mysql.com/doc/refman/5.7/en/data-types.html

- Numberic
  - 정수 타입 (Integer)

    | TYPE      | Storage(Bytes) | Range                    |
    | --------- | -------------- | ------------------------ |
    | TYNIINT   | 1              | -128 ~ 127               |
    | SMALLINT  | 2              | -32768 ~ 32767           |
    | MEDIUMINT | 3              | -8388608 ~ 8388607       |
    | INT       | 4              | -2147483648 ~ 2147483647 |
    | BIGINT    | 8              | -2^63 ~ 2^63-1           |

  - 실수 타입(floating-point types)

    - FLOAT(4bytes), DOUBLE(8bytes)가 있다
    - 고정 소수점 타입으로도 사용이 가능하다

- Date & Time
  - DATE: 날짜를 저장하는 데이터 타입, 기본 포멧은 ""년-월-일"" 이다
  - DATETIME: 날짜와 시간을 저장하는 데이터 타입, 기본포멧은 "년-월-일 시:분:초"이다
  - TIMESTAMP: 날자와 시간을 저장하는 데이터 타입이며, 날짜를 입력하지 않으면 현재 날짜와 시간을 자동으로 저장할 수 있는 특징이 있다
    - Java에도 이것 활용할 수 있는 class가 존재한다
    - https://docs.oracle.com/javase/8/docs/api/java/sql/Timestamp.html
  - TIME: TIME은 시간을 저장하는 데이터 타입, 기본 포멧은 "시:분:초"
  - YEAR: 연도를 저장할 수 있는 데이터 타입, YEAR(2)는 2자리의 연도를 저장하며 YEAR(4)는 4자리의 연도를 저장할수 있다

- String
  - CHAR & VARCHAR
    - 짧은 문자열을 저장하는 데이어타입에는 CHAR와 VARCHAR가 있다
    - CHAR는 고정형으로 입력값과 상관없이 자료형을 만들 때 입력한 길이만큼의 byte를 사용한다
      - ex) CHAR(4)는 입력값과 상관없이 항상 4bytes만 사용한다
    - VARCHAR는 가변형으로 입력값의 길이에 +1 byte를 한 만큼 사용한다
      - ex)VARCHAR(4)에 1글자를 입력하면 2bytes사용하고 4글자 입력하면 5bytes를 사용한다
    - 데이터의 특징에 따라 어떤것을 사용하는 것이 좋을지 판단하여 사용하면 된다
    - https://stackoverflow.com/questions/3887735/mysql-difference-between-char-and-varchar#:~:text=A%20CHAR%20field%20is%20a,on%20the%20specific%20string%20stored.
  - TEXT
    - 크기가 큰 문자열을 저장할 때 사용하는 데이터 타입
    
      | TYPE       | Maximum length      |
      | ---------- | ------------------- |
      | TINYTEXT   | 255 bytes           |
      | TEXT       | 65,535 bytes        |
      | MEDIUMTEXT | 16,777,215 bytes    |
      | LONGTEXT   | 4,294,967,295 bytes |
    
    

### Constraint : 제약조건

- 데이터 베이스의 테이블을 생성할 때 각 컬럼은 각각의 제약조건을 갖는다
  - NOT NULL 
    - NULL 값(비어있는 값)을 저장할 수 없다
  - UNIQUE
    - 같은 값(value)을 저장할 수 없습니다.
    - 여러개의 컬럼에서 제약조건으로 사용될 수 있다
  - PRIMARY KEY
    - NOT NULL과 UNIQUE의 제약조건을 동시에 만족해야 한다.
    - 하나의 테이블에 하나의 컬럼만 PRIMAR KEY로 설정할 수 있다
    - table에 index로 사용된다
  - FOREIGN KEY
    - 두개의 테이블을 하나의 특정한 컬럼을 통해서 연결하는 역할을 한다. 
    - 하나의 컬럼은 PRMIARY KEY여야 하고 참조된 컬럼은 FOREIGN KEY라고 한다
    - 다른 테이블과 연결되는 값이 저장된다
  - DEFAULT
    - 값이 입력되지 않을 경우 DEFAULT로 지정된 값을 입력해 준다
  - AUTO_INCREMENT
    - 주로 테이블의 PRIMARY KEY 데이터를 저장할 때 자동으로 숫자를 1씩 증가시켜 주는 기능으로 사용한다
  - CHECK
    - 
  - https://www.w3resource.com/mysql/creating-table-advance/constraint.php



### INSERT



### UPDATE SET



### DELETE TRUNCATE



### Funcions 1(CONCAT, CEIL, ROUND, TRUNCATE, DATE_FROMAT)



### Functions2(IF, INNULL, CASE)



### JOIN



### UNION



### Sub Query



### VIEW



### INDEX



### TRIGGER



