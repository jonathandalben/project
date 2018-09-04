package app.dto;

public class UserInfoDto {
	private String lastName;
	private String firstName;
	private String middleName;
	private String company;
	private String motto;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	@Override
	public String toString() {
		return "UserInfoDto [lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", company=" + company + ", motto=" + motto + "]";
	}
}
