package bitc.fullstack503.todolist.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private int todoIdx;
    private String todoContent;
    private String todoWriteDate;
    private String todoDeletedYn;

}
