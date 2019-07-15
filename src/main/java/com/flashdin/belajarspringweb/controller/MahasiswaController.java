/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.Mahasiswa;
import com.flashdin.belajarspringweb.service.MahasiswaService;
import java.util.List;
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
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
            @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", mahasiswaService.findAll());
            
        } else {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNama(param);
            model.addAttribute("dataSets", mahasiswaService.findByName(mahasiswa));
        }
        return "/mahasiswa/list";
    }

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Mahasiswa());
        return "/mahasiswa/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", mahasiswaService.findById(id));
        return "/mahasiswa/update";
    }

    @PostMapping(value = "/create")
    public String save(Mahasiswa param) {
        Mahasiswa data = mahasiswaService.save(param);
        if (data.getId() == 0) {
            return "redirect:/mahasiswa/create?failed";
        } else {
            return "redirect:/mahasiswa/create?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Mahasiswa param) {
        Mahasiswa data = mahasiswaService.update(param);
        if (data.getId() == 0) {
            return "redirect:/mahasiswa?ufailed";
        } else {
            return "redirect:/mahasiswa?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Mahasiswa param) {
        int data = mahasiswaService.delete(param);
        if (data == 0) {
            return "redirect:/mahasiswa?dfailed";
        } else {
            return "redirect:/mahasiswa?dsuccess";
        }
    }

}
