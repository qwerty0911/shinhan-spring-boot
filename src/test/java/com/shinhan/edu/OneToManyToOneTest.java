package com.shinhan.edu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.shinhan.edu.vo.FreeBoard;
import com.shinhan.edu.vo.FreeBoardReply;
import com.shinhan.repository.FreeBoardRepository;
import com.shinhan.repository.FreeRepliesRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class OneToManyToOneTest {

	@Autowired
	FreeBoardRepository boardRepo;
	@Autowired
	FreeRepliesRepository replyRepo;
	/*
	@Test //댓글도 함꼐 삭제되낟.
	void test8() {
		boardRepo.findById(100L).ifPresent(board->{
			boardRepo.delete(board);
		});
	}
	
	//bno가 n 이상인 board 조회
	@Test
	void test7() {
		Pageable page = PageRequest.of(0, 5, Sort.Direction.ASC, "bno");
		List<FreeBoard> boards = boardRepo.findByBnoGreaterThan(99L, page);
		boards.forEach(board->{
			log.info(board.getBno()+"제목 : "+board.getTitle()+", 쓰니 : "+board.getWriter()+", 댓글 수 : "+board.getReplies().size());
		});
	}
	
	//board번호가 100 이상인 board 조회 paging 추가
	@Test
	void test6() {
		Pageable page = PageRequest.of(0, 5, Sort.Direction.DESC, "bno");
		List<FreeBoard> boards = boardRepo.findByBnoGreaterThan(15L, page);
		boards.forEach(board->{
			log.info(board.getBno()+"제목 : "+board.getTitle()+", 쓰니 : "+board.getWriter()+", 댓글 수 : "+board.getReplies().size());
		});
	}
	
	//bno가 15번인 댓글만 알고싶을때
	@Test
	void test5() {
		
		boardRepo.findById(15L).ifPresent(board->{
			replyRepo.findByBoard(board).forEach(reply->{
				log.info(reply+"--->");
			});
		});
	}
		
		
	@Test
	void test4() {
		replyRepo.findAll().forEach(re->{
			log.info(re.getReply()+re.getReplyer());
		});
	}
	*/
	//board 번호와 댓글의 수
	@Test
	void boardSelect() {
		boardRepo.findAll().forEach(board->{
			log.info(board.getBno()+" : "+board.getReplies().size());
		});
	}
	/*
	//댓글 insert
	@Test
	void test2() {
		Long[] arr = {1L,10L,50L,100L};
		
		Arrays.stream(arr).forEach(index->{
			boardRepo.findById(index).ifPresent(board->{
				IntStream.rangeClosed(10, 20).forEach(index2->{
					FreeBoardReply reply = FreeBoardReply.builder()
							.reply("댓글"+index2)
							.replyer("user"+(index2%2+1))
							.board(board)
							.build();
					
					log.info(reply.toString());
					replyRepo.save(reply);
				});
			});
		});
		
		
	}
	
	
	//board insert 100건
	@Test
	void test1() {
		IntStream.rangeClosed(1, 100).forEach(index->{
			FreeBoard board = FreeBoard.builder()
					.title("title"+index)
					.writer("user"+(index%10))
					.content("아무말...")
					.build();
			
			boardRepo.save(board);
		});
	}
	*/
	
	
}
