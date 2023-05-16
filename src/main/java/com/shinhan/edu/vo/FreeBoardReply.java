package com.shinhan.edu.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString(exclude = "board")
@Builder @NoArgsConstructor @AllArgsConstructor 
@EqualsAndHashCode(of = {"rno"})
@Entity
@Table(name="tbl_free_replies")
public class FreeBoardReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long rno;
	String reply;
	String replyer;
	@CreationTimestamp
	Timestamp regDate;
	@UpdateTimestamp
	Timestamp updateDate;
	
	//연관관계 설정 : n:1
	//FK : tbl_free_replies에 칼럼이 board_bno로 생성
	@ManyToOne
	FreeBoard board;
}
