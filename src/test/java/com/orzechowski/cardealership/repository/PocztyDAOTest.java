package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Poczty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PocztyDAOTest {

    private PocztyDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();         // initialize db connection
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
        datasource.setUsername("natan");
        datasource.setPassword("toor");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        // Import jdbc template
        dao = new PocztyDAO(new JdbcTemplate(datasource));

    }

    @Test
    void list() {
        List<Poczty> listPoczty = dao.list();
        assertTrue(listPoczty.isEmpty());
    }

    @Test
    void save() {
        Poczty poczty = new Poczty("11-111", "Pacanowo");
        dao.save(poczty);
    }

    @Test
    void get() {
        int id = 45;
        Poczty poczty = dao.get(id);
        assertNotNull(poczty);
    }

    @Test
    void update() {
        Poczty poczty = new Poczty();
        poczty.setNr_poczty(999);
        poczty.setKod_poczty("11-111");
        poczty.setPoczta("Testowo");
        dao.update(poczty);
    }

    @Test
    void delete() {
        int nr_poczty = 999;
        dao.delete(nr_poczty);
    }
}