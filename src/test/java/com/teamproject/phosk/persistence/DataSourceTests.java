package com.teamproject.phosk.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //Junit 관련 스프링을 실행하는 역할을 할 것이라는 것을 표시.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 캑체로 등록(빈으로 만든다.)
@Log4j
public class DataSourceTests {
	
	@Setter(onMethod_ = { @Autowired } )
	private DataSource dataSource;
	
	@Setter(onMethod_ = { @Autowired } )
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMyBatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();) {
			
			log.info(session);
			log.info(con);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConnection() {
		try (Connection con = dataSource.getConnection()){
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
}
