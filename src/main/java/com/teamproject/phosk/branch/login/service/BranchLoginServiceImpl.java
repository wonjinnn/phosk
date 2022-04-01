package com.teamproject.phosk.branch.login.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.login.dao.BranchLoginDAO;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
@ToString
public class BranchLoginServiceImpl implements BranchLoginService {
	private final BranchLoginDAO dao;
	
	@Override
	public BranchLoginVO branchLoginSelect(String oner_id, String oner_pwd) {
		log.info("branchLoginSelect...  ID:" + oner_id + " PW:" + oner_pwd);
		BranchLoginVO blvo = new BranchLoginVO();
		blvo.setOner_id(oner_id);
		blvo.setOner_pwd(oner_pwd);
		return dao.branchLoginSelect(blvo);
	}

	@Override
	public List<BranchInfoVO> branchChoiceBranch(String oner_id) {
		log.info("branchChoiceBranch...  ID:" + oner_id);
		return dao.branchChoiceBranch(oner_id);
	}

}
