package com.example.CRMProject.task.repository;

import com.example.CRMProject.company.Company;
import com.example.CRMProject.contact.model.Contact;
import com.example.CRMProject.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TaskRepository {

    List<Task> findAll();

    Task findByExecutor(String executor, Company company);

    Task findByCompany(Company company);

    Task findByContact(Contact contact);

    void save(Task task);

    void update(Long id, Task updatedTask);

    List<Task> findByName(String name);
    void delete(Long id);

}
