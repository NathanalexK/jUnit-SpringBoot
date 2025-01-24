package org.project.boulangerie.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DatabaseService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Double getCommission() {
        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT value FROM configuration WHERE key = 'commission'");
        return Double.parseDouble(String.valueOf(map.get("value"))) / 100;
    }

    public Double getMinCommission() {
        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT value FROM configuration WHERE key = 'min_commission'");
        return Double.parseDouble(String.valueOf(map.get("value")));
    }
}
