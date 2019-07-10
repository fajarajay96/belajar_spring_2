/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Makul;
import java.util.List;

/**
 *
 * @author Fajar
 */
public interface MakulService extends BaseService<Makul>{
    List<Makul> findByName(Makul param);
}
