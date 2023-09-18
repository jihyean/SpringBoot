package com.jhyun.app;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;


@SessionAttributes("data")
public class BoardController {
	
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	BoardDAO boardDAO;

	@ModelAttribute("searchMap")
	public Map<String,String> searchMap(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("제목", "TITLE");
		map.put("작성자", "WRITER");
		return map;
	}
	
	@RequestMapping(value="/main.do")
	public String main(@ModelAttribute("mem")MemberDTO mVO, BoardDTO bVO, Model model) {
		mVO.setMid("test");
		mVO.setMpw("1234");
		
		// model.addAttribute("mem", mVO);
		model.addAttribute("datas", boardDAO.selectAll(bVO));
		return "main.jsp";
	}
	
	@RequestMapping(value="/board.do")
	public String selectBoard(BoardDTO bVO, Model model) {
		model.addAttribute("data", boardDAO.selectOne(bVO));
		//bVO.setSearchCondition("CNT");
		boardDAO.update(bVO);
		return "board.jsp";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardDTO bVO) throws IllegalStateException, IOException {
		
		boardDAO.update(bVO);
		return "board.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardDTO bVO) {
		if(boardDAO.delete(bVO)){
			return "redirect:main.do";
		}
		else{
			return "board.do";
		}
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoardPage() {
		// AOP 이전에는 일일히 로그를 직접 추가했었음
		// 단순 페이지요청조차도 로그가 찍혔음
		// 메서드 호출 == 느림
		
		// service를 사용하는 건에 대해서만 AOP를 수행하기때문에,
		// 로그가 안찍힘
		// 메서드 안 호출 == 빠름
		
		return "redirect:insertBoard.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardDTO bVO) throws IllegalStateException, IOException {

		
		if(boardDAO.insert(bVO)){
			return "redirect:main.do";
		}
		else{
			return "redirect:insertBoard.jsp";
		}
	}
	
}
