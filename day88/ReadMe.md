오후 1:04 2023-09-14

웹
	정적 리소스
		HTML CSS JS 이미지 파일
	동적 리소스
		JSP Servlet

롬복(Lombok)
	https://projectlombok.org/download
	자바 클래스에서 VO getter setter toString equals 등의 메서드를 자동으로 생성해줌
		VO == DTO(Data Transfer Object) ★★★★
	
	
항상 해야함

뷰를 콘솔로 하지않고 JSP 로 할 것이기 때문에 VR이 필요함
뷰를 웹 브라우저로 삼을 것이기 때문

spring.mvc.view.prefix=/WEB-INF/views/
꼭 보여줘야 하는 데이터가 있는 경우


스프링 기본 설정
	1. application.propertoes
		서버 포트 설정
		JSP VR 설정
	2. JSP 폴더 경로 설정
	3. build.gradle
		JSP 컴파일 라이브러리
		JSTL 라이브러리
		-> 새로고침★(Maven과 달리)


커맨드객체 ★★★★
ResponseBody ★★★★

C -> V
	일반적으론
	model 객체를 활용해서 데이터를 전달
	그런데
	커맨드객체가 사용 가능하기 때문에
	커맨드객체명.xxx로 사용 가능함
	커맨드 객체명을 V가 알고있어야 사용가능하기 때문에
	@ModelAttribute을 통해 이름을 지정할 수 있음

	★자바에서는 파라미터로 사용하는 변수는 보통 "지역변수"
	지역변수는 메서드가 종료되는 사라지지 않냐?
	메서드 종료되었는데 어떻게 뷰에서 사용할 수 있어요???
	=> 일반 "지역변수" (특히 int String)는 메서드 종료시 소멸
	=> 지금 사용하는 커맨드변수는 지역변수가 아님
	=> 커맨드 변수는 지역변수
	=> 컨테이너가 new 해준 IoC 객체 == 커맨드 객체
		컨테이너 메모리에 저장된 객체
		"참조변수" call by reference ★
		OOP (특히 자바)에서 좋아하는 기법
		return 2개 이상이 불가능하기 때문에 발달한 기법
		

★ 커맨드 객체를 어떻게 V에서 사용할 수 있나요?
★ 컨테이너가 IoC 해준(개발자 대신 new 해준) 객체라서
	참조변수 입니다
	OOP인 JAVA에서 좋아하는 기법입니다

