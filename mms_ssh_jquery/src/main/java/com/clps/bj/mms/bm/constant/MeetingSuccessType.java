package com.clps.bj.mms.bm.constant;

public enum MeetingSuccessType {
	SUCCESS("0", "已成功"), NOSUCESS("1", "未成功");

	private String id;
	private String value;

	private MeetingSuccessType() {

	}

	private MeetingSuccessType(String id, String value) {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
