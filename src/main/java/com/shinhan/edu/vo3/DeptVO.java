package com.shinhan.edu.vo3;

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

import com.shinhan.edu.vo.PDSBoard;

import lombok.*;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
@Entity
@Table(name = "tbl_dept")
@EqualsAndHashCode(of = "department_id")
public class DeptVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="employee_ids")
	private List<EmpVO> emplist;
	
	
}
