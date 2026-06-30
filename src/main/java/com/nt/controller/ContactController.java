package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nt.entity.Contact;
import com.nt.service.IContactService;

@Controller
public class ContactController {

    @Autowired
    private IContactService service;

    @GetMapping("/contact")
    public String contactPage(Model model) {

        model.addAttribute("contact", new Contact());

        return "contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute Contact contact,
                              Model model) {

        service.saveContact(contact);

        model.addAttribute("msg",
                "Thank You! Your message has been sent successfully.");

        model.addAttribute("contact", new Contact());

        return "contact";
    }

}