package com.example.CRMProject.contact.service;

import com.example.CRMProject.contact.model.Contact;

import com.example.CRMProject.contact.repository.ContactRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService implements ContactRepository {
    private final SessionFactory sessionFactory;


    @Autowired
    public ContactService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> index() {
        System.out.println("Предоставлены все контакты");
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Contact c", Contact.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Contact show(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Contact.class, id);
    }

    @Override
    @Transactional()
    public void save(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(contact);
        this.index();
    }

    @Override
    @Transactional(readOnly = true)
    public void update(Long id, Contact updatedContact) {
        Session session = sessionFactory.getCurrentSession();

        Contact contact = session.get(Contact.class, id);
        contact.setId(updatedContact.getId());
        contact.setName(updatedContact.getName());
        contact.setEmail(updatedContact.getEmail());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        contact.setDescriptions(updatedContact.getDescriptions());
        this.index();
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Contact.class, id));
        System.out.println("Контакт с ID: " + id + " уделен");
        this.index();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> searchByFirstLettersName(String firstName) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Contact c where c.name like 'T%'", Contact.class).getResultList();
    }

    @Override
    public void searchNameContact(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("select c from Contact c where c.name=name");
    }
//    @Override
//    @Transactional(readOnly = true)
//    public List<Contact> searchByCompanyLettersName(String company) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("select c from Company c where c.name like 'T%'", Company.class).getResultList();
//    }
}
