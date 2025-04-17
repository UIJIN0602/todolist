package bitc.fullstack503.todolist.service;

import bitc.fullstack503.todolist.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void insertTodo(TodoDTO todo);


    void deleteTodo(int todoIdx);

    List<TodoDTO> selectTodoList();

    void updateTodo(TodoDTO todo);
}
