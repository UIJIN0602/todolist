package bitc.fullstack503.todolist.service;

import bitc.fullstack503.todolist.dto.TodoDTO;
import bitc.fullstack503.todolist.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoMapper todoMapper;


//    글 등록
    @Override
    public void insertTodo(TodoDTO todo) {
        todoMapper.insertTodo(todo);
    }

//    글 삭제
    @Override
    public void deleteTodo(int todoIdx) {
        todoMapper.deleteTodo(todoIdx);
    }

//    글 조회
    @Override
    public List<TodoDTO> selectTodoList() {
        return todoMapper.selectTodoList();
    }

//    글 수정
    @Override
    public void updateTodo(TodoDTO todo) {
        todoMapper.updateTodo(todo);
    }

//    @Override
//    public List<TodoDTO> selectCompletedTodoList() {
//        return todoMapper.selectCompletedTodoList();
//    }
}
