package com.rtomyj.ygo.api.batch.config

import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.database.JdbcCursorItemReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class StepConfig {

    @Autowired
    private lateinit var stepFactory: StepBuilderFactory

    @Autowired
    private lateinit var ygoDatabaseReader: JdbcCursorItemReader<CardModel>

    @Autowired
    private lateinit var ygoItemProcessor: ItemProcessor<CardModel, CardModel>

    @Autowired
    private lateinit var ygoItemWriter: ItemWriter<CardModel>


    @Bean("step1")
    fun parseCardText(): Step = stepFactory
            .get("Card Text Parsing")
            .chunk<CardModel, CardModel>(40)
            .reader(ygoDatabaseReader)
            .processor(ygoItemProcessor)
            .writer(ygoItemWriter)
            .build()

}