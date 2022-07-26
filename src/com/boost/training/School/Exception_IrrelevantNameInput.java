package com.boost.training.School;

public class Exception_IrrelevantNameInput extends RuntimeException {

	String textString;

	public Exception_IrrelevantNameInput() {
		super();
	}

	public Exception_IrrelevantNameInput(String textString) {
		super();
		this.textString = textString;
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
