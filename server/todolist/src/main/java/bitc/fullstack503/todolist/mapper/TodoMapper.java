package bitc.fullstack503.todolist.mapper;

import bitc.fullstack503.todolist.dto.TodoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TodoMapper {

    void insertTodo(TodoDTO todo);

    void deleteTodo(int todoIdx);

    List<TodoDTO> selectTodoList();

    void updateTodo(TodoDTO todo);

    List<TodoDTO> selectCompletedTodoList();
}
