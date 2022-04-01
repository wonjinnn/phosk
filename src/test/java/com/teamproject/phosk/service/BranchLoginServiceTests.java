package com.teamproject.phosk.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamproject.phosk.branch.login.service.BranchLoginService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BranchLoginServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BranchLoginService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testGetAllList() {
		//service.getList().forEach(board -> log.info(board));
		service.branchLoginSelect("testID002", "testPWD002");
	}
	@Test
	public void testChoiceBranch() {
		service.branchChoiceBranch("testID").forEach(branch -> log.info(branch));
	}
	
}
