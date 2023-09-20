package com.jhyun.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController { // 비슷한 로직끼리 같은 파일에서 관리하기때문에 응집도가 높아짐
	
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	BoardDAO boardDAO;

	@RequestMapping(value = "/login")
	public String login(MemberDTO mDTO, BoardDTO bDTO, Model model, HttpSession session) {

		mDTO.setMSearch("로그인");
		mDTO = memberDAO.selectOne(mDTO);
		if (mDTO != null) {
			session.setAttribute("member", mDTO.getMid());
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/logout")
	public String logout(BoardDTO bDTO, Model model, HttpSession session) {
		session.removeAttribute("member");

		return "redirect:/";
	}

	@RequestMapping(value = "/check")
	public String checkPage(MemberDTO mDTO, Model model, HttpSession session) {
		//return "mypage";
		mDTO.setMid((String) session.getAttribute("member"));
		System.out.println("mid: "+mDTO.getMid());
		mDTO.setMSearch("존재확인");
		mDTO = memberDAO.selectOne(mDTO);
		System.out.println("mDTO: "+mDTO);
		if (mDTO == null) {
			return "redirect:/"; // 이거 어캄
		} else {
			model.addAttribute("data", mDTO);
			return "mypage";
		}
	}

	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(MemberDTO mDTO) {	
		mDTO.setMSearch("존재확인");
		if(memberDAO.selectOne(mDTO)==null) {
			memberDAO.insert(mDTO);
		}
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/updateMember")
	public String updateMember(MemberDTO mVO, HttpSession session) {		
		if(memberDAO.update(mVO)){
			//session.removeAttribute("member");
			return "redirect:/logout";
		}
		else {
			return "redirect:/mypage"; /////
		}
	}
	
	@RequestMapping(value="/deleteMember")
	public String deleteMember(MemberDTO mDTO, BoardDTO bDTO,HttpSession session) {
		
		bDTO.setMid((String)session.getAttribute("member"));
		bDTO.setSearch("회원탈퇴");
		boardDAO.update(bDTO);
		
		if(memberDAO.delete(mDTO)){
			session.removeAttribute("member");
			return "redirect:/";
		}
		else {
			return "redirect:/mypage"; 
		}
	}

}