package com.teamproject.phosk.branch.login.service;

import java.util.List;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

import lombok.NonNull;

public interface BranchLoginService {

	public BranchLoginVO branchLoginSelect(String oner_id, String oner_pwd);

	public List<BranchInfoVO> branchChoiceBranch(String oner_id);

}
