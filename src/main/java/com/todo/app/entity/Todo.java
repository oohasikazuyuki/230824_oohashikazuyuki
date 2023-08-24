package com.todo.app.entity;

import lombok.Data;
@Data
public class Todo {

	
	private long id;
	private String title;
	private int done_flg;
	private String time_limit;



public Long getId() {
    return id;
	}
public void setId(Long id) {
    this.id = id;
	}
}