/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.entity.MataKuliah;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.flashdin.belajarspringweb.dao.MataKuliahDAO;

/**
 *
 * @author Fajar
 */
@Repository
public class MataKuliahDAOImpl implements MataKuliahDAO{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MataKuliah> findByName(MataKuliah param) {
        String sql = "select * from table_makul where mataKuliah like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getMataKuliah() + "%"}, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

    @Override
    public MataKuliah save(MataKuliah param) {
        String sql = "insert into table_makul (mataKuliah,sks) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMataKuliah());
            ps.setInt(2, param.getSks());
            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public MataKuliah update(MataKuliah param) {
        String sql = "update table_makul set mataKuliah=?, sks=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMataKuliah());
            ps.setInt(2, param.getSks());
            ps.setInt(3, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(MataKuliah param) {
        String sql = "delete from table_makul where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public MataKuliah findById(int id) {
        String sql = "select * from table_makul where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

    @Override
    public List<MataKuliah> findAll() {
        String sql = "select * from table_makul";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

    @Override
    public List<MataKuliah> findBymahasiswa(int id) {
        String sql = "select * from table_makul where table_makul.id not in (select table_krs.id_matakuliah from table_krs where table_krs.id_mahasiswa=?)";
        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(MataKuliah.class));
    }
}
