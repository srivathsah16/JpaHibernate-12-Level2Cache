package com.srivath.entities;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employees")
@Cacheable
public class Employee {

	@Id
	@Column(name = "eId")
	private Integer id;
	@Column(name = "eName")
	private String name;
	@Column(name = "eDeptNo")
	private Integer deptNo;
	@Column(name = "eSal")
	private Double salary;
	
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
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptNo=" + deptNo + ", salary=" + salary + "]";
	}
	
	
}
