package com.jhyun.app;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class VOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 유효성 검사할 객체의 클래스 정보를 반환
		return VO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { // Erros errors 또한 커맨드객체, 참조 변수

		VO vo = (VO)target;
		String id = vo.getId();
		String password = vo.getPassword();
		
		if(id == null || id.isEmpty() || id.isBlank() || id.trim().isEmpty() || id.trim().isBlank()) {
	         System.out.println("로그: id값이 올바르지 않습니다");
	         errors.rejectValue("id", "id값 없음");
		}
		if(id.length() <= 5) {
			System.out.println("로그: id값이 올바르지 않습니다(id값 5글자 이하)");
			errors.rejectValue("id", "id값 5글자 이하");
		}
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, password, "id값 없음");
		if(password == null || password.isEmpty() || password.isBlank() || password.trim().isEmpty() || password.trim().isBlank()) {
	         System.out.println("로그: password값이 올바르지 않습니다");
	         errors.rejectValue("password", "password값 없음");
		}
	
	}
}
