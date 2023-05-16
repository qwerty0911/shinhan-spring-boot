package com.shinhan.repository2;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.shinhan.edu.vo4.QWebBoard;
import com.shinhan.edu.vo4.WebBoard;

public interface WebBoardRepository 
	extends PagingAndSortingRepository<WebBoard, Long>,
	QuerydslPredicateExecutor<WebBoard>{
	
	
	//1. 상수
	//2. 추상메서드
	//3. defualt 메서드
	//4. static메서드
	
	public default Predicate makePredicate(String type, String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		QWebBoard board = QWebBoard.webBoard;
		builder.and(board.bno.gt(0)); //and bno>0 동적으로 들어감
		//검색조건처리
		if(type==null) return builder;
		switch (type) {
		case "title": builder.and(board.title.like("%" + keyword + "%")); break;
		case "content": builder.and(board.content.like("%" + keyword + "%")); break;
		case "writer": builder.and(board.writer.like("%" + keyword + "%")); break;
		default: break;
		}
		return builder;
		}
}
