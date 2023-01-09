package entities;

import javax.xml.bind.annotation.XmlElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entité enregistré dans swagger")
public class Employee  { 
	private String cin;
	private String firstName;
	private String lastName;
	public Employee() {}
	public Employee(String cin, String firstName, String lastName) {
		super();
		this.cin = cin;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@ApiModelProperty(value ="unique cin")
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}

	@XmlElement(name="FirstName")
	@ApiModelProperty(value ="get prenom")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@XmlElement(name="LastName")
	@ApiModelProperty(value ="get nom")

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
