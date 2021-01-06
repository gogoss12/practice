package JH.home.Test.mvc.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int testNo;
	
	private String testGuid;
	
	private String testId;
	
	private String testPwd;
	
	private String testRoll;
	
	private String testName;
	
	private String phone;
	
	private String address;
	
	private String status;
	
	private Date enrollDate;
	
	private Date modifyDate;
	
	public Member() {
	};
	
	public Member(int testNo, String testGuid, String testId, String testPwd, String testRoll, String testName,
			String phone, String address, String status, Date enrollDate, Date modifyDate) {
		this.testNo = testNo;
		this.testGuid = testGuid;
		this.testId = testId;
		this.testPwd = testPwd;
		this.testRoll = testRoll;
		this.testName = testName;
		this.phone = phone;
		this.address = address;
		this.status = status;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
	}

	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public String getTestGuid() {
		return testGuid;
	}

	public void setTestGuid(String testGuid) {
		this.testGuid = testGuid;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestPwd() {
		return testPwd;
	}

	public void setTestPwd(String testPwd) {
		this.testPwd = testPwd;
	}

	public String getTestRoll() {
		return testRoll;
	}

	public void setTestRoll(String testRoll) {
		this.testRoll = testRoll;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Member [testNo=" + testNo + ", testGuid=" + testGuid + ", testId=" + testId + ", testPwd=" + testPwd
				+ ", testRoll=" + testRoll + ", testName=" + testName + ", phone=" + phone + ", address=" + address
				+ ", status=" + status + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + "]";
	};
	
};
