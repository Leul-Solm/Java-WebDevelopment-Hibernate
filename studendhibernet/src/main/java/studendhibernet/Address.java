package studendhibernet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//define the column
	@Column(name="STUDENT_CITY")
	private String city;
	@Column(name="STUDENT_SUBCITY")
	private String subcity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSubcity() {
		return subcity;
	}
	public void setSubcity(String subcity) {
		this.subcity = subcity;
	}

	
}
