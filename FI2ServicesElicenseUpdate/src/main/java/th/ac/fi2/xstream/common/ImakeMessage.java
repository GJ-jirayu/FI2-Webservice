package th.ac.fi2.xstream.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;


@XStreamAlias("ResearchMessage")
public class ImakeMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	@XStreamAlias("msgCode")
	private String msgCode;
	
	@XStreamAlias("msgDesc")
	private String msgDesc;
	
	private Exception exception;
	
	public ImakeMessage(){
	}

	public ImakeMessage(String msgCode){
		this.setMsgCode(msgCode);
	}

	public ImakeMessage(String msgCode, String msgDesc){
		this.msgCode = msgCode;
		this.msgDesc = msgDesc;
	}

	public ImakeMessage(String msgCode, Exception exception){
		this.setMsgCode(msgCode);
		this.setException(exception);
	}

	public ImakeMessage(String msgCode, String msgDesc, Exception exception){
		this.msgCode = msgCode;
		this.msgDesc = msgDesc;
		this.setException(exception);
	}
	
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
		
	}
	public String getMsgDesc() {
		return msgDesc;
	}
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
}	
