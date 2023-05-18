package com.shinhan.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.querydsl.core.types.Predicate;
import com.shinhan.edu.vo.BoardVO;
import com.shinhan.edu.vo4.PageMarker;
import com.shinhan.edu.vo4.PageVO;
import com.shinhan.edu.vo4.WebBoard;
import com.shinhan.repository2.WebBoardRepository;
import com.shinhan.repository2.WebReplyRepository;

@RequestMapping("/webboard")
@Controller
public class WebBoardController {
	@Autowired
	WebBoardRepository boardRepo;
	@Autowired
	WebReplyRepository replyRepo;
	
	
	@GetMapping("/list.do")
	public void selectAll(PageVO pageVO, Model model) {
		
		if(pageVO==null) {
			pageVO = new PageVO();
			pageVO.setPage(1);
		}
		
		Predicate predicate = boardRepo.makePredicate(pageVO.getType(), pageVO.getKeyword());
		
		Pageable pageable = pageVO.makePageable(pageVO.getPage(), "bno");
		//Pageable pageable = PageRequest.of(0, 10, Direction.DESC, "bno");
		
		Page<WebBoard> result = boardRepo.findAll(predicate, pageable);
		List<WebBoard> blist = result.getContent();
		
		System.out.println("전체페이지수"+result.getTotalPages());
		System.out.println("전체건수"+result.getTotalElements());
		PageMarker<WebBoard> pageMarker = new PageMarker<>(result);
		
		model.addAttribute("blist",pageMarker);
		Page<WebBoard> p_result = pageMarker.getResult();
		System.out.println("plist : "+p_result.getContent());
	}
	
	@GetMapping("/view.do")
	public void selectById(Long bno, Model model, PageVO pageVO) {
		boardRepo.findById(bno).ifPresent(board->{
			model.addAttribute("vo",board);
			model.addAttribute("pageVO",pageVO);
		});
	}
	
	@GetMapping("/modify.do")
	public void updateOrDelete(Long bno, Model model, PageVO pageVO) {
		boardRepo.findById(bno).ifPresent(board->{
			model.addAttribute("vo",board);
			model.addAttribute("pageVO",pageVO);
		});
	}
	
	@PostMapping("/modify.do")
	public String update(WebBoard board, PageVO pageVO, Model model,RedirectAttributes attr) {
		
		WebBoard SavedBoard =  boardRepo.save(board);
		if(SavedBoard!=null) {
			attr.addFlashAttribute("msg","update success");
		}else {
			attr.addFlashAttribute("msg","update fail");
		}
		attr.addAttribute("bno",board.getBno());
		attr.addAttribute("page", pageVO.getPage());
		attr.addAttribute("size", pageVO.getSize());
		attr.addAttribute("keyword", pageVO.getKeyword());
		attr.addAttribute("type", pageVO.getType());
		
		return "redirect:view.do";
			
	}
	
	@PostMapping("/delete.do")
	public String delete(WebBoard board, PageVO pageVO, Model model,
			RedirectAttributes attr) {
		
		if(board.getRegdate()==null) {
			boardRepo.deleteById(board.getBno());
		}else {
			boardRepo.delete(board);
		}
		
		
		//boardRepo.deleteById(board.getBno());
		
		attr.addFlashAttribute("msg","delete success");
		attr.addAttribute("page", pageVO.getPage());
		attr.addAttribute("size", pageVO.getSize());
		attr.addAttribute("keyword", pageVO.getKeyword());
		attr.addAttribute("type", pageVO.getType());
		
		return "redirect:list.do";
			
	}
	
	@GetMapping("/register.do")
	public void registerForm() {
		
		
	}
	
	@PostMapping("/register.do")
	public String registBoard(WebBoard board,RedirectAttributes attr) {
		WebBoard newboard = boardRepo.save(board);
		if(newboard != null) {
			attr.addFlashAttribute("msg","insert success");
		}else {
			attr.addFlashAttribute("msg","insert fail");
		}
		
		return "redirect:list.do";
	}
}


