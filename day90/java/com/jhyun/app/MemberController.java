package com.jhyun.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;


public class MemberController { // 비슷한 로직끼리 같은 파일에서 관리하기때문에 응집도가 높아짐
	
	@Autowired
	MemberDAO memberDAO;
	
//	@RequestMapping(value="/check.do")
//	public String checkPage() {		
//		return "redirect:check.jsp";	
//	}
//	
//	@RequestMapping(value="/mypage.do")
//	public String mypage(MemberDTO mVO, Model model) {		
//		mVO=memberDAO.selectOne(mVO);
//		if(mVO==null){
//			return "redirect:check.do";
//		}
//		else {
//			model.addAttribute("data", mVO);
//			return "mypage.jsp";
//		}		
//	}
	
//	@RequestMapping(value="/signUp.do", method=RequestMethod.GET)
//	public String signUpPage() {		
//		return "redirect:signUp.jsp";	
//	}
//	
//	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
//	public String signUp(MemberDTO mVO) {		
//		if(memberDAO.insert(mVO)){
//			return "redirect:main.do";
//		}
//		else {
//			return "redirect:signUp.jsp";
//		}		
//	}
	
//	@RequestMapping(value="/login.do")
//	public String login(MemberDTO mVO, HttpSession session) {
//		if(mVO.getMid().equals("티모")) {
//			throw new ArithmeticException("에러발생!");
//		}
//		
//		mVO=memberDAO.selectOne(mVO);
//		if(mVO!=null){
//			session.setAttribute("member", mVO.getMid());
//		}
//		
//		return "redirect:main.do";
//	}
	
//	@RequestMapping(value="/logout.do")
//	public String logout(HttpSession session){		
//		session.removeAttribute("member");
//		
//		return "redirect:main.do";
//	}
	
//	@RequestMapping(value="/updateMember.do")
//	public String updateMember(MemberDTO mVO, HttpSession session) {		
//		if(memberDAO.update(mVO)){
//			session.removeAttribute("member");
//			return "redirect:main.do";
//		}
//		else {
//			return "redirect:mypage.do"; /////
//		}
//	}
//	
//	@RequestMapping(value="/deleteMember.do")
//	public String deleteMember(MemberDTO mVO, HttpSession session) {
//		if(memberDAO.delete(mVO)){
//			session.removeAttribute("member");
//			return "redirect:main.do";
//		}
//		else {
//			return "redirect:mypage.do"; /////
//		}
//	}

}