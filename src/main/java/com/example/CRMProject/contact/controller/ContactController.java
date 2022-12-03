package com.example.CRMProject.contact.controller;

import com.example.CRMProject.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactController {
    private final ContactService service;


}
