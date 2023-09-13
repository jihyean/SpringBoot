package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정 클래스
// Configuration : 프로그램의 설정을 저장해두고 환경을 구성하는데에 사용하는 파일
@Configuration
public class Config {

	@Bean //스프링이 IoC 컨테이너로 관리하는 객체
	public PhoneA phoneA() {
		return new PhoneA();
	}
	
	@Bean
	public PhoneB phoneB() {
		return new PhoneB();
	}
	
	@Bean //이름 설정을 별도로 하지 않으면 << member1 메서드명이 등록됨
	public Member member1() {
		// 생성자 주입 방식
		return new Member("작은티모", new PhoneA());
	}
	
	@Bean(name= "apple")
	public Member member2() {
		// setter 주입 방식
		Member member = new Member();
		member.setName("큰 티모");
		member.setPhone(new PhoneA());
		return member;
	}
}
