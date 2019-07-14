/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.MataKuliah;
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
import com.flashdin.belajarspringweb.service.MataKuliahService;

/**
 *
 * @author Fajar
 */
@Controller
@RequestMapping("/mataKuliah")
public class MataKuliahController {
    
    @Autowired
    private MataKuliahService mataKuliahService;
    
    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", mataKuliahService.findAll());
        } else {
            MataKuliah mataKuliah = new MataKuliah();
            mataKuliah.setMataKuliah(param);
            model.addAttribute("dataSets", mataKuliahService.findByName(mataKuliah));
        }
        return "/mataKuliah/list";
    }
    
    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new MataKuliah());
        return "/mataKuliah/create";
    }
    
    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", mataKuliahService.findById(id));
        return "/mataKuliah/update";
    }
    
    @PostMapping(value = "/create")
    public String save(MataKuliah param) {
        MataKuliah data = mataKuliahService.save(param);
        if (data.getId() == 0) {
            return "redirect:/mataKuliah/create?failed";
        } else {
            return "redirect:/mataKuliah/create?success";
        }
    }
    
    @PutMapping(path = "/update")
    public String update(MataKuliah param) {
        MataKuliah data = mataKuliahService.update(param);
        if (data.getId() == 0) {
            return "redirect:/mataKuliah?ufailed";
        } else {
            return "redirect:/mataKuliah?usuccess";
        }
    }
    
    @DeleteMapping(path = "/delete")
    public String delete(MataKuliah param) {
        int data = mataKuliahService.delete(param);
        if (data == 0) {
            return "redirect:/mataKuliah?dfailed";
        } else {
            return "redirect:/mataKuliah?dsuccess";
        }
    }
    
}
