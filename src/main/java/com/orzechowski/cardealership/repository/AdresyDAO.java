package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Adresy;
import com.orzechowski.cardealership.models.Poczty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // List with data from table
    public List<Adresy> list(){
        String sql = "SELECT * FROM Adresy";
        List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }

    // Insert row
    public void save(Adresy adresy) {
        /*SimpleJdbcInsert insertAdres = new SimpleJdbcInsert(jdbcTemplate);
        insertAdres.withTableName("Adresy").usingColumns("")*/
    }
}
