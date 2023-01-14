package de.telrun.todo;

import de.telrun.todo.model.ToDo;
import de.telrun.todo.model.ToDoBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);

	}

}
