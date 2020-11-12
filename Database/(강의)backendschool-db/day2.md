# 데이터베이스 모델링

## 개념

- 데이터 베이스 모델링은 데이터 베이스에서의 테이블 구조를 미리 계획해서 작성하는 것
- RDBMS는 테이블간에유기적으로 연결되어 있기 때문에 모델링을 잘하는 것이 중요하다

- 절차

  - 개념적 모델링 : 업무분석해서 핵심 데이터의 집합을 정의하는 과정
    - 일단 업무를 알고 같은 데이터끼리 묶어주면된다
      - 고객에대한 집합, 상품에대 한집합을 나눈것이 개념접 모델링
  - 논리적 모델링 : 개념적 모델링을 상세화 하는 과정
    - 고객정보 어떤 정보들어가는지, 고객정보와 상품정보 사이에 구매정보는 어떤 정보들어가는지, 상품정보는어떤정보가 들어가는지
      - 관계 선을 통해 표현한다(배우는것 아래에 있음)
      - 고객이 있는데 구매정보를 여러개 가질 수 있으면 1:N의 관계가 된다
        - 만약에 비회원이면 0:N의 관계까지 생각해야한다
  - 물리적 모델링 : 논리적 모델링이 구체화되서 데이터베이스의 들어갈 수 있는 형태로 만드는 것
    - 논리적인 모델링은 요소들만 리스트했지만 요소들의 데이터 타입과 key값들을 설정해서 관계를 어떻게 설정할지까지 구상하게 된다
  - 이런 과정을 안거치고 db만드는 회사도 많지만 만들고 하는게 더좋기 때문에 배워서 가서 만들면 된다

  

## 실습

- MySQL Workbrench를 통해 간단한 모델링을 해보고 결과를 데이터베이스로 만들어 보았다
- Database-forwardEngeneering
  - 반대로 이미 있는 데이터베이스를 다이그램화하는 것도 실습을 하였다
  - Database - reverseEngeneering
- 선택할 수 있는 엔진에 대한 설명
  - myisam은 셀렉트가빠르고 dtaype이 텍스트 (256자) 를 index로 사용할 수 있다
    - table단위로 락을 건다. 
  - Innodb는 셀렉트가 느리지만 락을 열단위로 걸기때문에 다른사람이 해당 테이블에 접근해서 쿼리문을 사용할 수 있다
    - 요즘은 InnoDB를 많이 사용한다



## SQL 종류

### SQL 문의 종류(쿼리문의 종류)

- DML(Data Manipualtion Language)
  
  - 가장 많이 사용하는 쿼리문
  - 데이터 조작어
    - 데이터 검색, 삽입 수정, 삭제등에 사용된다 (이를 CRUD라고 한다)
    - SELECT, INSERT, UPDATE, DELETE
  - 트랜젝션이 발생하는 SQL문
    - 트랙잭션 예)
    - ATM에서 하나의 계좌가 있다
    - ATM 1 800원인출  ATM 2 600원 인출하는상황
      - 800 <account / ok / a =800 , 600 <account /ok /b = 600
    - -400원이 되는데 이러면안되니까 트랙젝션이란개념삼는다
      - 그래서 위에 3개의 절차를 하나의 절차로 묶는다 -> 그래야 하나의절차 끝나고 다음절차로 이어질 수 있기 때문에\
      - 하나하나 끊어서 작성한게 하나의 트랜잭션이 되는걸까?
  
- DDL(Data Definition Language)
  - 데이터 정의어
    - 데이터 베이스, 테이블, 뷰, 인덱스등의 데이터 베이스 개체를 생성, 삭제, 변경에 사용
    - CREATE, DROP, ALTER, TRUNCATE
  - 실행 즉시 DB에 적용

- DCL(Data Control Language)
  - 데이터 제어어

    - 루트계정 외에 여러 계정을 등록할 수 있기 때문에 사용하는 쿼리문
    - 사용자의 권한을 부여하거나 빼앗을 때 사용
    - GRUNT, REVORKE, DENY

    

### 실습

- 예약어는 대문자를 사용한다(소문자도 사용은가능하지만 권장하지 않는다)

