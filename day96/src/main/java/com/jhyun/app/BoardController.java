package com.jhyun.app;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("data")
public class BoardController {
	
	@Autowired
	private InterfaceBoardService boardService;
	
	@RequestMapping("/")
	public String root(@ModelAttribute("mem")MemberDTO mDTO, BoardDTO bDTO, Model model) {
		mDTO.setMid("test");
		mDTO.setMpw("1234");

		model.addAttribute("datas", boardService.selectAll(bDTO));
		System.out.println("datas" + boardService.selectAll(bDTO));
		return "main";
	}

	@RequestMapping(value="/insertBoard")
	public String insertBoardPage(BoardDTO bDTO, HttpSession session) {
		
		bDTO.setMid((String) session.getAttribute("member"));
		boardService.insert(bDTO);
		
		return "redirect:/";
	}

	@RequestMapping(value="/board")
	public String selectBoard(BoardDTO bVO, Model model) {
		model.addAttribute("data", boardService.selectOne(bVO));
		return "board";
	}
	
	@RequestMapping(value="/updateBoard")
	public String updateBoard(@ModelAttribute("data")BoardDTO bDTO) throws IllegalStateException, IOException {
		
		bDTO.setSearch("수정");
		boardService.update(bDTO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteBoard")
	public String deleteBoard(BoardDTO bVO) {
		if(boardService.delete(bVO)){
			return "redirect:/";
		}
		else{
			return "redirect:/";
		}
	}
	
}
