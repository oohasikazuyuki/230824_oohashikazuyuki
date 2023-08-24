package com.todo.app.mapper;
import java.util.List;
import java.util.Locale.Category;

import org.apache.ibatis.annotations.Mapper;

import com.todo.app.entity.Todo;


@Mapper
public interface TodoMapper {
	public List<Todo> selectAll();
	
	public List<Todo> selectIncomplete();
	
	public List<Todo> selectComplete();
	
	public List<Category> viewCategory();
	
	public List<Todo> categoryTodo();
	
	public void addCategory(Category category);
	
	//public void viewByCategory(JoinTodo joinTodo);
	
	public void add(Todo todo);
	
	public void update(Todo todo);
	
	public void delete();

}