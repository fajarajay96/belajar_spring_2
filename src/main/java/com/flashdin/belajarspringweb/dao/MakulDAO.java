/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.Makul;
import java.util.List;

/**
 *
 * @author Fajar
 */
public interface MakulDAO extends BaseDAO<Makul>{
    List<Makul> findByName(Makul param);
}
