package com.boost.training.School;

public class Exception_Student extends RuntimeException {

	String textString;

	public Exception_Student(String textString) {
		super();
		this.textString = textString;
	}

	public Exception_Student() {
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
