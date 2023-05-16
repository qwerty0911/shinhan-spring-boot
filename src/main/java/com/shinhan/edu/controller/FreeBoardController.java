package com.shinhan.edu.controller;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shinhan.repository.FreeBoardRepository;
import com.shinhan.repository.FreeRepliesRepository;

@Controller
public class FreeBoardController {
	
	@Autowired
	FreeBoardRepository boardRepo;
	
	@Autowired
	FreeRepliesRepository replyRepo;
	
	@GetMapping("/freeboard/eltest")
	public void freeboardtest1(Model model, HttpSession session) {
		model.addAttribute("boardList",boardRepo.findAll());
		session.setAttribute("username","junsik");		
		model.addAttribute("now",new Date());
		model.addAttribute("price",100050);
		model.addAttribute("title","just becuase");
		model.addAttribute("options",Arrays.asList("apple","car","iphone"));
		model.addAttribute("myword","가 나 다 라 마 바 사");
	}

	@GetMapping("/freeboard/list")
	public String freeboardList(Model model) {
		model.addAttribute("boardList",boardRepo.findAll());
		
		return "freeboard/boardlist";
	}
	
	@GetMapping("/freeboard/detail")
	public void freeboard1(Long bno,Model model) {
		boardRepo.findById(bno).ifPresent(board->{
			model.addAttribute("board",board);
		});
	}
	
	@GetMapping("/aa/example3")
	public void test3(Model model) {
		model.addAttribute("greeting","Hi~!");
		model.addAttribute("company","shinhan finance");
	}
	
	@GetMapping("/example2")
	public String test2(Model model) {
		model.addAttribute("greeting","Hi~!");
		model.addAttribute("company","shinhan finance");
		
		return "example1";
	}
	
	@GetMapping("/example1")
	public void test1(Model model) {
		model.addAttribute("greeting","Hi~!");
		model.addAttribute("company","shinhan finance");
		
	}
	
	
}
