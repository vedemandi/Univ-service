package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/students")
public class StudentsController {
    private static Map<String,Student> myStudents = new HashMap<>();

   @GetMapping("/test")
    public String getStudentName(){
       return "xyaaa" ;
    }

    @GetMapping("/")
    public String getStudentName1(){
        return "default" ;
    }

    @GetMapping("/{name}")
    public  ResponseEntity<?> getStudentName4(@PathVariable("name") String name ){
        if(!myStudents.containsKey(name)){
            // throw error
            //  throws StudentAlreadyExistsException("already exists");
            ResponseEntity<?> res = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMyError("doesn't exists" +name, ""));
            return res;

        }else {
            return ResponseEntity.ok(myStudents.get(name));

        }

    }
    @GetMapping("/random/{name}")
    public String getStudentName2(@PathVariable("name") String name ){

        return "welcome : "+name ;
    }

    @PutMapping("/{name}")
    public ResponseEntity<?>  updateStudent(@PathVariable("name") String name, @RequestBody Student student ){
        if(!myStudents.containsKey(name)){
            // throw error
            //  throws StudentAlreadyExistsException("already exists");
            ResponseEntity<?> res = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMyError("doesn't exists" +name, ""));
            return res;

        }else {
            myStudents.put(name,student);

        }
        return ResponseEntity.ok(myStudents.get(student.getName()));
    }

    @GetMapping("/random/static")
    public String getStudentName3(){

        return "welcome : "+"static ";
    }

    @PostMapping("")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
         if(myStudents.containsKey(student.getName())){
             // throw error
           //  throws StudentAlreadyExistsException("already exists");
        ResponseEntity<?> res = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMyError("already exists", ""));
        return res;

         }else {
             myStudents.put(student.getName(),student);

         }
       return ResponseEntity.ok(myStudents.get(student.getName()));

    }


    private class ErrorMyError {
    private String msg;
    private String exceptionMsg;

        public ErrorMyError(String msg, String exceptionMsg) {
            this.msg = msg;
            this.exceptionMsg = exceptionMsg;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getExceptionMsg() {
            return exceptionMsg;
        }

        public void setExceptionMsg(String exceptionMsg) {
            this.exceptionMsg = exceptionMsg;
        }
    }
}
