package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Adresy;
import com.orzechowski.cardealership.models.Poczty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
            SimpleJdbcInsert insertAdres = new SimpleJdbcInsert(jdbcTemplate);
            insertAdres.withTableName("Adresy").usingColumns("Miasto", "Ulica", "Nr_lokalu", "Nr_poczty");
            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
            insertAdres.execute(param);
    }

    //Read row
    public Adresy get(int nr_adresu) {
        Object[] args = {nr_adresu};
        String sql = "SELECT * FROM ADRESY WHERE Nr_adresu = " + args[0];
        Adresy adresy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return adresy;
    }

    //Update row
    public void update(Adresy adresy) {
        String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, nr_lokalu=:nr_lokalu, nr_poczty=:nr_poczty WHERE nr_adresu=:nr_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    // Delete row
    public void delete(int nr_adresu) {
        String sql = "DELETE FROM ADRESY WHERE Nr_adresu = ?";
        jdbcTemplate.update(sql, nr_adresu);
    }
}
