package com.teamproject.phosk.branch.login.vo;

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
@NoArgsConstructor
@RequiredArgsConstructor
public class BranchLoginVO {
	@NonNull private String oner_id; 	//점주 아이디
	@NonNull private String oner_pwd;	//점주 비밀번호
	private String oner_email; 	//점주 이메일
	private String oner_phone;	//점주 핸드폰 번호
}
