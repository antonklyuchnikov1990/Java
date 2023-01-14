package de.telrun.todo.controller;

import de.telrun.todo.model.ToDo;
import de.telrun.todo.repository.CommonRepository;
import de.telrun.todo.validation.ToDoValidationError;
import de.telrun.todo.validation.ToDoValidationErrorBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private CommonRepository<ToDo> repository;

    @Autowired
    public ToDoController(CommonRepository<ToDo> repository) {
        this.repository = repository;
    }

    @GetMapping("/todo")    // get (.../api/todo)
    public ResponseEntity<Iterable<ToDo>> getToDos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDo> getToDos(@PathVariable String id) {
        return ResponseEntity.ok(repository.findById(id));
    }

//    @PostMapping("/todo")
//    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
//        ToDo result = repository.save(toDo);
//        return ResponseEntity.ok(result);
//    }

    @RequestMapping(value = "/todo", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> createToDo(@Valid @RequestBody ToDo toDo, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ToDoValidationErrorBuilder.fromBindingErrors(errors));
        }
        ToDo result = repository.save(toDo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PutMapping("/todo/{id}")
//    public ResponseEntity<ToDo> modifyToDo(@RequestBody ToDo toDo) {
//        ToDo result = repository.save(toDo);
//        return ResponseEntity.ok(result);
//    }

//    @DeleteMapping("/todo/{id}")
//    public ResponseEntity<ToDo> deleteToDo(@PathVariable String id) {
//        repository.delete(id);
//        return ResponseEntity.ok(repository.findById(id));
//    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable String id) {
        ToDo dataBaseToDo = repository.findById(id);
        if (dataBaseToDo == null) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(dataBaseToDo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/todo")
    public ResponseEntity<?> deleteToDo(@RequestBody ToDo toDo) {
        ToDo dataBaseToDo = repository.findById(toDo.getId());
        if (dataBaseToDo == null) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(dataBaseToDo);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/todo/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable String id) {
        repository.update(id);
        return ResponseEntity.ok(repository.findById(id));
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ToDoValidationError handleException(Exception exception) {
        return new ToDoValidationError(exception.getMessage());
    }
}
