package com.rtomyj.ygo.api.batch

import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.batch.core.JobExecution
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.test.context.junit4.SpringRunner


@SpringBootTest	// needed for @Value to work
@SpringBatchTest
@RunWith(SpringRunner::class)
@ActiveProfiles("test")
@SqlGroup(value = [
	Sql("classpath:drop.sql")
	, Sql("classpath:schema.sql")
	, Sql("classpath:data.sql")
])
class YugiohApiBatchApplicationTests {

	@Value("\${spring.datasource.url}")
	lateinit var test: String


	@Autowired
	lateinit var jobLauncherTestUtils: JobLauncherTestUtils

	@Test
	fun contextLoads() {

		val jobExecution: JobExecution = jobLauncherTestUtils.launchJob()
		Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());


	}

}
