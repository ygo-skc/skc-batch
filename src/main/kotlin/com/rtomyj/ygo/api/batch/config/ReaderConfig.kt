package com.rtomyj.ygo.api.batch.config

import com.rtomyj.ygo.api.batch.model.CardModel
import com.rtomyj.ygo.api.batch.rowmapper.CardRowMapper
import org.springframework.batch.item.database.JdbcCursorItemReader
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class ReaderConfig {

    @Bean
    fun ygoDatabaseReader(@Autowired @Qualifier("ygoApiDataSource") ygoApiDataSource: DataSource)
            : JdbcCursorItemReader<CardModel> = JdbcCursorItemReaderBuilder<CardModel>()
            .dataSource(ygoApiDataSource)
            .name("YGO API main database card reader")
            .sql("select card_name, card_effect from cards limit 0,100")
            .rowMapper(CardRowMapper())
            .build()

}