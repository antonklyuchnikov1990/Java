package de.telran.todojpa.controller;

import de.telran.todojpa.model.ToDo;
import de.telran.todojpa.repository.ToDoRepository;
import de.telran.todojpa.validation.ToDoValidationError;
import de.telran.todojpa.validation.ToDoValidationErrorBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private final ToDoRepository repository;

    @Autowired
    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")        // get (.../api/todos)
    public ResponseEntity<Iterable<ToDo>> getToDos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        Optional<ToDo> toDo = repository.findById(id);
        if (toDo.isPresent()) {
            return ResponseEntity.ok(toDo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todo")
    public ResponseEntity<ToDo> getToDoById2(@RequestParam Long id) {
        Optional<ToDo> toDo = repository.findById(id);
        if (toDo.isPresent()) {
            return ResponseEntity.ok(toDo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/todo", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> createTodo(@Valid @RequestBody ToDo toDo, Errors errors) {
        if (errors.hasErrors()) {
            // Имеются ошибки валидации
            return ResponseEntity.badRequest().body(ToDoValidationErrorBuilder.fromBindingErrors(errors));
        }
        ToDo result = repository.save(toDo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable Long id) {
        Optional<ToDo> optionalToDo = repository.findById(id);
        if (optionalToDo.isEmpty()) {
            // ToDo с таким id нет в базе данных
            return ResponseEntity.notFound().build();
        }
        repository.delete(optionalToDo.get());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/todo")
    public ResponseEntity<?> deleteToDo(@RequestBody ToDo toDo) {
        Optional<ToDo> optionalToDo = repository.findById(toDo.getId());
        if (optionalToDo.isEmpty()) {
            // ToDo с таким id нет в базе данных
            return ResponseEntity.notFound().build();
        }
        repository.delete(optionalToDo.get());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ToDoValidationError handleException(Exception exception) {
        return new ToDoValidationError((exception.getMessage()));
    }

}
