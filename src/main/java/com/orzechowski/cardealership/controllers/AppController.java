package com.orzechowski.cardealership.controllers;

import com.orzechowski.cardealership.models.Adresy;
import com.orzechowski.cardealership.models.Poczty;
import com.orzechowski.cardealership.repository.AdresyDAO;
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
    private PocztyDAO pocztyDAO;
    @Autowired
    private AdresyDAO adresyDAO;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Poczty> listPoczty = pocztyDAO.list();
        model.addAttribute("listPoczty", listPoczty);
        return "index";
    }

    // Poczty mapping methods

    @RequestMapping("/viewPoczty")
    public String viewPoczty(Model model){
        List<Poczty> listPoczty = pocztyDAO.list();
        model.addAttribute("listPoczty", listPoczty);
        return "view_poczty";
    }

    @RequestMapping("/newPoczty")
    public String showNewPocztyForm(Model model){
        Poczty poczty = new Poczty();
        model.addAttribute("poczty", poczty);
        return "new_form_poczty";
    }

    @RequestMapping(value="/savePoczty", method = RequestMethod.POST)
    public String saveNewPoczty(@ModelAttribute("poczty") Poczty poczty){
        pocztyDAO.save(poczty);
        return "redirect:/viewPoczty";        // back to start location
    }

    @RequestMapping("/editPoczty/{nr_poczty}")
    public ModelAndView showPocztyEditForm(@PathVariable(name = "nr_poczty") int nr_poczty) {
        ModelAndView mav = new ModelAndView("edit_form_poczty");
        Poczty poczty = pocztyDAO.get(nr_poczty);
        mav.addObject("poczty", poczty);
        return mav;
    }

    @RequestMapping(value = "/updatePoczty", method = RequestMethod.POST)
    public String updatePoczty(@ModelAttribute("poczty") Poczty poczty){
        pocztyDAO.update(poczty);
        return "redirect:/viewPoczty";
    }

    @RequestMapping(value = "/deletePoczty/{nr_poczty}")
    public String deletePoczty(@PathVariable(name = "nr_poczty") int nr_poczty) {
        pocztyDAO.delete(nr_poczty);
        return "redirect:/viewPoczty";
    }

    // Adresy mapping methods
    @RequestMapping("/viewAdresy")
    public String viewAdresy(Model model){
        List<Adresy> listAdresy = adresyDAO.list();
        model.addAttribute("listAdresy", listAdresy);
        return "view_adresy";
    }

    @RequestMapping("/newAdresy")
    public String showNewAdresyForm(Model model){
        Adresy adresy = new Adresy();
        model.addAttribute("adresy", adresy);
        return "new_form_adresy";
    }

    @RequestMapping(value="/saveAdresy", method = RequestMethod.POST)
    public String saveNewAdresy(@ModelAttribute("adresy") Adresy adresy){
        adresyDAO.save(adresy);
        return "redirect:/viewAdresy";
    }

    @RequestMapping("/editAdresy/{nr_adresu}")
    public ModelAndView showAdresyEditForm(@PathVariable(name = "nr_adresu") int nr_adresu) {
        ModelAndView mav = new ModelAndView("edit_form_adresy");
        Adresy adresy = adresyDAO.get(nr_adresu);
        mav.addObject("adresy", adresy);
        return mav;
    }

    @RequestMapping(value = "/updateAdresy", method = RequestMethod.POST)
    public String updateAdresy(@ModelAttribute("adresy") Adresy adresy){
        adresyDAO.update(adresy);
        return "redirect:/viewAdresy";
    }


}
