package com.finalproject.nasadata.controller;

import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ViewsController {

    @Autowired
    MeteoriteService meteoriteService;

    @RequestMapping(value="/map", method = RequestMethod.GET)
    public String maps(Model model){
        return "map";
    }

    @RequestMapping(value = "/meteorites", method = RequestMethod.GET)
    public String allMeteorites(Model model) {
        model.addAttribute("meteorites", getAll());
        return "meteorites";
    }

    @RequestMapping(value="/add_meteorite", method = RequestMethod.POST)
    public String addMeteorite(@Valid Meteorite meteorite, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Your meteor is on the way.");
        meteoriteService.add(meteorite);
        return "redirect:/map";
    }


    public List<Meteorite> getAll(){
        List<Meteorite> meteorites = meteoriteService.getAll().stream().collect(Collectors.toList());
        return meteorites;
    }
}
