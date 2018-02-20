package com.clps.bj.mms.sm.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * @description：部门模型
 * @className：Department
 * @author Kyoma.yu
 * @version V1.0.0 2018年1月22日 下午2:13:11
 * 
 */
@Entity
@Table(name = "Department")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5631348990471520893L;
	private Integer deptId; // 部门编号,主键
	private String deptName; // 部门名称,必填唯一
	private Integer deptParentId; // 部门的父部门
	private String deptAb; // 部门缩写,必填唯一
	private String deptSortId; // 部门排序号,唯一
	private Integer deptNlevel; // 部门层级,默认为1
	private String deptCreatedDatetime; // 创建时间,必填
	private Integer deptCreatedName; // 创建人名,必填
	private String deptUpdatedDatetime; // 修改时间,必填
	private Integer deptUpdatedName; // 修改人名,必填
	private String deptDefault1; // 默认字段1
	private String deptDefault2; // 默认字段2

	/**
	 * 
	 */
	public Department() {
	}

	/**
	 * @return the dept_id
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "increment") // 设置主键自增
	@GeneratedValue(generator = "generator")
	@Column(name = "dept_id")
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @param dept_id
	 *            the dept_id to set
	 */
	public void setDeptId(Integer dept_id) {
		this.deptId = dept_id;
	}

	/**
	 * @return the dept_name
	 */
	@Column(name = "dept_name", length = 50, nullable = false, unique = true)
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param dept_name
	 *            the dept_name to set
	 */
	public void setDeptName(String dept_name) {
		this.deptName = dept_name;
	}

	/**
	 * @return the dept_parent_id
	 */
	@Column(name = "dept_parent_id", length = 11, columnDefinition = "INT default 0")
	public Integer getDeptParentId() {
		return deptParentId;
	}

	/**
	 * @param dept_parent_id
	 *            the dept_parent_id to set
	 */
	public void setDeptParentId(Integer dept_parent_id) {
		this.deptParentId = dept_parent_id;
	}

	/**
	 * @return the dept_ab
	 */
	@Column(name = "dept_ab", length = 50, nullable = false, unique = true)
	public String getDeptAb() {
		return deptAb;
	}

	/**
	 * @param dept_ab
	 *            the dept_ab to set
	 */
	public void setDeptAb(String dept_ab) {
		this.deptAb = dept_ab;
	}

	/**
	 * @return the dept_sort_id
	 */
	@Column(name = "dept_sort_id", length = 50, unique = true)
	public String getDeptSortId() {
		return deptSortId;
	}

	/**
	 * @param dept_sort_id
	 *            the dept_sort_id to set
	 */
	public void setDeptSortId(String dept_sort_id) {
		this.deptSortId = dept_sort_id;
	}

	/**
	 * @return the dept_nlevel
	 */
	@Column(name = "dept_nlevel", length = 11, columnDefinition = "INT default 1")
	public Integer getDeptNlevel() {
		return deptNlevel;
	}

	/**
	 * @param dept_nlevel
	 *            the dept_nlevel to set
	 */
	public void setDeptNlevel(Integer dept_nlevel) {
		this.deptNlevel = dept_nlevel;
	}

	/**
	 * @return the dept_created_datetime
	 */
	@Column(name = "dept_created_datetime", length = 50, nullable = false)
	public String getDeptCreatedDatetime() {
		return deptCreatedDatetime;
	}

	/**
	 * @param dept_created_datetime
	 *            the dept_created_datetime to set
	 */
	public void setDeptCreatedDatetime(String dept_created_datetime) {
		this.deptCreatedDatetime = dept_created_datetime;
	}

	/**
	 * @return the dept_created_name
	 */
	@Column(name = "dept_created_name", length = 11, nullable = false)
	public Integer getDeptCreatedName() {
		return deptCreatedName;
	}

	/**
	 * @param dept_created_name
	 *            the dept_created_name to set
	 */
	public void setDeptCreatedName(Integer dept_created_name) {
		this.deptCreatedName = dept_created_name;
	}

	/**
	 * @return the dept_updated_datetime
	 */
	@Column(name = "dept_updated_datetime", length = 50,nullable=false)
	public String getDeptUpdatedDatetime() {
		return deptUpdatedDatetime;
	}

	/**
	 * @param dept_updated_datetime
	 *            the dept_updated_datetime to set
	 */
	public void setDeptUpdatedDatetime(String dept_updated_datetime) {
		this.deptUpdatedDatetime = dept_updated_datetime;
	}

	/**
	 * @return the dept_updated_name
	 */
	@Column(name = "dept_updated_name", length = 11,nullable=false)
	public Integer getDeptUpdatedName() {
		return deptUpdatedName;
	}

	/**
	 * @param dept_updated_name
	 *            the dept_updated_name to set
	 */
	public void setDeptUpdatedName(Integer dept_updated_name) {
		this.deptUpdatedName = dept_updated_name;
	}

	/**
	 * @return the dept_default1
	 */
	@Column(name = "dept_default1", length = 50)
	public String getDeptDefault1() {
		return deptDefault1;
	}

	/**
	 * @param dept_default1
	 *            the dept_default1 to set
	 */
	public void setDeptDefault1(String dept_default1) {
		this.deptDefault1 = dept_default1;
	}

	/**
	 * @return the dept_default2
	 */
	@Column(name = "dept_default2", length = 50)
	public String getDeptDefault2() {
		return deptDefault2;
	}

	/**
	 * @param dept_default2
	 *            the dept_default2 to set
	 */
	public void setDeptDefault2(String dept_default2) {
		this.deptDefault2 = dept_default2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptParentId=" + deptParentId
				+ ", deptAb=" + deptAb + ", deptSortId=" + deptSortId + ", deptNlevel=" + deptNlevel
				+ ", deptCreatedDatetime=" + deptCreatedDatetime + ", deptCreatedName=" + deptCreatedName
				+ ", deptUpdatedDatetime=" + deptUpdatedDatetime + ", deptUpdatedName=" + deptUpdatedName
				+ ", deptDefault1=" + deptDefault1 + ", deptDefault2=" + deptDefault2 + "]";
	}

}
