package com.example.Todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

// RestController is Deserialization and serialization of data json<----> JAVA Object
@RequestMapping("/api")
public class TodoController {

    private  static List<Todo> todoList;

    public TodoController(){
        todoList = new ArrayList<>();
        todoList.add(new Todo(1,false,"learn",2114));
        todoList.add(new Todo(2,true,"gitHub",211));
    }
    @GetMapping("/")
    public String syaHello(){
        return "hello Jiii";
    }
    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todoList;
    }
    @PostMapping("/todos")

    //1.@RequestBody indicate this data of  http request body  is pass as paramter in Mehtod

    // 2.  Deserialization Data into Java Object here is Todo obj
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        /*
        * 1. we use @ResponseStatus(HttpStatus.CREATED) This Annotation to Set Status of Request
        * 2. methology to set the Status of Request is Response Entity Class which us to DO work Manualy
        * */
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);

        //meaning of this Is
        /*
        * Response Entity Class Called it function Status
        * Using Http Class created Status and pass it in Status() method
        * then pass Data inside the body of Response 
        * */


    }

}

