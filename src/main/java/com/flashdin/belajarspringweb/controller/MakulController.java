/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.Makul;
import com.flashdin.belajarspringweb.entity.Profile;
import com.flashdin.belajarspringweb.entity.User;
import com.flashdin.belajarspringweb.service.MakulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Fajar
 */
@Controller
@RequestMapping("/makul")
public class MakulController {
    
    @Autowired
    private MakulService makulService;
    
    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", makulService.findAll());
        } else {
            Makul makul = new Makul();
            makul.setMakul(param);
            model.addAttribute("dataSets", makulService.findByName(makul));
        }
        return "/makul/list";
    }
    
    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Makul());
        return "/makul/create";
    }
    
    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", makulService.findById(id));
        return "/makul/update";
    }
    
    @PostMapping(value = "/create")
    public String save(Makul param) {
        Makul data = makulService.save(param);
        if (data.getId() == 0) {
            return "redirect:/makul/create?failed";
        } else {
            return "redirect:/makul/create?success";
        }
    }
    
    @PutMapping(path = "/update")
    public String update(Makul param) {
        Makul data = makulService.update(param);
        if (data.getId() == 0) {
            return "redirect:/makul?ufailed";
        } else {
            return "redirect:/makul?usuccess";
        }
    }
    
    @DeleteMapping(path = "/delete")
    public String delete(Makul param) {
        int data = makulService.delete(param);
        if (data == 0) {
            return "redirect:/makul?dfailed";
        } else {
            return "redirect:/makul?dsuccess";
        }
    }
    
}
