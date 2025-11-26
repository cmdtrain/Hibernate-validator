package org.example.todo;

import org.example.todo.repository.HibernateUtil;
import org.example.todo.service.StateService;
import org.example.todo.service.TaskService;
import org.example.todo.service.ToDoService;
import org.example.todo.service.TodoCollaboratorService;
import org.example.todo.service.UserService;
import org.example.todo.service.impl.StateServiceImpl;
import org.example.todo.service.impl.TaskServiceImpl;
import org.example.todo.service.impl.ToDoServiceImpl;
import org.example.todo.service.impl.TodoCollaboratorServiceImpl;
import org.example.todo.service.impl.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServiceRepositoryTests {

    private static SessionFactory sessionFactory;
    private static UserService userService;
    private static StateService stateService;
    private static ToDoService toDoService;
    private static TaskService taskService;
    private static TodoCollaboratorService collaboratorService;

    @BeforeAll
    static void init() {
        sessionFactory = HibernateUtil.getSessionFactory();
        userService = new UserServiceImpl();
        stateService = new StateServiceImpl();
        toDoService = new ToDoServiceImpl();
        taskService = new TaskServiceImpl();
        collaboratorService = new TodoCollaboratorServiceImpl();
    }

    @Test
    void userServiceCreatesAndFindsUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("Strong1!a");
        user.setRole("USER");
        User saved = userService.create(user);
        Assertions.assertNotNull(saved.getId());
        User byEmail = userService.getByEmail("john.doe@example.com");
        Assertions.assertNotNull(byEmail);
        Assertions.assertEquals(saved.getId(), byEmail.getId());
        User byId = userService.getById(saved.getId());
        Assertions.assertEquals("John", byId.getFirstName());
    }

    @Test
    void toDoAndTaskServicesWorkTogether() {
        User owner = new User();
        owner.setFirstName("Alice");
        owner.setLastName("Smith");
        owner.setEmail("alice.smith@example.com");
        owner.setPassword("Password1!");
        owner.setRole("USER");
        owner = userService.create(owner);

        State state = new State();
        state.setName("OPEN");
        state = stateService.create(state);

        ToDo toDo = new ToDo();
        toDo.setTitle("Sample todo");
        toDo.setOwner(owner);
        toDo = toDoService.create(toDo);

        Task task = new Task();
        task.setName("First task");
        task.setPriority("HIGH");
        task.setTodo(toDo);
        task.setState(state);
        task = taskService.create(task);

        Task fromDb = taskService.getById(task.getId());
        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals("First task", fromDb.getName());

        List<Task> tasks = taskService.getAll();
        Assertions.assertFalse(tasks.isEmpty());
    }

    @Test
    void collaboratorServiceCreatesAndReadsCollaborator() {
        User owner = new User();
        owner.setFirstName("Bob");
        owner.setLastName("Brown");
        owner.setEmail("bob.brown@example.com");
        owner.setPassword("StrongPass1!");
        owner.setRole("OWNER");
        owner = userService.create(owner);

        User collaboratorUser = new User();
        collaboratorUser.setFirstName("Charlie");
        collaboratorUser.setLastName("Green");
        collaboratorUser.setEmail("charlie.green@example.com");
        collaboratorUser.setPassword("PassWord2@");
        collaboratorUser.setRole("COLLABORATOR");
        collaboratorUser = userService.create(collaboratorUser);

        State state = new State();
        state.setName("IN_PROGRESS");
        state = stateService.create(state);

        ToDo toDo = new ToDo();
        toDo.setTitle("Collaboration todo");
        toDo.setOwner(owner);
        toDo = toDoService.create(toDo);

        TodoCollaborator collaborator = new TodoCollaborator();
        collaborator.setTodo(toDo);
        collaborator.setCollaborator(collaboratorUser);
        collaborator.setState(state);
        collaborator = collaboratorService.create(collaborator);

        TodoCollaboratorId id = new TodoCollaboratorId(toDo.getId(), collaboratorUser.getId());
        TodoCollaborator fromDb = collaboratorService.getById(id);
        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(toDo.getId(), fromDb.getTodo().getId());
        Assertions.assertEquals(collaboratorUser.getId(), fromDb.getCollaborator().getId());
    }
}
