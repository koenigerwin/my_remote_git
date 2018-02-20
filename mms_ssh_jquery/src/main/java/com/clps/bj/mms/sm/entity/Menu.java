/**
 * 
 */
package com.clps.bj.mms.sm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @description:	菜单实体类  
 * @ClassName:Menu
 * @author  gg Yang
 * @version: V1.1 
 * @Date:     2017年12月22日 20:30:21
 * 	 
 */


@Entity
@Table(name="menu")
public class Menu implements Serializable,Comparable<Menu>{
	private static final long serialVersionUID = 7262555704187036530L; // 序列化id
	
	private Integer menuId; // 菜单编号
	private String menuName; // 菜单名称
	private String menuUrl; // 菜单url
	private String menuIcon; // 菜单图标
	private String menuParent; // 菜单父级菜单
	private String menuSortId; // 菜单排序号
	private Integer menuNlevel; // 菜单层级

	private String menuDescription; // 菜单描述
	private String menuStatus; // 菜单状态
	private String menuCreatedDatetime; // 创建时间
	private Integer menuCreatedId; // 创建人名
	private String menuUpdatedDatetime; // 修改时间
	private Integer menuUpdatedId; // 修改人名
	private String menuSortNum; // 菜单的排序号
	private String menuDefault2; // 默认字段2 
	
	
	
	private Set<MenuPermission> menuPmsn  = new HashSet<>();
	
	public Menu() {
		super();
	}
	
	
	
	/**
	 * @return the menuSortNum
	 */
	@Column(name="menu_sort_num",length=50,nullable=false)
	public final String getMenuSortNum() {
		return menuSortNum;
	}



	/**
	 * @param menuSortNum the menuSortNum to set
	 */
	public final void setMenuSortNum(String menuSortNum) {
		this.menuSortNum = menuSortNum;
	}



	/**
	 * @return the menu_id
	 */
	@Id
	@GenericGenerator(name="generator",strategy="increment")   //设置主键自增
	@GeneratedValue(generator="generator")
	@Column(name="menu_id",length=11)
	public final Integer getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menu_id to set
	 */
	public final void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	
	
	
	
	/**
	 * @return the menuPmsn
	 */
	@OneToMany(mappedBy="menu",targetEntity=MenuPermission.class,cascade=CascadeType.ALL)
	public final Set<MenuPermission> getMenuPmsn() {
		return menuPmsn;
	}

	/**
	 * @param menuPmsn the menuPmsn to set
	 */
	public final void setMenuPmsn(Set<MenuPermission> menuPmsn) {
		this.menuPmsn = menuPmsn;
	}

	/**
	 * @return the menu_name
	 */
	@Column(name="menu_name",length=50,nullable=false,unique=false)
	public final String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menu_name to set
	 */
	public final void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * @return the menu_url
	 */
	@Column(name="menu_url",length=100,nullable=false,unique=true)
	public final String getMenuUrl() {
		return menuUrl;
	}
	/**
	 * @param menuUrl the menu_url to set
	 */
	
