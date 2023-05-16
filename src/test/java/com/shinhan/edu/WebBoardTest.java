package com.shinhan.edu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo4.WebBoard;
import com.shinhan.edu.vo4.WebReply;
import com.shinhan.repository2.WebBoardRepository;
import com.shinhan.repository2.WebReplyRepository;

import groovy.util.logging.Log4j;
import lombok.extern.java.Log;

@Log
@SpringBootTest
public class WebBoardTest {
	
	@Autowired
	WebBoardRepository boardRepo;
	@Autowired
	WebReplyRepository replyRepo;
	
	/*
	@Test
	void test5() {
		WebBoard board = boardRepo.findById(44L).get();
		List<WebReply> repls = replyRepo.findByBoard(board);
		repls.forEach(reply->{
			log.info(reply.toString());
		});
	}
	
	
	@Test
	void test4() {
		boardRepo.findById(44L).ifPresent(board->{
			List<WebReply> replies = board.getReplies();
			for (WebReply reply:replies) {
				log.info(""+reply);
			}
		});
	}
	
	
	@Test
	void testSelect() {
		log.info(""+boardRepo.count());
		boardRepo.findAll().forEach(board->{
			System.out.println(board.toString());
		});
		replyRepo.findAll().forEach(reply->{
			System.out.println(reply.toString());
		});
	}
	
	@Test
	void test2() {
		Long[] arr = {11L, 24L, 44L, 53L, 86L};
		Arrays.stream(arr).forEach(bno->{
			boardRepo.findById(bno).ifPresent(board->{
				IntStream.rangeClosed(20, 30).forEach(index->{
					WebReply reply = WebReply.builder()
							.replyer("user"+(index%10))
							.reply("그냥 그랬다."+index)
							.board(board)
							.build();
					
					replyRepo.save(reply);
				});
			});
		});
	}
	
	
	
	//board에 insert 100건
	@Test
	void test1() {
		IntStream.rangeClosed(0, 100).forEach(index->{
			WebBoard board = WebBoard.builder()
					.title("title"+index)
					.writer("user"+(index%10))
					.content("어쩌구 저쩌구 그랬답니다.")
					.build();
			
			boardRepo.save(board);
		});
	}
	*/

}
