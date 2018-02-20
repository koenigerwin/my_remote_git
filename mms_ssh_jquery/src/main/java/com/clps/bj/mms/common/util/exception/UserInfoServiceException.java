/**
 * 
 */
package com.clps.bj.mms.common.util.exception;

/**
 * @Description
 * @author Administrator
 * @Since V1.0.0
 * 2018年2月1日上午10:49:35
 */
public class UserInfoServiceException extends Exception{
	/**
	 * serialVersionUID:TODO(出现异常时提示信息).
	 *
	 */
	private static final long serialVersionUID = 1L;
    public static final String USERINFO_EXIST="该用户名已存在！";
    public static final String USERINFO_NOT_EXIST="该用户名不存在！";
    public static final String WRONG_PWD="密码错误！";
	public UserInfoServiceException() {
		
		super();
		
	}

	public UserInfoServiceException(String message, Throwable cause) {
		
		super(message, cause);
		
	}

	public UserInfoServiceException(String message) {
		
		super(message);
		
	}

	public UserInfoServiceException(Throwable cause) {
		
		super(cause);
	
	}

}
