package com.shinhan.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo.PDSBoard;
import com.shinhan.edu.vo.PDSFile;
import com.shinhan.repository.PDSBoardRepository;
import com.shinhan.repository.PDSFileRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class OneToManyTest {

	@Autowired
	PDSFileRepository fileRepo;
	@Autowired
	PDSBoardRepository boardRepo;

	
	@Test //eager
	public void test4() {
		Iterable<PDSBoard> boardList = boardRepo.findAll();
		boardList.forEach(board->{
			log.info(board.getPname() + " : "+board.getFiles2().size()+"건");
		});
		
		//lazy
		List<Object[]> bList = boardRepo.getFilesInfo2();
		bList.forEach(board->{
			log.info(board.toString());
		});
	}
	
	
	
	/*
	@Test
	public void test3() {
		boardRepo.getFilesInfo(43L).forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		});
		
		PDSBoard board = boardRepo.findById(123L).orElse(null);
		if(board!=null) {
			System.out.println(board.getPname());
			System.out.println(board.getPwriter());
			System.out.println(board.getFiles2());
			
		}
	}
	
	@Test
	void deleteByBoard() {
		Long bno = 117L;
		boardRepo.deleteById(bno);
	}

	
	 * @Test void deleteFile() { Long[] arr = {111L};
	 * 
	 * Arrays.stream(arr).forEach(bno->{ fileRepo.deleteById(bno); }); }
	 * 
	 * 
	 * @Test void selectAll() { boardRepo.findAll().forEach(board->{
	 * log.info(board.getPname() + " : " + board.getPwriter() + " : "+
	 * board.getFiles2().size()+"건"); });; }
	 * 
	 * @Test void insertAll() { List<PDSFile> flist = new ArrayList<>();
	 * IntStream.range(1, 6).forEach(index->{ PDSFile f = PDSFile.builder()
	 * .pdsfilename("midking-"+index+".pdf") .build(); flist.add(f); });
	 * 
	 * 
	 * 
	 * 
	 * PDSBoard board = PDSBoard.builder() .pname("미드학개론") .pwriter("형섭")
	 * .files2(flist) .build();
	 * 
	 * boardRepo.save(board); }
	 */

}
