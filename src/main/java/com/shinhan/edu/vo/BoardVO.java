package com.shinhan.edu.vo;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

/*
 * vo 작성시 유의사항
 * 칼럼의 이름을 예약어로 쓰면 안된다.
 * DB는 대소문자 구분x -> java에서 카멜표기법으로 작성시 DB에선 _로 자동으로 변경됨
 */
@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Entity //jpa가 관리
@Table(name = "t_boards")
public class BoardVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno;
	@NonNull //					java에서 new 생성시 반드시 값이 있어야함
	@Column(nullable = false) //db에 칼럼이 NOT NULL
	private String title;
	@Column(length = 100)
	private String content;
	private String writer;
	@CreationTimestamp //insert시 시각이 들어간다.
	private Timestamp regDate;
	@UpdateTimestamp //update시 시각이 들어간다.
	private Timestamp updateDate;
}
