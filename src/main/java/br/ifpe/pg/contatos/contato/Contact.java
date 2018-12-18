package br.ifpe.pg.contatos.contato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Contact {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Column(length=50)
	private String firstName;
	@NotBlank @Column(length=50)
	private String name;
	@NotBlank @Column(length=150)
	private String email;
	@NotBlank @Column(length=50)
	private String phone;
	
	public Contact() {
		super();
	}
	public Contact(Long id, String firstName, String name, String email, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
