package com.mzy.springbootquick;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootquickApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {

    }
    @Test
    public void testConnect(){
        List<Map<String,Object>> result=jdbcTemplate.queryForList("select title from movies where movieid=1");
        System.out.println("The size of result is "+result.size());
        System.out.println("yeah!!");
    }

}
