package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Poczty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
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
        fail("Not yet implemented");
    }

    @Test
    void get() {
        fail("Not yet implemented");
    }

    @Test
    void update() {
        fail("Not yet implemented");
    }

    @Test
    void delete() {
        fail("Not yet implemented");
    }
}