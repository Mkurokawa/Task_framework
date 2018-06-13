package jp.co.axiz.web.entity;

public class Login {
	private String admin_id;
	private String password;
	private String admin_name;

	//引数なしのコンストラクター
	public Login() {
	}

	//引数ありのコンストラクター
	public Login(String admin_id,String admin_name,String password) {
		super();
		this.admin_id =admin_id;
		this.admin_name=admin_name;
		this.password=password;	
	}	
	
	public void Admin_name(String admin_id,String password) {
		this.admin_id =admin_id;
		this.password=password;	
	}	

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
}