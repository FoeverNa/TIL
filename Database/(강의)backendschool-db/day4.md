#

## Agile 개발 방법론

• 과거의 소프트웨어의 개발 (1990년대)

​	 • 소프트웨어 개발은 계획 중심의 대규모 프로젝트가 많음 

​	그걸 개발할수 있는 사람은 진짜 고급입력이고 사용만 할줄알아도 먹고살수 있는 시대(개발자가 왕인시대)

• 현재의 소프트웨어의 개발 (2000년대) 

​	• 소프트웨어 사용자가 일반 대중으로 변화되면서 비지니스 사이클과 트 렌드가 빠르게 변경함 

• 소프트웨어 개발의 불확실성이 높아짐 -> 경량 방법론 주의자(lightweight  methodologies)들이 나타남 

• 경량방법론 주의자들에 의해 2001년도에 [애자일 개발 선언문] 발표

​	오래됬는데 최근에 많이 사용된다

![img](https://lh5.googleusercontent.com/FKn3DzuulfRVlNmp_ngmEC9QK7mnpkJkMULmyQqihuFL8OTrsnr1CoK24ooguKvnkl2V9Kjsxcv0DJdMmKrkniRu586xIcFAX3Q_cig6QlByHAErDljPTpaZlmYZzB17iyu57xUu)

![img](https://lh3.googleusercontent.com/2QJQK9rOu9cVeObGZqW3KaJw561QFUtxN-RXFfxGRsUVYhQbh3E3Ka-dbJJwVUlTgSUd-VlYfTfBiEoYpW8b7CpE8burGBp6CiwsguQPq-CGIQ2X7jbKF7ycxORkufR6udI7kAq7)

애자일의 핵심 가치 요약 

• 협력

 	• 개발과정에서 얻은 좋은 통찰을 공유

 	• 개발과정에서 발생하는 문제나 실수는 함께 해결

​	또불변 법칙에 의해 쉽지 않다.. 

​	그래서 협력에 관한 마인드가 이미 팀에 있는곳에 가야된다

 • 피드백

​	 • 개발의 불확실성을 극복하기 위한 가장 좋은 능력은 학습 능력

​	• 많은 사람에게 자주 피드백을 받아 문제해결을 위한 학습을 빠르게(피드백을 받아서 빠르게 고치는게 빠르게 배울수있는 지름길) 

​	명령 클릭하면 안될거 같아요 하는사람과 몰라서 못할거같아요 하는 사람은 이쪽분야에서 발전못한다

​	개발 20 디버깅 80, 문제해결시간이 오래걸리는게 당연한 거다, 학습을 통해 두시간이 균형을 이루게 된다

​	코드리뷰하는 회사 , 강사님이 중요하게 생각하는 요소

​	이쪽 분야에 전문가는 빠르게 배워서 서비스에  녹여낼수있는사람

• 위에 설명한 협력과 피드백을 빠르게 잘 하는것이 핵심가치



애자일 개발 방법론의 종류 

![img](https://lh6.googleusercontent.com/dp5-W8RbeZETOhwyXo0YfXoUnnPY5YwogLGrKCNMYH22iSdvAJimDNFJXdJ2NYctZnq2ThWWBWvTAz_7xwMio7m1cYtvNtjkcu8nc-bzz7NKNkWNGUx9ATPUHMHcoMV3ifV_1kI5)

• 스크럼(Scrum) 

- 스프린트 기반

   • 플래닝 회의를 통해 개발 기간 산정

기간을 정해놓고 무조건 결과를 만들어 내놓기 (책임)

집중할 수 있는게 장점

큰회사에서 많이쓰임

  • 칸반(Kanban)

​	 • WIP(Work in Process) 기반 

​	• 기간이 정해져 있지 않고 순서를 정해서 처리(자율성)

​	사람을 신뢰하는 방식

​	작은회사에서 많이 쓰인다

실제로는 스크럼과 칸반 모두 사용된다

 • XP(Extreme Programming) 

​	• 프로토타입을 빠르게 개발하고 클라이언트와 접촉을 자주(1~2주)하여 요구사항을 빠르게 반영

 	• 테스트 기반의 프로젝트



스크럼 : Scrum

![img](https://lh6.googleusercontent.com/3NC8zt85ArzM7j2vcLZo9maGhAbkjEqejb9JFYqbdRcHeAYa6tIy09G87yGXmomY0Tt-IJ7NyTPE_bJnUjurssSlgcXjI90bVYuvcGcxPjEcNN4GSp5xsR-FcPXi7-UvmBWCSyUn)

임무를 주고 스프린트 기간 동안 달리고 끝나면 다시 임무받고 스프린트동안 달리고



칸반 : Kanban

![img](https://lh3.googleusercontent.com/SNkHtd3gv14x_KjA4JUhIibq9Ttc7mqF76a2BlYBamDOK9rwh-pqclenkydorztvmIAWAHt9Xaw7DXigxzu6rDyam2n9-zLrCxmWKIy4Q7utuSZkmXKLBYWBl_1P51J0p_bU1YJw)

프로세스 단위로 개발, wating에서 working을 들어올 수 있다



스크럼과 칸반의 차이 

• 스크럼 

• 개발 호흡을 길게 가져감

 • 비교적 긴시간 방해받지 않고 개발에 집중

 • 1~4주 정도되는 스플린트를 기반으로 개발 시간 산정

 • 칸반

 • 개발 호흡을 짧게 가져감

 • HotFix 발생시 바로 바로 수정할수 있음 

• 데일리로 어제한 일과 오늘할 일을 공유

​	스크럼에서도 하지만 칸반에서는 프로젝트 오너와도 많이 대화를 한다(작은회사의 장점)





scp 라는 명령어를 써줘야하는것

database query를 실행시켜줘야되는것 그래서 mysql에서 emplyess 에 .sql파일 실행시켜준것