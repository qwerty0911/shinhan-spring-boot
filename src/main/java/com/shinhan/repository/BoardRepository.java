package com.shinhan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shinhan.edu.vo.BoardVO;

//CRUD를 위한 Interface 설계
//구현은 JPA가 한다.
//기본은 ㅣfindAll(), findById(), save()
@Repository
public interface BoardRepository extends CrudRepository<BoardVO, Long>, QuerydslPredicateExecutor<BoardVO>{
	//조건조회 추가
	public List<BoardVO> findByTitle(String title);
	public List<BoardVO> findByTitleContainingOrderByTitleDesc(String title);
	public List<BoardVO> findByContent(String content);
	public List<BoardVO> findByWriter(String writer);
	public List<BoardVO> findByWriterAndTitle( String writer,String title);
	
	public List<BoardVO> findByTitleContainingOrderByTitleDesc(String title,Pageable page);
	public List<BoardVO> findByTitleContaining(String title,Pageable page);
	public List<BoardVO> findByTitleOrderByTitle(String title, Pageable pageable);
	
	public List<BoardVO> findByTitleContaining(String title);
	public List<BoardVO> findByTitleStartingWith(String title);
	public List<BoardVO> findByTitleEndingWith(String title);
	
	public Page<BoardVO> findByBnoGreaterThan(Long bno,Pageable pageable);
	
	//JPQL(JPL Query Language)...*(아스테리크) 지원안함
	@Query("select b from BoardVO b where b.title like %?1% "
			+ "or b.content like %?2% order by b.bno desc")
	public List<BoardVO> findByTitle2(String title, String content);
	
	@Query("select b from BoardVO b where b.title like %:tt% "
			+ "or b.content like %:cc% order by b.bno desc")
	public List<BoardVO> findByTitle3(@Param("tt") String title,@Param("cc") String content);
	
	@Query("select b from #{#entityName} b where b.title like %?1% "
			+ "or b.content like %?2% order by b.bno desc")
	public List<BoardVO> findByTitle4(String title, String content);
	
	@Query("select b.title, b.content, b.writer from #{#entityName} b where b.title like %?1% "
			+ "or b.content like %?2% order by b.bno desc")
	public List<BoardVO[]> findByTitle5(String title, String content);
	
	//jpql로도 안될때 sql문장을 직접 작성한다. nativeQuery = true(남용하지 않는것이 좋다.)
	@Query(value = "select * from t_boards b where b.title like '%'||?1||'%' "
			+ "or b.content like '%'||?1||'%' order by b.bno desc", nativeQuery=true)
	public List<BoardVO> findByTitle6(String title, String content);
}
