package com.shinhan.edu.vo2;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.shinhan.edu.vo.MemberRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Data
@Table(name="tbl_enum")
public class EnumTypeVO {
	
	@Id
	String mid;
	String mpassword;
	String mname;
	
	@ElementCollection(targetClass = MemberRole.class, fetch = FetchType.EAGER)
	@CollectionTable(name="tbl_enum_mroles", joinColumns = @JoinColumn(name="mid"))
	@Enumerated(EnumType.STRING)
	Set<MemberRole> mrole;
}
/*
 * 한명의 member(EnumTypeVO)가 여러개의 권한을 가지고 있따.
 * tbl_enum_mrole에 member의 권한들이 저장 (하나의 mid에 대해 여러개의 mrole)
 */