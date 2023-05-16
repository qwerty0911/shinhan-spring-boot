package com.shinhan.edu;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.shinhan.edu.vo.PDSBoard;
import com.shinhan.edu.vo.PDSFile;
import com.shinhan.repository.BoardRepository;
import com.shinhan.repository.PDSBoardRepository;
import com.shinhan.repository.PDSFileRepository;

@SpringBootTest
@Commit //롤백 안함
public class OneToManyTest2 {

	@Autowired
	PDSBoardRepository boardRepo;
	
	@Autowired
	PDSFileRepository fileRepo;
	
	@Test
	void testBoardFileInsert() {
		boardRepo.findById(9L).ifPresent(board->{
			List<PDSFile> files2 = board.getFiles2();
			PDSFile file=PDSFile.builder()
			.pdsfilename("content1")
			.build();
			files2.add(file);
			boardRepo.save(board);
		});
	}
	

	/*
	//board를 이용해 file이름 수정
	@Test
	void testBoardFileUpdate() {
		boardRepo.findById(9L).ifPresent(board->{
			List<PDSFile> files2 = board.getFiles2();
			files2.forEach(file->{
				file.setPdsfilename(file.getPdsfilename()+"(수정)");
				fileRepo.save(file);
			});
		});
	}
	
	
	//PDSBoardRepository(부모)를 이용해 자식을 수정
	//실행은 성공하지만 Test환경에서는 Rollback처리한다. class레벨에 commit 추가시 rollback 안함
	@Test
	void fileUPdate() {
		boardRepo.updateFile(10L,"머릿말(수정)");
	}
	
	
	//lazy인 경우 자식에 접근하기 위해 사용
	//@Transactional
	@Test
	void test7() {
		System.out.println("test7");
		boardRepo.findAll().forEach(b->{
			System.out.println(b.getFiles2());
		});
	}
	
	
	
	//부모에서 자식을 insert
	@Test
	void test6() {
		List<PDSFile> files = new ArrayList<>();
		PDSFile file1 = PDSFile.builder().pdsfilename("머릿말").build();
		PDSFile file2 = PDSFile.builder().pdsfilename("추천사").build();
		PDSFile file3 = PDSFile.builder().pdsfilename("epilog").build();
		files.add(file1);
		files.add(file2);
		files.add(file3);
		
		PDSBoard board = PDSBoard.builder()
				.pname("가면산장")
				.pwriter("히가시노 게이고")
				.files2(files)
				.build();
		
		boardRepo.save(board);
		
	}
	
	//java에서 칼럼이 없으므로 다음 방법은 불가능
	@Test
	void test5() {
		PDSFile file = fileRepo.findById(11L).orElse(null);
		if(file!=null) {
			//PDSBoard board = boardRepo.findById(2L).orElse(null);
			//file.set
			file.setPdsfilename("추천사(수정)");
			fileRepo.save(file);
		}
	}
	@Test
	void test4() {
		boardRepo.findAll().forEach(b->System.out.println(b));
	}
	
	//부모만 insert
	@Test
	void test3() {
		
		PDSBoard board = PDSBoard.builder()
				.pname("게시글")
				.pwriter("작성자")
				.build();
		boardRepo.save(board);
	}
	
	@Test
	void test2() {
		fileRepo.findAll().forEach(f->System.out.println(f));
	}
	
	//자식만 insert
	@Test
	void test1() {
		PDSFile file = PDSFile.builder()
				.pdsfilename("첨부파일")
				.build();
		fileRepo.save(file);
	}
	*/
}
