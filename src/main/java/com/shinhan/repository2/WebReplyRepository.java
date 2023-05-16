package com.shinhan.repository2;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shinhan.edu.vo4.WebBoard;
import com.shinhan.edu.vo4.WebReply;

public interface WebReplyRepository extends PagingAndSortingRepository<WebReply, Long>{
	public List<WebReply> findByBoard(WebBoard board);
}
