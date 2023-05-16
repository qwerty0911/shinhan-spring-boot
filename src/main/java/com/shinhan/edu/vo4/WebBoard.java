package com.shinhan.edu.vo4;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter @Entity
@Table(name="tbl_webboard")
@EqualsAndHashCode
@ToString(excludes = "replies")
@Builder @NoArgsConstructor @AllArgsConstructor
public class WebBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long bno;
	@NonNull
	@Column(nullable=false)
	String title;
	String writer;
	String content;
	@CreationTimestamp
	Timestamp regdate;
	@UpdateTimestamp
	Timestamp updatedate;
	
	@OneToMany(mappedBy = "board",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<WebReply> replies;
	
}