- Select 는 컬럼을 선택 *는 모든 컬럼
- BETWEEN은 포함이다 이상이하, 초가 미만이아니라
- like는 %는 어떤문자가 앞에 올수 있다는 뜻 . %Republic이면 앞에 어떤 문자가올수 있게된다
  - 앞뒤로하면 앞뒤로 문자가 올수도 있는것이겠지
- #ORDER BY 소팅하는것
  - ASC는 어센딩에 약자 -> 생략가능하다
- #LIMIT 업데이트할때 일부만 바꿔서 적용해보고 실행하는 경우가 많다
  - 5,5 면 앞에 5개 생략하고 5개 출력한다
- AS를 통해 엘리어스를 할 수 있다.
  - ORDERBY도 그것을 통해  정렬할 수있다
- GROUP BY
  - 이름과 money가 있을 때

## 참고 : TMux

- 세션
- pc에 ssh:22포트를 통해 연결정보(SEssion) 이 연결되어 있다
  - 이상태에서 명령을 하면 서버가 반응을 한다
- 터미널 2에서 또 서버에 연결하면 세션2가 연결이 된다
- tmux는 세션을 관리해주는 도구이다
  - T1에서 연결하면 Session1이 생긴다
    - TMux를 이용해서 SessionA를 생성하고 연결한다
  - T2에서 연결하면 Session2이가 생긴다
    - Tmux를 이용해서 SessionA로 연결할 수 있다
  - 같은 세션을 쓴다는 것은 하나의 창에서 입력하면 다른창에서 입력을 할 수 있는 것이다
  - 페어프로그래밍할때 활용할 수 있다
    - 한창은 자기것 한창은 다른사람의 것을 연결해서 사용할 수 있다

### data type

- 컬럼별로 같은 데이터타입을 가진다
- 설명하는 것 외에도 많은 데이터 타입이 있다
- 숫자
  - 정수
    - TINYINT ~ BIGINT 까지 다양한 숫자표현 범위가 있다
    - 보통 INT를 많이 사용하고 큰숫자를 BIGINT로 사용한다
  - 실수
    - FLOAT과 DOUBLE이있다
- DATE & TIME
  - DATE : 날짜만 저장하는 포멧
  - DATETIME : 연월일 시분초
  - TIMESTAMP : 넣지않으면 현재시간 자동으로 저장
  - TIME : 시간을 저장하는 타임
- STRING
  - CHAR & VARCHAR
    -  CHAR :고정문자열, 무조건 4BYTE
      - 국가코드 같이 정해진 것은 CHAR이 좋을수 있다
    -  VARCHAR : 가변문자열, 문자+1BYTE
  - TEXT 
    -  255자 이상의 긴문자열을 나타낼 때 사용
    - 기사, 댓글등 을 저장할 때 사용할 수 있다

### 제약조건

- 데이터 베이스의 테이블을 생성할때 각컬럼은 각각의 제약조건을 갖습니다.
  
  - 이메일 열에 어떤값이 들어가야하는가
  
- NOT NULL
  
  - NULL 값을 넣을 수 없다
  
- UNIQUE
  - 같은 값을 저장할 수 없다
    - 이메일 같은 정보
  
- PRIMARY KEY
  - key는 join할때 더 배울 것
  - 유일한 값을 가지는 컬럼이된다, UUID와 같이 식별할 수 있게 사용하는 것 가다 
  - 하나의 테이블에 하나만 설정할수 있다
  
- FOREIGN KEY
  - 다른 테이블과 연결되는 값이 저장된다
  - join에 대한 개념이기도 하다
    - 두개의 테이블이 있을 때 첫번째 테이블에 name과 addr 가 있는 경우
    - 두번째 테이블에 name과 money가 있다고 가정
      - 두개의 테이블을 합쳐서 하나의 테이블로 만들고 싶다면 name을 기준으로 만들게 된다
      - 이때 2개의 값을 연결해주는 name을 'FOREIGN KEY'값이라고 한다.
  
- DEFAULT
  
  - 데이터를 저장할때 해당 커럼에 별도의 저장값이 없으면 DEFAULT로 설정된 값이 저장된다
  
