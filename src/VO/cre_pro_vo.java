package VO;

import java.io.Serializable;

public class cre_pro_vo implements Serializable {
	
	private String pro_name;
	private String tbl_name;
	private String field_name;
	private String type;
	private int size;
	private String data;
	
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	
	public String getTbl_name() {
		return tbl_name;
	}
	public void setTbl_name(String tbl_name) {
		this.tbl_name = tbl_name;
	}
	
	public String getField_name() {
		return field_name;
	}
	
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
