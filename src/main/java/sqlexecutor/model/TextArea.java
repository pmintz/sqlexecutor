package sqlexecutor.model;

import javax.xml.bind.annotation.XmlRootElement;


public class TextArea {
	
	private String textArea;
	
	public TextArea() {}
	
	public TextArea(String textArea) {
		this.textArea = textArea;
	}

	public String getTextArea() {
		return textArea;
	}

	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}
	
	

}
