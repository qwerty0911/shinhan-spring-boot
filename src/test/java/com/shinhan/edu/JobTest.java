package com.shinhan.edu;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.edu.vo.JobVO;
import com.shinhan.repository.JobRepository;

@SpringBootTest
public class JobTest {
	
	Logger LOGGER = LoggerFactory.getLogger(JobTest.class);
	@Autowired
	JobRepository repo;
	
	/*
	@Test
	public void test1() {
		String[] arr = {"마케팅","QA","Tester","CS","accountant","manager","SM","SI","기획","CICD"};
		//crud
		IntStream.rangeClosed(0, 10).forEach(index->{
			JobVO job = JobVO.builder()
					.jobId("id"+(index))
					.JobTitle("직책"+arr[index])
					.minSalary(1000)
					.maxSalary(5000)
					.build();
			repo.save(job);
		});
	}
	*/
	
	@Test
	public void jobFindAll() {
		List<JobVO> jobs = (List<JobVO>) repo.findAll();
		Assertions.assertThat(jobs.size()).isEqualTo(9);
		LOGGER.info(""+jobs.size());
	}
	@Test
	public void test3() {
		Optional<JobVO> jobOptional = repo.findById("id0");
		if(jobOptional.isPresent()) {
			JobVO job = jobOptional.get();
			LOGGER.info(job.toString());
		}else {
			LOGGER.info("없다.");
		}
	}
	
	
	@Test
	public void test4() {
		repo.findById("id0").ifPresent(job->{
			job.setJobTitle("marketing");
			job.setMinSalary(500);
			job.setMaxSalary(20000);
			repo.save(job);
		});
		LOGGER.info(repo.findById("id0").toString());
	}
	
	@Test
	public void test5() {
		repo.findById("id0").ifPresent(job->{
			repo.delete(job);
		});
		LOGGER.info(repo.findById("id0").toString());
	}
	
	
}
