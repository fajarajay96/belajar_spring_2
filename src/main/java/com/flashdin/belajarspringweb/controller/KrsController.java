/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.Krs;
import com.flashdin.belajarspringweb.entity.Mahasiswa;
import com.flashdin.belajarspringweb.service.KrsService;
import com.flashdin.belajarspringweb.service.MahasiswaService;
import com.flashdin.belajarspringweb.service.MataKuliahService;
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
@RequestMapping("/krs")
public class KrsController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private MataKuliahService matakuliahService;

    @Autowired
    private KrsService krsService;

    @GetMapping(path = "/view/{id}")
    public String viewDetail(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSetsMahasiswa", mahasiswaService.findById(id));
        model.addAttribute("dataSetsKrs", krsService.findByName(id));
        return "/krs/list";
    }

    @GetMapping(path = "/create/{id}")
    public String viewCreate(Model model, @PathVariable(value = "id") int id) {
        boolean myBooleanVariable = false;
        model.addAttribute("chk", myBooleanVariable);
        model.addAttribute("dataSets", mahasiswaService.findById(id));
//       model.addAttribute("dataSetsMatakuliah", matakuliahService.findAll());
        model.addAttribute("dataSetsMatakuliah", matakuliahService.findBymahasiswa(id));
        return "/krs/add_krs";
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam(value = "chk[]") String[] chk, @RequestParam(value = "sks[]") String[] sks, @RequestParam(value = "id_mahasiswa") String param) {
//         System.out.println(param.length);
        Krs data = new Krs();
        for (int i = 0; i < chk.length; i++) {
//             System.out.println(sks[2]);
            Krs krs = new Krs();
            krs.setId_matakuliah(Integer.parseInt(chk[i]));
            krs.setId_mahasiswa(Integer.parseInt(param));
            krs.setSks(Integer.parseInt(sks[i]));
            data = krsService.save(krs);
        }
//        return null;
        if (data.getId_mahasiswa() == 0) {
            return "redirect:/krs/view/" + data.getId_mahasiswa() + "?sfailed";
        } else {
            return "redirect:/krs/view/" + data.getId_mahasiswa() + "?ssuccess";
        }
    }

    @GetMapping(path = "/viewupdate/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        boolean myBooleanVariable = false;
        model.addAttribute("chk", myBooleanVariable);
        model.addAttribute("dataSets", mahasiswaService.findById(id));
        model.addAttribute("dataSetsMatakuliah", matakuliahService.findAll());
        return "/krs/update";
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam(value = "chk[]") String[] chk, @RequestParam(value = "sks[]") String[] sks, @RequestParam(value = "id_mahasiswa") String param) {
//         System.out.println(param.length);

        Krs data = new Krs();
        data.setId_mahasiswa(Integer.parseInt(param));
        krsService.delete(data);
        if (data.getId_mahasiswa()== 0) {
            return "redirect:/krs/view/" + data.getId_mahasiswa() + "?ufailed";
        } else {
            for (int i = 0; i < chk.length; i++) {
//             System.out.println(sks[2]);
                Krs krs = new Krs();
                krs.setId_matakuliah(Integer.parseInt(chk[i]));
                krs.setId_mahasiswa(Integer.parseInt(param));
                krs.setSks(Integer.parseInt(sks[i]));
                data = krsService.update(krs);
            }
            if (data.getId_mahasiswa() == 0) {
                return "redirect:/krs/view/" + data.getId_mahasiswa() + "?ufailed";
            } else {
                return "redirect:/krs/view/" + data.getId_mahasiswa() + "?usuccess";
            }
        }

//        return null;
    }

}
