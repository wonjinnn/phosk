package com.teamproject.phosk.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamproject.phosk.branch.login.dao.BranchLoginDAO;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BranchLoginDaoTests {
	@Setter(onMethod_ = @Autowired )
	private  BranchLoginDAO dao;
	
	@Test
	public void testGetALLList() {
		BranchLoginVO blvo = new BranchLoginVO("testID002" , "testPWD002");
		log.info(dao.branchLoginSelect(blvo));
		
	}
	@Test
	public void testChoiceBranch() {
		dao.branchChoiceBranch("testID").forEach(branch -> log.info(branch));
	}
	
	
	
}
