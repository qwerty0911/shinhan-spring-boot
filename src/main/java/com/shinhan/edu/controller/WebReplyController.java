package com.shinhan.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.edu.vo4.WebBoard;
import com.shinhan.edu.vo4.WebReply;
import com.shinhan.repository2.WebBoardRepository;
import com.shinhan.repository2.WebReplyRepository;

@RestController
@RequestMapping("/replies/*")
public class WebReplyController {

	@Autowired
	WebReplyRepository replyRepo;

	@Autowired
	WebBoardRepository boardRepo;

	@GetMapping("/{bno}")
	public List<WebReply> selectAllReply(@PathVariable("bno") Long bno) {
		System.out.println(bno + "보드의 모든 댓글 조회");
		WebBoard board = new WebBoard();
		board.setBno(bno);
		List<WebReply> replies = replyRepo.findByBoardOrderByRnoDesc(board);
		return replies;
	}

	@PostMapping("/{bno}")
	public List<WebReply> insertReply(@RequestBody WebReply reply, @PathVariable("bno") Long bno) {

		WebBoard board = boardRepo.findById(bno).get();

		reply.setBoard(board);
		replyRepo.save(reply);

		List<WebReply> replies = replyRepo.findByBoardOrderByRnoDesc(board);
		return replies;
	}
	/*
	@PutMapping("/{bno}")
	public List<WebReply> updateReply(@RequestBody WebReply reply, @PathVariable("bno") Long bno) {

		WebBoard board = boardRepo.findById(bno).get();

		reply.setBoard(board);
		replyRepo.save(reply);

		List<WebReply> replies = replyRepo.findByBoardOrderByRnoDesc(board);
		return replies;
	}*/
	
	@PutMapping("/{bno}")
	public ResponseEntity<List<WebReply>> updateReply(@RequestBody WebReply reply, @PathVariable("bno") Long bno) {

		WebBoard board = boardRepo.findById(bno).get();

		reply.setBoard(board);
		replyRepo.save(reply);
		
		return makeReturn(bno, HttpStatus.OK);
	}
	
	@DeleteMapping("/{bno}/{rno}")
	public ResponseEntity<List<WebReply>>  deleteReply(
			@PathVariable("bno") Long bno,
			@PathVariable("rno") Long rno) {

		WebBoard board = boardRepo.findById(bno).get();

		replyRepo.deleteById(rno);

		List<WebReply> replies = replyRepo.findByBoardOrderByRnoDesc(board);
		return new ResponseEntity<List<WebReply>>(replies, HttpStatus.OK);
	}
	
	
	private ResponseEntity<List<WebReply>> makeReturn(Long bno, HttpStatus status){
		
		WebBoard board = WebBoard.builder().bno(bno).title("title").build(); 
		List<WebReply> replies = replyRepo.findByBoardOrderByRnoDesc(board);
		
		return new ResponseEntity<List<WebReply>>(replies, HttpStatus.OK);
	}

}
