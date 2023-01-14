package de.telran.todojpa.repository;

import de.telran.todojpa.model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
