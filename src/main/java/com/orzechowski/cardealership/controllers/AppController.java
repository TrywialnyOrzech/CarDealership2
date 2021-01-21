package com.orzechowski.cardealership.controllers;

import com.orzechowski.cardealership.models.Poczty;
import com.orzechowski.cardealership.repository.PocztyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    // Poczty mapping methods

    @RequestMapping("/viewPoczty")
    public String viewPoczty(Model model){
        List<Poczty> listPoczty = dao.list();
        model.addAttribute("listPoczty", listPoczty);
        return "view_poczty";
    }

    @RequestMapping("/newPoczty")
    public String showNewForm(Model model){
        Poczty poczty = new Poczty();
        model.addAttribute("poczty", poczty);
        return "new_form_poczty";
    }

    @RequestMapping(value="/savePoczty", method = RequestMethod.POST)
    public String save(@ModelAttribute("poczty") Poczty poczty){
        dao.save(poczty);
        return "redirect:/";        // back to start location
    }

    @RequestMapping("/editPoczty/{nr_poczty}")
    public ModelAndView showEditForm(@PathVariable(name = "nr_poczty") int nr_poczty) {
        ModelAndView mav = new ModelAndView("edit_form_poczty");
        Poczty poczty = dao.get(nr_poczty);
        mav.addObject("poczty", poczty);
        return mav;
    }

    @RequestMapping(value = "/updatePoczty", method = RequestMethod.POST)
    public String update(@ModelAttribute("poczty") Poczty poczty){
        dao.update(poczty);
        return "redirect:/";
    }

    @RequestMapping(value = "/deletePoczty/{nr_poczty}")
    public String delete(@PathVariable(name = "nr_poczty") int nr_poczty) {
        dao.delete(nr_poczty);
        return "redirect:/";
    }

    //



}
