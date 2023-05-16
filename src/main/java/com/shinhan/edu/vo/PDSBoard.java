package com.shinhan.edu.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString//(exclude = {"files","files2"})
@Entity
@Table(name = "tbl_pdsboard")
@EqualsAndHashCode(of = "pid")
public class PDSBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	private String pname;
	private String pwriter;
	// cascade:영속성전이 PDSBoard변경시 PDSFile변경)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // 즉시로딩
	// JPA는 default로 지연로딩을 사용한다.(PDSBoard조회시 PDSFile 조인하지않음)
	// 1)fetch = FetchType.LAZY ....PDSFile과 연결불가, @Query로 해결
	// 2)fetch = FetchType.EAGER....PDSFile과 연결가능
	@JoinColumn(name = "pdsno") // PDSFile칼럼에 생성
	private List<PDSFile> files2; //file2변수는 칼럼으로 생성되지 않는다.
}