	public final void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	/**
	 * @return the menu_icon
	 */
	@Column(name="menu_icon",length=50)
	public final String getMenuIcon() {
		return menuIcon;
	}
	/**
	 * @param menuIcon the menu_icon to set
	 */
	public final void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	/**
	 * @return the menu_parent
	 */
	@Column(name="menu_parent",length=11,unique=false)
	public final String getMenuParent() {
		return menuParent;
	}
	/**
	 * @param menuParent the menu_parent to set
	 */
	public final void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}
	/**
	 * @return the menu_sort_id
	 */
	@Column(name="menu_sort_id",length=100,nullable=false,unique=true)
	public final String getMenuSortId() {
		return menuSortId;
	}
	/**
	 * @param menuSortId the menu_sort_id to set
	 */
	public final void setMenuSortId(String menuSortId) {
		this.menuSortId = menuSortId;
	}
	/**
	 * @return the menu_nlevel
	 */
	@Column(name="menu_nlevel",length=11,nullable=false,unique=false)
	public final Integer getMenuNlevel() {
		return menuNlevel;
	}
	/**
	 * @param menuNlevel the menu_nlevel to set
	 */
	public final void setMenuNlevel(Integer menuNlevel) {
		this.menuNlevel = menuNlevel;
	}
	/**
	 * @return the menu_description
	 */
	@Column(name="menu_description",length=200)
	public final String getMenuDescription() {
		return menuDescription;
	}
	/**
	 * @param menuDescription the menu_description to set
	 */
	public final void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	/**
	 * @return the menu_is_enable
	 */
	@Column(name="menu_status",length=2,nullable=false,unique=false)
	public final String getMenuStatus() {
		return menuStatus;
	}
	/**
	 * @param menuStatus the menu_is_enable to set
	 */
	public final void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	/**
	 * @return the menu_created_Datetime
	 */
	@Column(name="menu_created_datetime",length=50,nullable=false)
	public final String getMenuCreatedDatetime() {
		return menuCreatedDatetime;
	}
	/**
	 * @param menu_createdDatetime the menu_created_Datetime to set
	 */
	public final void setMenuCreatedDatetime(String menu_createdDatetime) {
		this.menuCreatedDatetime = menu_createdDatetime;
	}
	/**
	 * @return the menu_created_name
	 */
	@Column(name="menu_created_id",length=50,nullable=false)
	public final Integer getMenuCreatedId() {
		return menuCreatedId;
	}
	/**
	 * @param menuCreatedId the menu_created_name to set
	 */
	public final void setMenuCreatedId(Integer menuCreatedId) {
		this.menuCreatedId = menuCreatedId;
	}
	/**
	 * @return the menu_update_Datetime
	 */
	@Column(name="menu_updated_datetime",length=50,nullable=false)
	public final String getMenuUpdatedDatetime() {
		return menuUpdatedDatetime;
	}
	/**
	 * @param menuUpdatDatetime the menu_update_Datetime to set
	 */
	public final void setMenuUpdatedDatetime(String menuUpdatDatetime) {
		this.menuUpdatedDatetime = menuUpdatDatetime;
	}
	/**
	 * @return the menu_update_name
	 */
	@Column(name="menu_updated_id",length=50,nullable=false)
	public final Integer getMenuUpdatedId() {
		return menuUpdatedId;
	}
	/**
	 * @param menuUpdatedId the menu_update_name to set
	 */
	public final void setMenuUpdatedId(Integer menuUpdatedId) {
		this.menuUpdatedId = menuUpdatedId;
	}
	
	/**
	 * @return the menu_default2
	 */
	@Column(name="menu_default2",length=50)
	public final String getMenuDefault2() {
		return menuDefault2;
	}
	/**
	 * @param menuDefault2 the menu_default2 to set
	 */
	public final void setMenuDefault2(String menuDefault2) {
		this.menuDefault2 = menuDefault2;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Menu o) {
		//如果同级别
		int res = this.menuSortId.compareTo(o.getMenuSortId());
		if( res==0){
			//同级别，比较排序号
			res = this.menuSortNum.compareTo(o.getMenuSortNum());
		}
		return res;
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return menuName;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuCreatedDatetime == null) ? 0 : menuCreatedDatetime.hashCode());
		result = prime * result + ((menuCreatedId == null) ? 0 : menuCreatedId.hashCode());
		result = prime * result + ((menuDefault2 == null) ? 0 : menuDefault2.hashCode());
		result = prime * result + ((menuDescription == null) ? 0 : menuDescription.hashCode());
		result = prime * result + ((menuIcon == null) ? 0 : menuIcon.hashCode());
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + ((menuNlevel == null) ? 0 : menuNlevel.hashCode());
		result = prime * result + ((menuParent == null) ? 0 : menuParent.hashCode());
		result = prime * result + ((menuPmsn == null) ? 0 : menuPmsn.hashCode());
		result = prime * result + ((menuSortId == null) ? 0 : menuSortId.hashCode());
		result = prime * result + ((menuSortNum == null) ? 0 : menuSortNum.hashCode());
		result = prime * result + ((menuStatus == null) ? 0 : menuStatus.hashCode());
		result = prime * result + ((menuUpdatedDatetime == null) ? 0 : menuUpdatedDatetime.hashCode());
		result = prime * result + ((menuUpdatedId == null) ? 0 : menuUpdatedId.hashCode());
		result = prime * result + ((menuUrl == null) ? 0 : menuUrl.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (menuCreatedDatetime == null) {
			if (other.menuCreatedDatetime != null)
				return false;
		} else if (!menuCreatedDatetime.equals(other.menuCreatedDatetime))
			return false;
		if (menuCreatedId == null) {
			if (other.menuCreatedId != null)
				return false;
		} else if (!menuCreatedId.equals(other.menuCreatedId))
			return false;
		if (menuDefault2 == null) {
			if (other.menuDefault2 != null)
				return false;
		} else if (!menuDefault2.equals(other.menuDefault2))
			return false;
		if (menuDescription == null) {
			if (other.menuDescription != null)
				return false;
		} else if (!menuDescription.equals(other.menuDescription))
			return false;
		if (menuIcon == null) {
			if (other.menuIcon != null)
				return false;
		} else if (!menuIcon.equals(other.menuIcon))
			return false;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (menuNlevel == null) {
			if (other.menuNlevel != null)
				return false;
		} else if (!menuNlevel.equals(other.menuNlevel))
			return false;
		if (menuParent == null) {
			if (other.menuParent != null)
				return false;
		} else if (!menuParent.equals(other.menuParent))
			return false;
		if (menuPmsn == null) {
			if (other.menuPmsn != null)
				return false;
		} else if (!menuPmsn.equals(other.menuPmsn))
			return false;
		if (menuSortId == null) {
			if (other.menuSortId != null)
				return false;
		} else if (!menuSortId.equals(other.menuSortId))
			return false;
		if (menuSortNum == null) {
			if (other.menuSortNum != null)
				return false;
		} else if (!menuSortNum.equals(other.menuSortNum))
			return false;
		if (menuStatus == null) {
			if (other.menuStatus != null)
				return false;
		} else if (!menuStatus.equals(other.menuStatus))
			return false;
		if (menuUpdatedDatetime == null) {
			if (other.menuUpdatedDatetime != null)
				return false;
		} else if (!menuUpdatedDatetime.equals(other.menuUpdatedDatetime))
			return false;
		if (menuUpdatedId == null) {
			if (other.menuUpdatedId != null)
				return false;
		} else if (!menuUpdatedId.equals(other.menuUpdatedId))
			return false;
		if (menuUrl == null) {
			if (other.menuUrl != null)
				return false;
		} else if (!menuUrl.equals(other.menuUrl))
			return false;
		return true;
	}

	

	
	

}
