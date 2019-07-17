/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Krs;
import java.util.List;

/**
 *
 * @author Fajar
 */
public interface KrsService extends BaseService<Krs>{
    List<Krs> findByName(int id);
}
