/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.KrsDAO;
import com.flashdin.belajarspringweb.entity.Krs;
import com.flashdin.belajarspringweb.service.KrsService;
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
public class KrsServiceImpl implements KrsService{
    
    @Autowired
    private KrsDAO krsDAO;

    @Override
    public List<Krs> findByName(@PathVariable int id) {
        return krsDAO.findByName(id);
    }

    @Override
    public Krs save(@RequestBody Krs param) {
        return krsDAO.save(param);
    }

    @Override
    public Krs update(Krs param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Krs param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Krs findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Krs> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
