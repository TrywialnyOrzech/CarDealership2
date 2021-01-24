package com.orzechowski.cardealership.repository;

import com.orzechowski.cardealership.models.Biura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiuraDAOTest {
    private BiuraDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();         // initialize db connection
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL1");
        datasource.setUsername("natan");
        datasource.setPassword("toor");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        // Import jdbc template
        dao = new BiuraDAO(new JdbcTemplate(datasource));
    }

    @Test
    public void list() {
        List<Biura> listBiura = dao.list();
        assertTrue(listBiura.isEmpty());
    }

    @Test
    public void save() {
        Biura biura = new Biura("Testowe Biuro", Date.valueOf("2002-02-02"), 3);
        dao.save(biura);
    }

    @Test
    public void get() {
        Biura biura = dao.get(3);
        assertNotNull(biura);
    }

    @Test
    public void update() {
        Biura biura = new Biura();
        biura.setNr_biura(3);
        biura.setNazwa("Testowe Biureczko");
        //Date date = new Date(1000000000);
        //date = Date.valueOf("2005-02-03");
        //biura.setDataZalozenia(date);
        //biura.setNr_adresu(3);
        dao.update(biura);
    }

    @Test
    public void delete() {
        int nr_biura = 3;
        dao.delete(nr_biura);
    }
}