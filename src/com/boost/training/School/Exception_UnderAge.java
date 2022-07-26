package com.boost.training.School;

public class Exception_UnderAge extends RuntimeException {

	String textString;

	public Exception_UnderAge(String textString) {
		super();
		this.textString = textString;
	}

	public Exception_UnderAge() {
		super();
	}

	public String getTextString() {
		return textString;
	}

	public void setTextString(String textString) {
		this.textString = textString;
	}

	@Override
	public String getMessage() {
		return textString;
	}

}
