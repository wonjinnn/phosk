package com.teamproject.phosk.branch.login.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;


@Repository
public class BranchLoginDAOImpl implements BranchLoginDAO {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public BranchLoginVO branchLoginSelect(BranchLoginVO blvo) {
		return session.selectOne("branchLoginSelect" , blvo);
	}

	@Override
	public List<BranchInfoVO> branchChoiceBranch(String oner_id) {
		return session.selectList("branchChoiceBranch" , oner_id);
	}

}
