package com.jhyun.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;

@Controller
public class CTRL {

	@RequestMapping("/")
	public String root() {
		return "test";
	}

	// 기존 방식
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(VO vo, Model model) {
		/////
		if (vo.getId() == null || vo.getId().equals("") || vo.getId().isEmpty() || vo.getId().isBlank()) {

		}

		if (vo.getPassword().length() <= 5) {

		}
		/////

		model.addAttribute("apple", vo.getId());
		return "test";
	}

//	@RequestMapping(value="/test", method = RequestMethod.POST)
//	public String test2(VO vo, BindingResult br, Model model){
//		/////
//		VOValidator voV = new VOValidator();
//		voV.validate(vo, br); // br는 커맨드객체(참조변수)
//		if(br.hasErrors()) {
//			System.out.println("로그: 에러발생함!");
//			System.out.println(br.getAllErrors());
//			
//			if(br.getFieldError("id") != null) {// id에서 Error가 발생했다는 의미
//				System.out.println(br.getFieldError("id").getCode());
//			}
//			System.out.println(br.getAllErrors());
//		}
//		/////
//		
//		model.addAttribute("apple", vo.getId());
//		return "test";
//	}
	

//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	public String test2(@Valid VO vo, BindingResult br, Model model) {
//
//		/* **/
//		if (br.hasErrors()) {
//			System.out.println("로그: 에러발생함!");
//			System.out.println(br.getAllErrors());
//
//			if (br.getFieldError("id") != null) {// id에서 Error가 발생했다는 의미
//				System.out.println(br.getFieldError("id").getCode());
//			}
//		}
//		/* **/
//
//		model.addAttribute("apple", vo.getId());
//		return "test";
//		 
//	}
//	@InitBinder
//	protected void initBinder(WebDataBinder wdb) {
//		wdb.setValidator(new VOValidator());
//	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test2(@Valid VO vo, BindingResult br, Model model) {

		/* **/
		if (br.hasErrors()) {
			System.out.println("로그: 에러발생함!");
			System.out.println(br.getAllErrors());

			if (br.getFieldError("id") != null) {// id에서 Error가 발생했다는 의미
				System.out.println(br.getFieldError("id").getDefaultMessage());
			}
		}
		/* **/

		model.addAttribute("apple", vo.getId());
		return "test";
		 
	}

}