- AUTO_INCREMENT
  
  - 주로 테이블의 PRIMARY KEY데이터를 저장할때 자동으로 숫자를 1씩 증가시켜 주는 기능으로 사용한다
  
-  제약조건을 잘설정해야 이상한데이터가 안들어간다

   



## 실습코드

```mysql
# SELECT FROM
# SELECT는 컬럼을 선택
SELECT code, name, population
FROM world.country; 

#사용할 DB를 선택
USE world; 
SELECT code, name, population
FROM country;

# WHERE : 비교연산, 논리연산
# 인구가 1억 이상인 국가 데이터 출력
SELECT code, name, population
FROM country
WHERE population >= 100000000;

# 인구가 2억 ~ 3억인 국가를 출력
SELECT code, name, population
FROM country
WHERE population >= 200000000 AND population <= 300000000;

# BETWEEN
SELECT code, name, population
FROM country
WHERE population BETWEEN 200000000 AND 300000000; 

# 아시아와 아프리카대륙의 국가 데이터 출력
SELECT code, name, continent, population
FROM country
WHERE (continent = "Asia" OR continent = "Africa")
AND population >= 100000000;

# IN = OR 조건문
SELECT code, name, continent, population
FROM country
WHERE continent IN ("Asia","Africa");

#NOT IN은 NOT OR
SELECT code, name, continent, population
FROM country
WHERE continent NOT IN ("Asia","Africa");

# LIKE : 특정 문자열이 포함된 데이터를 출력
# 정부형태가 Republic 인 국가를 출력
SELECT code, name, governmentform
FROM country
WHERE governmentform Like "%Republic%";
# &은 문자가 올수있다는 표시

# ORDER BY : 데이터 정렬
# 국가 데이터를 인구수 순으로 오름차순으로 정렬
SELECT code, name, population
FROM country
ORDER BY population ASC; #ASC는 오름차순 (생략가능)

# 내림차순
SELECT code, name, population
FROM country
ORDER BY population DESC;
#DESC는 내림차순

# 기준 컬럼을 여러개 설정 : 1번째 조건으로 소팅 > 같으면 2번째 조건으로 소팅
# city 테이블에서 국가 코드 순으로 정렬(오름차순)하고 국가 코드가 같으면 인구수(내림차순) 순으로 정렬
SELECT countrycode, name, population
FROM city
WHERE countrycode IN ("USA", "KOR", "JPN")
ORDER BY countrycode ASC, population DESC;

# LIMIT : 조회하는 데이터의 수를 제한
# 인구가 많은 상위 5개 도시를 출력
SELECT countrycode, name, population
from city
ORDER BY population DESC
LIMIT 5;


# LIMIT 5, 2 : 앞에 5개의 데이터를 스킵하고 뒤에 2개 데이터를 출력
SELECT countrycode, name, population
from city
ORDER BY population DESC
LIMIT 5,2; # 6위 7위 데이터가 출력
# 5개 자르고 2개 출력

SELECT 10 / 5;

# 한국(KOR)의 경기도(Kyonggi)에 해당하는 도시에서 
# 인구가 많은 3개의 도시를 출력
SELECT *
FROM city
WHERE countrycode = "KOR" AND district = "Kyonggi"
ORDER BY population DESC
LIMIT 3;

# 동북아시아에서 인당 GNP가 높은 5개 나라를 출력
SELECT code, name, gnp, Population
, (gnp/population) AS gnp_per_population
FROM country
WHERE region = "Eastern ASIA"
ORDER BY gnp_per_population DESC
LIMIT 5;

# 인구밀도가 높은 국가 6위에서 ~ 10위 까지 출력
SELECT code, name, population, surfacearea
		, (population/surfacearea) AS Density
FROM country
ORDER BY Density DESC
LIMIT 5,5;

# GROPU BY : 특정 칼럼의 동일한 데이터를 합쳐주는 방법
# 데이터를 합칠 때 다른 컬럼들에 대한 처리는 그룹함수를 이용합니다
# COUNT, MAX, MIN, AVG, VAR_SAMP(분산), STDDEV(표준편차)
# COUNT : city 테이블에서 국가별 도신의 갯수를 출력
SELECT countrycode, COUNT(countrycode)
FROM city
GROUP BY countrycode;

# MAX : 대륙별 인구수와 GNP의 최대값을 출력
SELECT continent, MAX(population), MAX(GNP)
FROM country
GROUP BY continent;

# SUM : 대륙별 전체 인구수와 전체 GNP, 인당 GNP를 출력
SELECT continent, SUM(population), SUM(GNP)
		, SUM(GNP) / SUM(population) AS gpp 
FROM country
GROUP BY continent;

# AVG : 대륙별 평균 인구수와 평균 GNP 인구순으로 내림차순 정렬
SELECT continent, AVG(population) as population
		, AVG(GNP) as gnp
FROM country
WHERE population != 0 AND gnp != 0 #as는 Where에서 원래 못쓴다
GROUP BY continent
ORDER BY AVG(population) DESC;

# HAVING : GROUP BY 로 출력되는 결과를 필터링할때 사용
# 대률별 전체 인구수를 출력하고 대륙별 2억 이상이 되는 대륙만 출력
SELECT continent, SUM(population) as sum_population
FROM country
#WHERE sum_population >= 20000 #Group by에 결과를 필터링할 수 없음
GROUP BY continent
HAVING sum_population >= 500000000;

# 1. 언어별 사용하는 국가의 수를 조회 많이 사용되는 언어 6위 ~ 8위 출력
SELECT language, COUNT(language) as count
FROM countrylanguage
GROUP BY language
ORDER BY count DESC
LIMIT 5,3;

# 2. 대륙별 나라의 갯수를 출력하고 국가 많은 대륙 1위 ~ 3위 까지 출력
SELECT continent, count(continent) as count
FROM country
GROUP BY continent
ORDER BY count DESC
LIMIT 3;

# 3. CITY 테이블에서 국가코드별 총인구를 출력, 총인구순으로 내림차순 정렬
# 총 인구가 5천만 이상인 국가코드만 출력 하세요.
SELECT countrycode,  SUM(population) as total_population
FROM city
GROUP BY countrycode
HAVING total_population >= 50000000
ORDER BY total_population DESC;

USE jds;
SELECT DATABASE(); # 현재사용하고 있는 데이터 출력이 된다

CREATE TABLE user1(
	user_id INT, #컬럼명 데이터타입, 제약조건
    name VARCHAR(20),
    email VARCHAR(30),
    age INT(3),
    rdate DATE
);

show tables;
desc user1;

CREATE TABLE user2(
	user_id INT PRIMARY KEY AUTO_INCREMENT, #2개는 띄어쓰기로 구분
    name VARCHAR(20) NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL, #UNIQUE뒤에는 NOTNULL해주어야된다안하면 NUll도 하나의 데이터로 포함시킨다
    age INT(3) DEFAULT 30,
    rdate TIMESTAMP
);

show tables;
DESC user2;

# INSERT : 데이터 추가
INSERT INTO user1(user_id, name, email, age, rdate)
VALUES(1, "andy", "andy@gamil.com", 23, now());

INSERT INTO user1(user_id, name, email, age, rdate)
VALUES(2, "jin", "andy@gamil.com", 23, now()),
(3, "peter", "andy@gamil.com", 23, now()),
(4, "jhon", "andy@gamil.com", 23, now());

SELECT * FROM user1;

INSERT INTO user2(name, email)
VALUES("andy", "andy@gamil.com");

INSERT INTO user2(name, email)
VALUES("jin", "andy2@gamil.com"),
("peter", "andy3@gamil.com"),
("tom", "andy4@gamil.com");

SELECT * FROM user2;

DESC user2; #Description table -> 테이블 설명, 위치에 따라 다른역할한다

# SELECT 문을 실행한 결과를 INSERT
USE world;

CREATE TABLE city2 (
	Name VARCHAR(50),
    CountryCode CHAR(3),
    Population INT
);

SELECT Name, CountryCode, Population
FROM city
WHERE Population >= 8000000;

INSERT INTO city2
SELECT Name, CountryCode, Population
FROM city
WHERE Population >= 8000000;

SELECT * from city2;

DROP TABLE city2; # 삭제

show tables;
DROP TABLE user1;
show tables;
```

