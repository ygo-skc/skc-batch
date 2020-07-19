package com.rtomyj.ygo.api.batch.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@EnableBatchProcessing
class JobConfig {

    @Autowired
    private lateinit var jobFactory: JobBuilderFactory

    @Bean
    fun suggestionDatabaseJob(@Autowired @Qualifier("step1") step1: Step): Job = jobFactory
            .get("Build Suggestion Database")
            .incrementer(RunIdIncrementer())
            .flow(step1)
            .end()
            .build()

}