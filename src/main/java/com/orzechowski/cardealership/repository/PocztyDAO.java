package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Poczty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PocztyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PocztyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // List with data from table
    public List<Poczty> list(){
        String sql = "SELECT * FROM Poczty";
        List<Poczty> listPoczty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczty.class));
        return listPoczty;
    }

    // Insert row
    public void save(Poczty poczty){

    }

    // Read row
    public Poczty get(int id){
        return null;
    }

    // Update row
    public void update(Poczty poczty){

    }

    // Delete row
    public void delete(int id){

    }
}
