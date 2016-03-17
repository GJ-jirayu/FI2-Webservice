package th.ac.fi2.exception;

public class ImakeException extends Exception{

	/**
	 * 
	 */
	private String errCode;
	private String errMsg;

	private static final long serialVersionUID = 5207556899514569598L;

	public ImakeException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
