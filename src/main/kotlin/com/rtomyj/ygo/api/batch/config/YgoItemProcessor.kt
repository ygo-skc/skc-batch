package com.rtomyj.ygo.api.batch.config

import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration


@Configuration
class YgoItemProcessor: ItemProcessor<CardModel, CardModel>
{
    override fun process(item: CardModel): CardModel? {
        println(item)

        return item
    }

}