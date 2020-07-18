package com.rtomyj.ygo.api.batch.reader

import com.rtomyj.ygo.api.batch.dao.YgoCardRowMapper
import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.database.JdbcCursorItemReader
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class Beans
{
    @Bean
    fun ygoDatabaseReader(
            @Autowired @Qualifier("ygoApiDataSource") ygoApiDataSource: DataSource)
            : JdbcCursorItemReader<CardModel>
            = JdbcCursorItemReaderBuilder<CardModel>()
            .dataSource(ygoApiDataSource)
            .name("ygo api card reader")
            .sql("select card_name, card_effect from cards")
            .rowMapper(YgoCardRowMapper())
            .build()

}