package com.shinhan.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder	//@AllArgsConstructor, @NoArgsConstructor 추가해야함
public class CarVO {
	
	private String model;
	private int price;

}
