package util;

public class CheckboxListItem {
	private String label;
	private boolean isSelected = false;
	private boolean isEnabled = false;

	public CheckboxListItem(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
	
	public void setLabel(String label){
		this.label = label;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String toString() {
		return label;
	}
	
	public boolean isEnabled(){
		return isEnabled;
	}
	
	public void setEnabled(boolean isEnabled){
		this.isEnabled = isEnabled;
	}
}
