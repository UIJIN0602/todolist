package bitc.fullstack503.todolist.Controller;


import bitc.fullstack503.todolist.dto.TodoDTO;
import bitc.fullstack503.todolist.service.TodoService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/todolist")
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;




    // 게시물 목록
    // 기존의 @RequestMapping 사용 방법에서 URI 를 입력했던 부분을 value 속성으로 변경
    // 해당 URI 와 통신 하는 방식을 method 속성을 통해서 지정할 수 있음
    @GetMapping("/selectTodo") // 간결하게 GET 방식 지정
    public List<TodoDTO> selectTodoList() throws Exception {

        List<TodoDTO> todolist =todoService.selectTodoList();
        return todolist;
    }

    // 클라이언트가 접근하는 URL이 동일하더라도 method 타입이 다르면 서로 다른 URL로 인식하기 때문에 동일한 URL을 사용할 수 있음

    // 게시물 등록 처리
    // @PostMapping : 클라이언트에서 데이터 전송 방식을 POST로 설정한 URL만 접속
    // @RequestMapping(method = RequestMethod.POST) 과 동일한 방식
    @PostMapping("/insertTodo")
    public String insertTodo(@RequestBody TodoDTO todo) throws Exception {
        todoService.insertTodo(todo);

        return "success";
    }


    // 게시물 수정
    // @PutMapping : 클라이언트에서 데이터 전송 방식을 PUT으로 설정한 URL만 접속
    // @RequestMapping(method = RequestMethod.PUT) 과 동일한 방식
    @PutMapping("/updateTodo/{todoIdx}")
    public void updateTodo(@PathVariable int todoIdx, @RequestBody TodoDTO todo) {
        todo.setTodoIdx(todoIdx);
        todoService.updateTodo(todo);
    }


    // 게시물 삭제
    // @DeleteMapping : 클라이언트에서 데이터 전송 방식을 DELETE 로 설정한 URL만 접속
    // @RequestMapping(method = RequestMethod.DELETE) 과 동일한 방식
    @DeleteMapping("/deleteTodo/{todoIdx}")
    public String deleteBoard(@PathVariable("todoIdx") int todoIdx) throws Exception{
        todoService.deleteTodo(todoIdx);
        return "todo/todoList";
    }

//    // 완료된 Todo 항목만 조회
//    @GetMapping("/selectCompletedTodo")
//    public List<TodoDTO> selectCompletedTodoList() throws Exception {
//        return todoService.selectCompletedTodoList(); // 서비스에서 완료된 항목만 조회
//    }






}
