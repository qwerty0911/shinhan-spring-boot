package com.shinhan.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo3.DeptVO;
import com.shinhan.edu.vo3.EmpVO;
import com.shinhan.repository.DeptRepository;
import com.shinhan.repository.EmpRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class EmpDeptTest {
	
	@Autowired
	DeptRepository deptRepo;
	@Autowired
	EmpRepository empRepo;
	
	@Test
	public void test1() {
	
		List<EmpVO> empList = new ArrayList<EmpVO>();
		IntStream.rangeClosed(1, 10).forEach(index->{
			EmpVO emp =EmpVO.builder()
					.first_name("um"+index)
					.last_name("jun"+index)
					.email("sik"+index)
					.job_id("job"+index)
					.salary((double) (10000/index))
					.commission_pct(0.1)
					.manager_id(1+index)
					.build();
			
			empList.add(emp);
			log.info(emp.toString());
		});

		
		DeptVO dept = DeptVO.builder()
				.location_id(1700)
				.department_name("marketing")
				.manager_id(101)
				.emplist(empList)
				.build();
		
		deptRepo.save(dept);
		
	}
}
