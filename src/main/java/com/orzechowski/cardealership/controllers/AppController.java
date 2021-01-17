package com.orzechowski.cardealership.controllers;

import com.orzechowski.cardealership.models.Poczty;
import com.orzechowski.cardealership.repository.PocztyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private PocztyDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Poczty> listPoczty = dao.list();
        model.addAttribute("listPoczty", listPoczty);
        return "index";
    }
}
