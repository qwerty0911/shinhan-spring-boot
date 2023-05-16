package com.shinhan.edu.vo3;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
@Entity
@Table(name = "tbl_emp")
@EqualsAndHashCode(of = "employee_id")
public class EmpVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	@CreationTimestamp
	private Date hire_date;
	private String job_id;
	private Double salary;
	private Double commission_pct;
	private Integer manager_id;
	
	//private Integer department_id;
}
