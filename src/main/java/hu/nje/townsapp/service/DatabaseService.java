package hu.nje.townsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DatabaseService {

    private final JdbcTemplate jdbc;

    public List<Map<String, Object>> getCounties() {
        return jdbc.queryForList("SELECT * FROM counties ORDER BY id");
    }

    public List<Map<String, Object>> getTowns() {
        return jdbc.queryForList("SELECT * FROM towns ORDER BY id");
    }

    public List<Map<String, Object>> getPopulations() {
        return jdbc.queryForList("SELECT * FROM populations ORDER BY townid");
    }
}
