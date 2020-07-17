package com.rtomyj.ygo.api.batch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet


@Repository
class Dao
{

    @Autowired
    lateinit var ygoApiTemplate: JdbcTemplate

    fun test()
    {

        ygoApiTemplate.query("SELECT * FROM cards limit 0,100", fun(rs: ResultSet) {
            while(rs.next())
            {
                println(rs.getString("card_name"))
            }
        })

    }

}