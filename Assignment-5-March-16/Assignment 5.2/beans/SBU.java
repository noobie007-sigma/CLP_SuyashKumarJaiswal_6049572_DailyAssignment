package cg.demos.springcore_assignments.beans;

public class SBU {
	private int sbuId;
	private String sbuName;
	private String sbuHead;
	public SBU(int sbuId, String sbuName, String sbuHead) {
		super();
		this.sbuId = sbuId;
		this.sbuName = sbuName;
		this.sbuHead = sbuHead;
	}
	
	public int getSbuId() {
		return sbuId;
	}

	public void setSbuId(int sbuId) {
		this.sbuId = sbuId;
	}

	public String getSbuName() {
		return sbuName;
	}

	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}

	public String getSbuHead() {
		return sbuHead;
	}

	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}

	
	public String getSbuDetails() {
		return "SBU Details\n ---------------------- \n SBU ID:" + sbuId + "\n SBU Name: " + sbuName + "\n SBU Head: " + sbuHead;
	}
	
}
