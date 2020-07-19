package com.rtomyj.ygo.api.batch.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource


@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
class DataSourceConfig
{

    lateinit var url: String
    lateinit var username: String
    lateinit var password: String

    @Bean("ygoApiDataSource")
    fun getYgoApiDataSource(): DataSource = DataSourceBuilder
            .create()
            .url(url)
            .username(username)
            .password(password)
            .build()


    @Bean("ygoApiJdbcTemplate")
    fun getYgoApiTemplate(@Autowired @Qualifier("ygoApiDataSource") ygoApiDataSource: DataSource): JdbcTemplate = JdbcTemplate(ygoApiDataSource)

}