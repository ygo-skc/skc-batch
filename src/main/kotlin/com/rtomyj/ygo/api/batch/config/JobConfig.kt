package com.rtomyj.ygo.api.batch.config

import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.database.JdbcCursorItemReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@EnableBatchProcessing
class JobConfig
{

    @Autowired
    private lateinit var jobFactory: JobBuilderFactory

    @Autowired
    private lateinit var stepFactory: StepBuilderFactory

    @Autowired
    private lateinit var ygoDatabaseReader: JdbcCursorItemReader<CardModel>

    @Autowired
    private lateinit var ygoItemProcessor: ItemProcessor<CardModel, CardModel>

    @Autowired
    private lateinit var ygoItemWriter: ItemWriter<CardModel>

    @Bean
    fun testJob(): Job
    {
        return jobFactory
                .get("testJob")
                .incrementer(RunIdIncrementer())
                .flow(step1())
                .end()
                .build()
    }


    @Bean
    fun step1(): Step
    {
        return stepFactory
                .get("step1")
                .chunk<CardModel, CardModel>(2)
                .reader(ygoDatabaseReader)
                .processor(ygoItemProcessor)
                .writer(ygoItemWriter)
                .build()
    }

}