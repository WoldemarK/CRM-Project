package com.example.CRMProject.task.service;


import com.example.CRMProject.company.Company;
import com.example.CRMProject.contact.model.Contact;
import com.example.CRMProject.model.Task;
import com.example.CRMProject.task.repository.TaskRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class TaskService implements TaskRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public TaskService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select t from Task t", Task.class).getResultList();
    }

    @Override
    public Task findByExecutor(String executor, Company company) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public Task findByCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public Task findByContact(Contact contact) {
        return null;
    }

    @Override
    @Transactional()
    public void save(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(task);
        findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public void update(Long id, Task updatedTask) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.get(Task.class,id);
        task.setId(updatedTask.getId());
        task.setName(updatedTask.getName());
        task.setExecutor(updatedTask.getExecutor());
        task.setCompanies(updatedTask.getCompanies());
        task.setContact(updatedTask.getContact());

    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select t from Task t where t.name like 'T%'", Task.class).getResultList();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Task.class, id));
        System.out.println("Задача с ID: " + id + " уделена");
        this.findAll();
    }
}
