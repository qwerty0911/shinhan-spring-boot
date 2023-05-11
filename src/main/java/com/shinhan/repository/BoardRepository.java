package com.shinhan.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shinhan.edu.vo.BoardVO;

//CRUD를 위한 Interface 설계
//구현은 JPA가 한다.
//기본은 ㅣfindAll(), findById(), save()
@Repository
public interface BoardRepository extends CrudRepository<BoardVO, Long>{
	//조건조회 추가
	public List<BoardVO> findByTitle(String title);
	public List<BoardVO> findByContent(String content);
	public List<BoardVO> findByWriter(String writer);
	public List<BoardVO> findByWriterAndTitle( String writer,String title);
	
	public List<BoardVO> findByTitleContaining(String title);
	public List<BoardVO> findByTitleStartingWith(String title);
	public List<BoardVO> findByTitleEndingWith(String title);
	
	
}
