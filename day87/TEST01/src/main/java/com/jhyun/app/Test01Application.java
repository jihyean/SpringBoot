package com.jhyun.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.Config;
import test.Member;

///////@SpringBootApplication
public class Test01Application {

	public static void main(String[] args) {
		//////SpringApplication.run(Test01Application.class, args); 내일 할것(웹어플리케이션 사용할때)
		
		
		// 1. 스프링 IoC 컨테이너 구동시키기
		// 1-2. 컨테이너를 구동시킬때에 설정 파일이 필요함
		// (스프링에서는 .xml / 부트에서는 .java)
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		// ac 컨테이너는 팩토리 패턴을 기반으로 동작하고 있음!
		
		
		Member member1 = (Member)ac.getBean("member1");
		member1.print();
		
		Member member2 = ac.getBean("apple", Member.class);
		member2.print();	
		
		// 2. 싱글톤 유지되는지 확인
		if(member1 == member2) {
			System.out.println("둘은 동일한 객체입니다");
		}
		else {
			System.out.println("둘은 다른 객체입니다");
		}
		// 부트 방식을 활용하지 않음
		// 개발자가 member 객체를 2개를 등록 -> 싱글톤 유지 XX
		
	}

}
