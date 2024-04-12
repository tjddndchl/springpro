package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	
	@Autowired
	private BoardMapper mapper;
	//boardList.do
	//HandelrMapping
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		
		List<Board> list = mapper.getLists();
		model.addAttribute("list", list);
		return "boardList"; //view의 이름 -> forward
	}
	
	@GetMapping("/boardForm.do")
	public String boardForm() {
		
		return "boardForm";// boardForm.jsp
	}
	
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo) {//파라메터 수집  title,content,writer
		mapper.boardInsert(vo);//등록
		return "redirect:/boardList.do"; //redirect키워드
	}
	
	@GetMapping("/boardContent.do")
	public String boardContent(@RequestParam("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		//조회수 증가
		mapper.boardCount(idx);
		return "boardContent"; //boardContent.jsp
	}
	
	@GetMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) {
		
		mapper.boardDelete(idx);
		
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx);
		
		model.addAttribute("vo", vo);
		
		return "boardUpdate";//boardUpdate.jsp
	}
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) { //idx, title,content
		
		mapper.boardUpdate(vo);//수정 성공
		return "redirect:boardList.do";
	}
}
