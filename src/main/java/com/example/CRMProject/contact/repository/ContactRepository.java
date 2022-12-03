package com.example.CRMProject.contact.repository;

import com.example.CRMProject.contact.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ContactRepository {
    //@Query("select c from Contact c")
    List<Contact> index();

    Contact show(Long id);

    void save(Contact contact);

    void update(Long id, Contact updatedContact);

    void delete(Long id);

    List<Contact> searchByFirstLettersName(String firstName);

    void searchNameContact(String name);

    // поиск по название компании, по номеру, компании по емайлу,

}
