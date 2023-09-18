package com.jhyun.app;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class CTRL {

	@Autowired
	MemberDAO memberDAO;
	@Autowired
	BoardDAO boardDAO;

	@RequestMapping("/")
	public String root(MemberDTO mDTO, BoardDTO bDTO, Model model) {

		model.addAttribute("datas", boardDAO.selectAll(bDTO));
		System.out.println("datas" + boardDAO.selectAll(bDTO));
		return "main";
	}

	@RequestMapping(value = "/login.do")
	public String login(MemberDTO mDTO, BoardDTO bDTO, Model model, HttpSession session) {

		mDTO.setMSearch("로그인");
		mDTO = memberDAO.selectOne(mDTO);
		if (mDTO != null) {
			session.setAttribute("member", mDTO.getMid());
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/logout.do")
	public String logout(BoardDTO bDTO, Model model, HttpSession session) {
		session.removeAttribute("member");

		return "redirect:/";
	}

	@RequestMapping(value = "/check.do")
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

	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public String signUp(MemberDTO mDTO) {	
		mDTO.setMSearch("존재확인");
		if(memberDAO.selectOne(mDTO)==null) {
			memberDAO.insert(mDTO);
		}
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/updateMember.do")
	public String updateMember(MemberDTO mVO, HttpSession session) {		
		if(memberDAO.update(mVO)){
			//session.removeAttribute("member");
			return "redirect:/logout.do";
		}
		else {
			return "redirect:/mypage.do"; /////
		}
	}
	
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(MemberDTO mDTO, HttpSession session) {
		if(memberDAO.delete(mDTO)){
			session.removeAttribute("member");
			return "redirect:/";
		}
		else {
			return "redirect:/mypage.do"; 
		}
	}

	// ***************************************************************************//
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoardPage(BoardDTO bDTO, HttpSession session) {
		
		bDTO.setMid((String) session.getAttribute("member"));
		boardDAO.insert(bDTO);
		
		return "redirect:/";
	}

	@RequestMapping(value="/board.do")
	public String selectBoard(BoardDTO bVO, Model model) {
		model.addAttribute("data", boardDAO.selectOne(bVO));
		//boardDAO.update(bVO);
		return "board";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardDTO bVO) throws IllegalStateException, IOException {
		
		boardDAO.update(bVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardDTO bVO) {
		if(boardDAO.delete(bVO)){
			return "redirect:/";
		}
		else{
			return "redirect:/";
		}
	}

//	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
//	public String insertBoardPage() {
//		
//		return "redirect:insertBoard.jsp";
//	}
//	
//	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
//	public String insertBoard(BoardDTO bVO) throws IllegalStateException, IOException {
//
//		
//		if(boardDAO.insert(bVO)){
//			return "redirect:main.do";
//		}
//		else{
//			return "redirect:insertBoard.jsp";
//		}
//	}

}
