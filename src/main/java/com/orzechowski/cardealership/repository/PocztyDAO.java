package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Poczty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
        SimpleJdbcInsert insertPoczta = new SimpleJdbcInsert(jdbcTemplate);
        insertPoczta.withTableName("Poczty").usingColumns("Kod_poczty", "Poczta");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczty);
        insertPoczta.execute(param);
    }

    // Read row
    public Poczty get(int nr_poczty){
        Object[] args = {nr_poczty};
        String sql = "SELECT * FROM POCZTY WHERE Nr_poczty = " + args[0];
        Poczty poczty = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Poczty.class));
        return poczty;
    }

    // Update row
    public void update(Poczty poczty){
        String sql = "UPDATE POCZTY SET kod_poczty=:kod_poczty, poczta=:poczta WHERE nr_poczty=:nr_poczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczty);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    // Delete row
    public void delete(int nr_poczty){
        String sql = "DELETE FROM POCZTY WHERE Nr_poczty = ?";
        jdbcTemplate.update(sql, nr_poczty);
    }
}
