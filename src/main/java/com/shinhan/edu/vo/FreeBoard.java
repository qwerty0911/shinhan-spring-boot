package com.shinhan.edu.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Builder @NoArgsConstructor @AllArgsConstructor 
@EqualsAndHashCode(of = {"bno","title"})
@Entity
@Table(name="tbl_freeboards")
public class FreeBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long bno;
	String title;
	String writer;
	String content;
	@CreationTimestamp
	Timestamp regdate;
	@UpdateTimestamp
	Timestamp updateDate;
	
	//연간관계 섲어 1:n
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			mappedBy = "board") //댓글이 있으면 지울 수 없다.
	List<FreeBoardReply> replies;
}
