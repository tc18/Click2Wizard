package cre_tbl;

public class cre_tbl_vo {
	
	private static String pro_name;
	private static String tbl_name;

	public static String getTbl_name() {
		return tbl_name;
	}

	public static void setTbl_name(String tbl_name) {
		cre_tbl_vo.tbl_name = tbl_name;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	

}
