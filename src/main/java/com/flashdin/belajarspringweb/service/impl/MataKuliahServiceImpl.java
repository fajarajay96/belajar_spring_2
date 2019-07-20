/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.entity.MataKuliah;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.flashdin.belajarspringweb.dao.MataKuliahDAO;
import com.flashdin.belajarspringweb.service.MataKuliahService;

/**
 *
 * @author Fajar
 */
@Service
public class MataKuliahServiceImpl implements MataKuliahService{

    @Autowired
    private MataKuliahDAO mataKuliahDAO;
    
    @Override
    public List<MataKuliah> findByName(MataKuliah param) {
        return mataKuliahDAO.findByName(param);
    }

    @Override
    public MataKuliah save(@RequestBody MataKuliah param) {
        return mataKuliahDAO.save(param);
    }

    @Override
    public MataKuliah update(@RequestBody MataKuliah param) {
        return mataKuliahDAO.update(param);
    }

    @Override
    public int delete(@RequestBody MataKuliah param) {
        return mataKuliahDAO.delete(param);
    }

    @Override
    public MataKuliah findById(@PathVariable int id) {
        return mataKuliahDAO.findById(id);
    }

    @Override
    public List<MataKuliah> findAll() {
        return mataKuliahDAO.findAll();
    }

    @Override
    public List<MataKuliah> findBymahasiswa(@PathVariable int id) {
        return mataKuliahDAO.findBymahasiswa(id);
    }
    
}
