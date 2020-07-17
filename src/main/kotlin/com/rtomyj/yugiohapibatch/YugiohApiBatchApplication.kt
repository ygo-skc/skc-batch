package com.rtomyj.yugiohapibatch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YugiohApiBatchApplication

fun main(args: Array<String>) {
	runApplication<YugiohApiBatchApplication>(*args)
}
