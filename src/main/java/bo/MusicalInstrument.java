package bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // Controlled by an Entity Manager
public class MusicalInstrument {
	@Id
	@GeneratedValue
	// Attributes
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "instrumentAge")
	private Integer instrumentAge;
	@Column(name = "owner")
	private String owner;
	
	// ToString Function
	@Override
	public String toString() {
		return "MusicalInstrument [id=" + id + ", name=" + name + ", instrumentAge=" + instrumentAge + ", owner=" + owner + "]";
	}
	
	// Getters & Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getInstrumentAge() {
		return instrumentAge;
	}
	public void setInstrumentAge(Integer instrumentAge) {
		this.instrumentAge = instrumentAge;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
