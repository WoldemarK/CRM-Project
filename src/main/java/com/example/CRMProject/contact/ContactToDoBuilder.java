package com.example.CRMProject.contact;

import com.example.CRMProject.contact.model.Contact;

public class ContactToDoBuilder {
    private static final ContactToDoBuilder instance = new ContactToDoBuilder();

    private Long id;
    private String email = "";
    private String phoneNumber = "";
    private String descriptions = "";
    private String post = "";

    public ContactToDoBuilder() {

    }

    public static ContactToDoBuilder create() {
        return instance;
    }

    public ContactToDoBuilder withId(Long id) {
        this.id = id;
        return instance;
    }

    public ContactToDoBuilder withEmail(String email) {
        this.email = email;
        return instance;
    }

    public ContactToDoBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return instance;
    }

    public ContactToDoBuilder withDescription(String descriptions) {
        this.descriptions = descriptions;
        return instance;

    }

    public ContactToDoBuilder withPost(String post) {
        this.post = post;
        return instance;
    }

    public Contact build() {
        Contact result = new Contact(this.email, this.phoneNumber, this.descriptions, this.post);
        if (id != null) {
            result.setId(id);
        }
        return result;
    }
}
