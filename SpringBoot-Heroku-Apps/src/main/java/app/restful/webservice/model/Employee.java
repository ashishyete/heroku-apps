package app.restful.webservice.model;

import java.util.List;

public class Employee {
	
	private int empId;
	private String empName;
	private String empDesg;
	private String empDetails;
	private List<EmpPhoneNum> empPhone;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	public String getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(String empDetails) {
		this.empDetails = empDetails;
	}
	public List<EmpPhoneNum> getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(List<EmpPhoneNum> empPhone) {
		this.empPhone = empPhone;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesg=" + empDesg + ", empDetails="
				+ empDetails + ", empPhone=" + empPhone + "]";
	}
	public Employee(int empId, String empName, String empDesg, String empDetails, List<EmpPhoneNum> empPhone) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesg = empDesg;
		this.empDetails = empDetails;
		this.empPhone = empPhone;
	}
	public Employee() {
		super();
	}
	
	

}
