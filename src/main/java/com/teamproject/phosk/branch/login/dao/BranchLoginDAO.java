package com.teamproject.phosk.branch.login.dao;

import java.util.List;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

public interface BranchLoginDAO {

	public BranchLoginVO branchLoginSelect(BranchLoginVO blvo);

	public List<BranchInfoVO> branchChoiceBranch(String oner_id);

}
