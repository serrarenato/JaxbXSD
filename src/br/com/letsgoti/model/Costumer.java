package br.com.letsgoti.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Costumer")
@XmlType(propOrder = { "firstName", "lastName", "sex", "email", "dateBorn", "phones"  })
public class Costumer {
	
	private String firstName;	 
	private String lastName;
	private String sex;	 	   
	private Date dateBorn;	 
	private String email;	

	private List <Phone> phones;
	private int id;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getDateBorn() {
		return dateBorn;
	}
	public void setDateBorn(Date dateBorn) {
		this.dateBorn = dateBorn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElementWrapper(name = "Phones")
	@XmlElement(name = "Phone")
	public List <Phone> getPhones() {
		return phones;
	}
	public void setPhones(List <Phone> phones) {
		this.phones = phones;
	}
	@XmlAttribute(name = "idCostumer")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
