package coe;

public class Employee {
private String employee_id;
private String first_name;
private String last_name;
private String email_id;
private String password;
private String mobile_no;

public Employee(String employee_id, String first_name, String last_name, String email_id, String password,
		String mobile_no) {
	super();
	this.employee_id = employee_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.email_id = email_id;
	this.password = password;
	this.mobile_no = mobile_no;
}
public String getEmployee_id() {
	return employee_id;
}
public String getFirst_name() {
	return first_name;
}
public String getLast_name() {
	return last_name;
}
public String getEmail_id() {
	return email_id;
}
public String getPassword() {
	return password;
}
public String getMobile_no() {
	return mobile_no;
}
public void setEmployee_id(String employee_id) {
	this.employee_id = employee_id;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public void setPassword(String password) {
	this.password = password;
}
public void setMobile_no(String mobile_no) {
	this.mobile_no = mobile_no;
}

}
