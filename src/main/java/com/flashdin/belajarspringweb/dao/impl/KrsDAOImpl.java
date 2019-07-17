/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.KrsDAO;
import com.flashdin.belajarspringweb.entity.Krs;
import com.flashdin.belajarspringweb.entity.Mahasiswa;
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
public class KrsDAOImpl implements KrsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Krs findById(int id) {
        String sql = "SELECT table_mahasiswa.nama, table_krs.id_matakuliah, table_makul.mataKuliah, table_makul.sks from table_mahasiswa\n" +
"                join table_krs  on table_krs.id_mahasiswa=table_mahasiswa.id\n" +
"                join table_makul on table_krs.id_matakuliah=table_makul.id where table_krs.id_mahasiswa=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Krs.class));
    }

    @Override
    public List<Krs> findByName(int id) {
        String sql = "SELECT table_mahasiswa.nama, table_krs.id_matakuliah, table_makul.mataKuliah, table_makul.sks from table_mahasiswa\n" +
"                join table_krs  on table_krs.id_mahasiswa=table_mahasiswa.id\n" +
"                join table_makul on table_krs.id_matakuliah=table_makul.id where table_krs.id_mahasiswa=?";
        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Krs.class));
    }

    @Override
    public Krs save(Krs param) {
        String sql = "insert into table_krs (id_mahasiswa,id_matakuliah,sks) select ?,id,sks from table_makul where id = ?";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId_mahasiswa());
            ps.setInt(2, param.getId_matakuliah());
//            ps.setInt(3, param.getSks());
            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
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
    public List<Krs> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
