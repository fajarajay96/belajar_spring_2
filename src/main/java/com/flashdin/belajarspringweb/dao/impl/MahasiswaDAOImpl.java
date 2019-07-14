/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.MahasiswaDAO;
import com.flashdin.belajarspringweb.entity.Mahasiswa;
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

/**
 *
 * @author Fajar
 */
@Repository
public class MahasiswaDAOImpl implements MahasiswaDAO{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Mahasiswa> findByName(Mahasiswa param) {
        String sql = "select * from table_mahasiswa where nama like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getNama()+ "%"}, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public Mahasiswa save(Mahasiswa param) {
        String sql = "insert into table_mahasiswa (nama,alamat,no_telepon,sks) values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama());
            ps.setString(2, param.getAlamat());
            ps.setInt(3, param.getNo_telepon());
            ps.setInt(4, param.getSks());
            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Mahasiswa update(Mahasiswa param) {
        String sql = "update table_mahasiswa set nama=?, alamat=?, no_telepon=?, sks=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama());
            ps.setString(2, param.getAlamat());
            ps.setInt(3, param.getNo_telepon());
            ps.setInt(4, param.getSks());
            ps.setInt(5, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(Mahasiswa param) {
        String sql = "delete from table_mahasiswa where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public Mahasiswa findById(int id) {
        String sql = "select * from table_mahasiswa where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public List<Mahasiswa> findAll() {
        String sql = "select * from table_mahasiswa";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }
    
}
