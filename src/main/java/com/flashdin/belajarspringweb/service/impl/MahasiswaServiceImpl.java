/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.MahasiswaDAO;
import com.flashdin.belajarspringweb.entity.Mahasiswa;
import com.flashdin.belajarspringweb.service.MahasiswaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Fajar
 */
@Service
public class MahasiswaServiceImpl implements MahasiswaService{

    @Autowired
    private MahasiswaDAO mahasiswaDAO;
    
    @Override
    public List<Mahasiswa> findByName(Mahasiswa param) {
        return mahasiswaDAO.findByName(param);
    }

    @Override
    public Mahasiswa save(@RequestBody Mahasiswa param) {
        return mahasiswaDAO.save(param);
    }

    @Override
    public Mahasiswa update(@RequestBody Mahasiswa param) {
        return mahasiswaDAO.update(param);
    }

    @Override
    public int delete(@RequestBody Mahasiswa param) {
        return mahasiswaDAO.delete(param);
    }

    @Override
    public Mahasiswa findById(@PathVariable int id) {
        return mahasiswaDAO.findById(id);
    }

    @Override
    public List<Mahasiswa> findAll() {
        return mahasiswaDAO.findAll();
    }
    
}
