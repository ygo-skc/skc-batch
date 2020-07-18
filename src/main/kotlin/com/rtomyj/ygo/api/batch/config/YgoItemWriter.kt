package com.rtomyj.ygo.api.batch.config

import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Configuration


@Configuration
class YgoItemWriter: ItemWriter<CardModel> {
    override fun write(items: MutableList<out CardModel>) {
        println("writer invoked")
    }
}