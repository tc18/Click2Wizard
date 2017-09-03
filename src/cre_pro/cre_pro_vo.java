package cre_pro;

import java.io.Serializable;

public class cre_pro_vo implements Serializable {
	
	private String pro_name;
	private String data;
	
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
