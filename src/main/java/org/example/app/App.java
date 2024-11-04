package org.example.app;

import org.example.app.config.AppConfig;
import org.example.app.controller.EmployeeController;
import org.example.app.entity.Employee;
import org.example.app.entity.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        onEmployeeUtil(context);
        onMessageUtil(context);
        context.close();

    }

    public static void onEmployeeUtil(AnnotationConfigApplicationContext context) {

        EmployeeController employeeController =
                context.getBean("getEmployeeController", EmployeeController.class);

        String employeeCreated1 =
                employeeController.create(new Employee("Alice", "Terra", "Computer Support Specialists", "38099-000-03-03"));
        getOutput("\n>> Employee 1 created: " + employeeCreated1);
        String employeeCreated2 =
                employeeController.create(new Employee("Tom", "Forest", "Chief Information Officer", "38099-000-03-03"));
        getOutput(">> Employee 2 created: " + employeeCreated2);
        String employeeCreated3 =
                employeeController.create(new Employee("Lucy", "Moon", "Software Engineer", "38099-000-01-02"));
        getOutput(">> Employee 3 created: " + employeeCreated3);

        String employeeDataList = employeeController.getAll();
        getOutput("\n>> Employee data list:\n" + employeeDataList);

        System.out.print("\n>> Input Employee id to find Employee by id: ");
        Long employeeId = scanner.nextLong();
        String employeeById = employeeController.getById(employeeId);
        getOutput("\n>> Employee by id: " + employeeById);

        System.out.print("\n>> Input Employee id to update Employee by id: ");
        Long employeeToUpdateId = scanner.nextLong();
        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setId(employeeToUpdateId);
        employeeToUpdate.setFirstName("Lucy");
        employeeToUpdate.setLastName("Sunny");
        employeeToUpdate.setPosition("Senior Staff Accountant");
        employeeToUpdate.setPhone("38099-111-22-33");
        String employeeUpdated = employeeController.update(employeeToUpdate);
        getOutput("\n>> Employee updated: " + employeeUpdated);

        String employeeDataList2 = employeeController.getAll();
        getOutput("\n>> Employee data list 2:\n" + employeeDataList2);

        System.out.print("\n>> Input Employee id to delete Employee by id: ");
        Long employeeToDeleteId = scanner.nextLong();
        String employeeDeleteResult = employeeController.deleteById(employeeToDeleteId);
        getOutput("\n>> Delete Employee by id result: " + employeeDeleteResult);

        String employeeDataList3 = employeeController.getAll();
        getOutput("\n>> Employee data list 3:\n" + employeeDataList3);
    }

    public static void onMessageUtil(AnnotationConfigApplicationContext context) {
        Message message = (Message) context.getBean("doMessage");
        String messageResult = message.getMessage();
        getOutput("\n>> Message: " + messageResult);
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}
