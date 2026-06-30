package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Contact;
import com.nt.repository.ContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public Contact saveContact(Contact contact) {

        return repository.save(contact);
    }

    

}