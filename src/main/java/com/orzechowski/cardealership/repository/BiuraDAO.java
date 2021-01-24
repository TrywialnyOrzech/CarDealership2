package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Biura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BiuraDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BiuraDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Biura> list() {
        String sql = "SELECT * FROM Biura";
        List<Biura> listBiura = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Biura.class));
        return listBiura;
    }

    public void save(Biura biura) {
        SimpleJdbcInsert insertBiuro = new SimpleJdbcInsert(jdbcTemplate);
        insertBiuro.withTableName("Biura").usingColumns("nazwa", "data_zalozenia", "nr_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(biura);
        insertBiuro.execute(param);
    }

    public Biura get(int nr_biura) {
        Object[] args = {nr_biura};
        String sql = "SELECT * FROM BIURA WHERE Nr_biura = " + args[0];
        Biura biura = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Biura.class));
        return biura;
    }

    public void update(Biura biura) {
        String sql = "UPDATE BIURA SET nazwa=:nazwa, data_zalozenia=:data_zalozenia, nr_adresu=:nr_adresu WHERE nr_biura=:nr_biura";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(biura);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int nr_biura) {
        String sql = "DELETE FROM BIURA WHERE Nr_biura = ?";
        jdbcTemplate.update(sql, nr_biura);
    }
}
