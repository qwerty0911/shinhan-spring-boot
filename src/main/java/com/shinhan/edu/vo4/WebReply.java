package com.shinhan.edu.vo4;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shinhan.edu.vo.FreeBoard;

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
@Table(name="tbl_webreplies")
public class WebReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long rno;
	String reply;
	String replyer;
	@CreationTimestamp
	Timestamp regDate;
	@UpdateTimestamp
	Timestamp updateDate;
	
	
	//@JsonIgnore
	@BatchSize(size = 100)
	@ManyToOne(fetch=FetchType.LAZY)
	WebBoard board;
}
