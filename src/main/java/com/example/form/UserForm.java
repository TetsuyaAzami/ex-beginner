package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserForm {
	@NotBlank
	private String name;
	@Pattern(regexp = "^[0-9]+$", message = "整数を入れてください")
	private String age;
	@NotBlank
	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "UserForm [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}

}
