package model;

public class Student {
	private String name;
	private String cpf;
	
	public Student(String name, String cpf) {
		super();
		this.name = name;
		this.cpf = cpf;
	}
	
	public Student() {
		super();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}