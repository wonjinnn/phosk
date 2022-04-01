package com.teamproject.phosk.branch.info.vo;

import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class BranchInfoVO extends BranchLoginVO {
	@NonNull private String branch_num;
	@NonNull private String branch_name;
	@NonNull private String branch_phone;
	@NonNull private String branch_leaderName;
	@NonNull private String branch_addr;
	private String branch_detail;
	private int branch_type;
	private String branch_openTime;
	private String branch_closeTime;
	private String branch_foundationDate;
	private String branch_regDate;
	private String branch_image;
	
	
}
