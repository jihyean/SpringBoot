# 오후 1:28 2023-09-21
오늘
마이바티스
트랜잭션

## 서비스 레이어

Spring 

MVC

FromtController
-> DAO(M) 직접
=> 결합도가 높다

그래서 그 사이에
서비스 레이어를 끼우게 되는 것

Service가 DAO를 활용
 Service 메서드() {
	aDAO.insert();
	// 현금 결제
	bDAO.update();
	// 아이템 구입
} // 1개의 행동
	== 1트랜잭션
수강신청 API 중에서
	신청대기 Service 만들어주세요
===> Web 중에서 종사자가 가장 많은 파트

메서드 시그니처를 강제할 수 있기 떄문에
실수할 확률이 줄어들고
반드시 구현하는 메서드들을 빼놓지 않고 구현할 수 있음

다형성 실현하기에 == 오버라이딩 하기에 좋다

추상메서드는 구현받는 애가 반드시 오버라이딩 해야됨
---> 오버라읻ㅇ 강제
혹은 받는 애도 추상메서드

Interface
	메서드 강제-> 실수 적어짐
	오버라이딩이 자유로워짐(다형성 실현에 용이)

Service가 Interface를 멤버변수(의존관계)로 갖고 있으면
	@만 어떤 클래스에 설정하는지에 따라
	다른 객체들을 주입받을 수 있다
	코드가 안바뀌네?
	== 결합도 낮아짐
	== 유지보수 용이


서비스는 DAO를 이용
근데 바로 쓰면 결합도 증가
어떠한 DAO도 올 수 있도록 InterfaceDAO를 사용
그럼 현재 @Repo 설정되어 있는 DAO가 넘어옴
근데 그걸 하는 Service가 C한테 사용되기 때문에 @Service

주입이 안되니까 에러나면서 실행이 안됨
2Layerd를 기본적으로 고려해줌
Interface 기반으로 그걸 찾아다님
※ 별도의 설정파일은 필요없으나, Interface 구조를 지켜야합니다!!! :D
