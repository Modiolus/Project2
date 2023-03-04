package hello.controller;

import hello.dto.Student;
import hello.dto.StudentCreate;
import hello.service.StudentGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    public static List<Student> list = StudentGenerator.studentList();

    @GetMapping("/ping")
    public String ping() {
        return "hello";
    }

    @GetMapping("/hello")
    public String helloTest(@RequestParam String name) {
        System.out.println("run end point hello with param name >> " + name);

        if (name.equals("vasya")) throw new RuntimeException();
        return "hello " + name;
    }

    @GetMapping("/students")
    public List<Student> students() {
        return list;
    }

    @GetMapping("student/{id}/{name}")
    Student getStudent(@PathVariable UUID id, @PathVariable String name) {

        return list.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
// создает по одному студенту
//    @PostMapping("student")
//    boolean createNewStudent(@RequestBody StudentCreate studentCreate) {
//        return list.add(new Student(UUID.randomUUID(), studentCreate.getFirstName(), studentCreate.getLastName()));
//    }
// создает несколько студентов т.к. лист
//    @PostMapping("students")
//    boolean createNewStudents(@RequestBody List<StudentCreate> studentCreate) {
//        studentCreate.forEach(s -> {
//            list.add(new Student(UUID.randomUUID(), s.getFirstName(), s.getLastName()));
//        });
//        return true;
//    }
//
//    @DeleteMapping("student")
//    void deleteStudent(@RequestParam String name) {
//        list = list.stream().filter(student -> !student.getFirstName().equals(name)).collect(Collectors.toList());
//    }
//
//    @PutMapping("student/{id}")
//    Student updateStudent(@PathVariable UUID id, @RequestParam(required = false) String fName, @RequestParam(required = false) String lName){
//        for (Student st : list) {
//            if (st.getId().equals(id)) {
//                if (Objects.nonNull(fName)) st.setFirstName(fName);
//                if (Objects.nonNull(lName)) st.setLastName(lName);
//                return st;
//            } else {
//                throw new RuntimeException();
//            }
//        }
//        return null;
//    }
}
