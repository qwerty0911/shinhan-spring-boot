package com.shinhan.edu.vo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_members")
public class MemberDTO {
    @Id
	String mid;
	String mpassword;
	String mname;
	
	@Enumerated(EnumType.STRING)
	MemberRole mrole;
}
