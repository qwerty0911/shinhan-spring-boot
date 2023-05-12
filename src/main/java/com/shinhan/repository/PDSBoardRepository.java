package com.shinhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shinhan.edu.vo.PDSBoard;

public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long> {

	@Query("select b.pname, b.pwriter, f.pdsfilename " + " from PDSBoard b left outer join b.files2 f "
			+ " where b.pid = ?1 order by b.pid ")
	public List<Object[]> getFilesInfo(long pid);

	//fetch가 lazy일 때 native query를 이용할 수 있다.
	@Query(value = "select board.pname, count(*)"
			+ " from tbl_pdsboard board left outer join tbl_pdsfiles files on(board.pid = files.pdsno)"
			+ " group by board.pname", nativeQuery = true)
	public List<Object[]> getFilesInfo2();
}
