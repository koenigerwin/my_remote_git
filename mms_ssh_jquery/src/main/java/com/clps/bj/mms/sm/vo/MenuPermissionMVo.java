package com.clps.bj.mms.sm.vo;
/**
 * 
 * @description：TODO
 * @className：MenuPermissionMVo
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年2月5日上午9:32:11
 */

import java.util.List;

public class MenuPermissionMVo extends MyInfo {
	private List<String> permissionNames;  //权限名称

	/**
	 * @return the permissionNames
	 */
	public final List<String> getPermissionNames() {
		return permissionNames;
	}

	/**
	 * @param permissionNames the permissionNames to set
	 */
	public final void setPermissionNames(List<String> permissionNames) {
		this.permissionNames = permissionNames;
	}
	
	
}
