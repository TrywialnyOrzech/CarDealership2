package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Salony;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalonyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SalonyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Salony> list() {
        String sql = "SELECT * FROM Salony";
        List<Salony> listSalony = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Salony.class));
        return listSalony;
    }

    public void save(Salony salony) {
        SimpleJdbcInsert insertSalon = new SimpleJdbcInsert(jdbcTemplate);
        insertSalon.withTableName("Salony").usingColumns("nazwa", "status", "nr_biura");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(salony);
        insertSalon.execute(param);
    }

    public Salony get(int nr_salonu) {
        Object[] args = {nr_salonu};
        String sql = "SELECT * FROM SALONY WHERE Nr_salonu = " + args[0];
        Salony salony = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Salony.class));
        return salony;
    }

    public void update(Salony salony) {
        String sql = "UPDATE SALONY SET nazwa=:nazwa, status=:status, nr_biura=:nr_biura WHERE nr_salonu=:nr_salonu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(salony);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int nr_salonu) {
        String sql = "DELETE FROM SALONY WHERE Nr_salonu = ?";
        jdbcTemplate.update(sql, nr_salonu);
    }
}
