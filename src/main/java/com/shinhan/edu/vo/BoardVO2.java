package com.shinhan.edu.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity //jpa가 관리
@Table(name = "t_boards2")
public class BoardVO2 {
	
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
	private Timestamp regdate;
	@UpdateTimestamp //update시 시각이 들어간다.
	private Timestamp updatedate;
}
