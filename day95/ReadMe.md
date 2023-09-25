## 오후 1:33 2023-09-25

DAO를 업그레이드한 경험

JAVA JDBC
Template
MyBatis

DAO 버전3
# [MyBatis 프레임워크]
프레임워크이기 때문에 A to Z 정해져 있음
이와 달리 템플릿은 불러와서 쓰는것
개발자는 프레임워크를 쓰기 위해 요청하는대로 써야함
정해진 구조대로 개발을 해나가야 한다!

.xml 파일(==mapper)이 필요 == 설정과 관련된 파일 == mapper

왜 쓰는가???
SQL이 JAVA 내무에 존재 ▶ SQL를 .xml 파일로, JAVA 외부로 별도 관리
			== SQL 구문을 바꿔야 함에도 컴파일을 해야했으나 지금은 아님
			== 결합도가 낮아짐(컴파일 별도 필요 XXX)
			== 응집도가 높아짐(SQL 보려고 자바 파일 안봐도 됨 ---> SQL만 모아놔서)
						

src/mybatis.mapper
설정파일의 이름은 자유

xml은 보통 주석 안달음

/////설명 시작

1~4라인 스키마
스키마
	정해진대로 씀
	이 xml 파일에 대한 규칙이 있음
	.xml은 환경설정 파일
	어떤 환경에 어떻게 적용될지에 대한 사전 약속
	
	이미 존재하는

6, 17라인
루트 엘리먼트(요소, 태그)
	<mapper>
	namespace 설정
	내가 누구를 implement 하는지
	내가 누구를 본따서 가져오고 구현하고 있는지
	어떤 클래스(인터페이스)를 구현하고 있는지에 대한 속성
	주의해야할 점은 Interface로 가져오고 있다는 점
	@Mapper를 어떤 인터페이스에 작성

내부 엘리먼트(요소, 태그)
	일반적으로 5개(CRRUD)
	<select>
	<insert>
	<update>
	<delete>
	SQL 쿼리문은 대문자로 작성 → 가독성 때문!

	id는 동일할 경우 구분 못할까봐
	mapper에 존재하는 메서드 명

	resultType 속성은 반환타입을 의미함: class Map 만들었던 것 걔 역할
	
	값 전달 방식
	1. #{param1},#{param2},#{param3},... ---> 누가봐도 ~~네 할때
	2. #{BID}: 이름 지정 방식 --> 너무 많아서 복잡
	3. map 컬렉션을 통한 방식 1.방식의 심화 ---> 인자가 늘어나는 것을 방지할 수 있다
	---> 어떤 방식을 사용하는지 중요

	

	
	

※ 능단평 내용은 CRRUD (기존에 제출한것)
	MyBatis 적용하기 ※


구현체인 DAO는 이제 필요없음
@Repo
@Overwrite 등등 다 필요없음






//////진행순서 다시
1. starter project Mybatis 추가
2. application.propertis에 설정 추가
3. mapper 패키지 및 .xml 파일들 생성
	보통 DAO 개수만큼 생성
4. DAO(인터페이스)에 @Mapper 설정
5. 메서드 연결

ibatis
Mybatis의 예전 회사 이름
오라클이 세상을 지배한다...
옛날사람....저런저런.....
