/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.MataKuliah;
import java.util.List;

/**
 *
 * @author Fajar
 */
public interface MataKuliahService extends BaseService<MataKuliah>{
    List<MataKuliah> findByName(MataKuliah param);
    List<MataKuliah> findBymahasiswa(int id);
}
