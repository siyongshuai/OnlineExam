package haue.edu.cn.model;

public class AjaxResult {

	private String success="success";
	
	private String error="error";
	
	
	
	public String getSuccess() {
		return success;
	}



	public void setSuccess(String success) {
		this.success = success;
	}



	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}



	public static void main(String[] args) {
		AjaxResult ajaxResult=new AjaxResult();
		System.out.println(ajaxResult.getSuccess());
		System.out.println(ajaxResult.getError());
	}
}
