package org.superklamer.javabrains.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessge;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage() {
		
	}

	public ErrorMessage(String errorMessge, int errorCode, String documentation) {
		super();
		this.errorMessge = errorMessge;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	public String getErrorMessge() {
		return errorMessge;
	}
	public void setErrorMessge(String errorMessge) {
		this.errorMessge = errorMessge;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	
	
}
