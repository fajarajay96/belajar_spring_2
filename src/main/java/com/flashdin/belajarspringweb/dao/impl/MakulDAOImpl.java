/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.MakulDAO;
import com.flashdin.belajarspringweb.entity.Makul;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fajar
 */
@Repository
public class MakulDAOImpl implements MakulDAO{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Makul> findByName(Makul param) {
        String sql = "select * from table_makul where makul like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getMakul() + "%"}, new BeanPropertyRowMapper<>(Makul.class));
    }

    @Override
    public Makul save(Makul param) {
        String sql = "insert into table_makul (makul) values (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMakul());
            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Makul update(Makul param) {
        String sql = "update table_makul set makul=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMakul());
            ps.setInt(2, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(Makul param) {
        String sql = "delete from table_makul where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public Makul findById(int id) {
        String sql = "select * from table_makul where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Makul.class));
    }

    @Override
    public List<Makul> findAll() {
        String sql = "select * from table_makul";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Makul.class));
    }
}
