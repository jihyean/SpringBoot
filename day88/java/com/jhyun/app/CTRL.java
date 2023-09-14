package com.jhyun.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CTRL {
	
	@RequestMapping("/") //루트 요청
	public @ResponseBody String root() {
		return "루트요청";
		// VR ㄴㄴ
		// 문자열 값
	}
	
	@RequestMapping("/test") //루트 요청
	public String test(VO vo, Model model) {
						//커맨드객체
		System.out.println("vo: "+vo);
		model.addAttribute("apple",vo.getId());	
		
		return "test";
		// WEB-INF/views/test.jsp
	}
	
	@RequestMapping("/test2")
	public String test(@ModelAttribute("ari")VO vo) {
		//커맨드객체
		System.out.println("vo: "+vo);
		
		return "test2";
		// WEB-INF/views/test2.jsp
	}
	
	@RequestMapping("/test01") //루트 요청
	public String test01(HttpServletRequest request, Model model) {

		VO vo = new VO();
		vo.setId(request.getParameter("id"));
		System.out.println("test01 vo: "+vo);
		
		// model.addAttribute("apple",request.getParameter("id"));	
		model.addAttribute("apple",vo.getId());	
		
		return "test";
	} // request 자체가 not POJO인 Servlet 객체이기 때문에 활용도가 낮다
	
	@RequestMapping("/test02")
	public String test02(@RequestParam("id")String id, @RequestParam("name")String name, Model model) {
		model.addAttribute("apple", id);
		
		return "test";
	} // 가독성이 커맨드 객체를 사용할때보다 별로 //뷰랑 모델이 아무 생각 없어도 괜찮음
	
	@RequestMapping("/test03/{id}/{name}") // 모든 값을 파라미터로 전달하는 방식 REST API(모바일에 따른 추세)
	public String test03(@PathVariable String id, @PathVariable String name, Model model) {
		model.addAttribute("apple", id);
		return "test";
	} // URL(PATH == 경로)에 데이터를 바로 보내는 방법
	
	


}
