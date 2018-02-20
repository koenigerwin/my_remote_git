package com.clps.bj.mms.sm.vo;
/**
 *@Description：TODO
 *@className：IdText
 *@author bai
 *@version
 *@date 2018年2月5日 下午2:37:13
*/
public class UUIdText {
	private String id;
	private String text;
	/**
	 * 
	 */
	public UUIdText() {
		super();
	}
	
	
	
	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}



	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UUIdText other = (UUIdText) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
