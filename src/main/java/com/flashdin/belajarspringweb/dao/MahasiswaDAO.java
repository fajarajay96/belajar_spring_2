/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.Mahasiswa;
import java.util.List;

/**
 *
 * @author Fajar
 */
public interface MahasiswaDAO extends BaseDAO<Mahasiswa>{
    List<Mahasiswa> findByName(Mahasiswa param);
}
