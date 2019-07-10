/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.MakulDAO;
import com.flashdin.belajarspringweb.entity.Makul;
import com.flashdin.belajarspringweb.service.MakulService;
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
public class MakulServiceImpl implements MakulService{

    @Autowired
    private MakulDAO makulDAO;
    
    @Override
    public List<Makul> findByName(Makul param) {
        return makulDAO.findByName(param);
    }

    @Override
    public Makul save(@RequestBody Makul param) {
        return makulDAO.save(param);
    }

    @Override
    public Makul update(@RequestBody Makul param) {
        return makulDAO.update(param);
    }

    @Override
    public int delete(@RequestBody Makul param) {
        return makulDAO.delete(param);
    }

    @Override
    public Makul findById(@PathVariable int id) {
        return makulDAO.findById(id);
    }

    @Override
    public List<Makul> findAll() {
        return makulDAO.findAll();
    }
    
}
