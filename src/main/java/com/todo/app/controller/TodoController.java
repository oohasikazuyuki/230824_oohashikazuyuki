package com.todo.app.controller;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.app.entity.Todo;
import com.todo.app.mapper.TodoMapper;

@Controller
public class TodoController {
	
	@Autowired
	TodoMapper todoMapper;
	
	@RequestMapping(value="/")
	public String index(Model model) {
//		List<Todo> list = todoMapper.selectAll();
		List<Category> categoryList = todoMapper.viewCategory();
		List<Todo> joinList = todoMapper.categoryTodo();
		List<Todo> list = todoMapper.selectIncomplete();
		List<Todo> doneList = todoMapper.selectComplete();
//		List<JoinTodo> joinTodoList = todoMapper.categoryTodo();
		model.addAttribute("todos",list);
		model.addAttribute("doneTodos",doneList);
		model.addAttribute("categoryTodos",categoryList);
		model.addAttribute("joinTodos",joinList);
//		model.addAttribute("joinTodo",joinTodoList);
		
		
		return "index";
	}
	
	
	
	@RequestMapping(value="/addCategory")
	public String addCategory(Category category) {
		todoMapper.addCategory(category);
		return "redirect:/";
	}
	
//	@RequestMapping(value="/viewByCategory")
//	public String viewByCategory(JoinTodo joinTodo) {
//		todoMapper.viewByCategory(joinTodo);
//		return "redirect:/";
//	}
	

	@RequestMapping(value="/add")
	public String add(Todo todo) {
		todoMapper.add(todo);
		return "redirect:/";	
	}
	
	@RequestMapping(value="/update")
	public String update(Todo todo) {
		todoMapper.update(todo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete")
	public String delete() {
		todoMapper.delete();
		return "redirect:/";
	}
}
