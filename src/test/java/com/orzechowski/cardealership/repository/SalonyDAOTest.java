package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Salony;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalonyDAOTest {
    private SalonyDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();         // initialize db connection
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
        datasource.setUsername("natan");
        datasource.setPassword("toor");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        // Import jdbc template
        dao = new SalonyDAO(new JdbcTemplate(datasource));
    }

    @Test
    public void list() {
        List<Salony> listSalony = dao.list();
        assertTrue(listSalony.isEmpty());
    }

    @Test
    public void save() {
        Salony salony = new Salony("Testowy salon", "y", 2);
        dao.save(salony);
    }

    @Test
    public void get() {
        Salony salony = dao.get(2);
        assertNotNull(salony);
    }

    @Test
    public void update() {
        Salony salony = new Salony();
        salony.setNr_salonu(2);
        salony.setNazwa("Zmiana nazwy salonu");
        salony.setStatus("n");
        salony.setNr_biura(2);
        dao.update(salony);
    }

    @Test
    public void delete() {
        int nr_salonu = 2;
        dao.delete(nr_salonu);
    }
}