package com.rtomyj.ygo.api.batch.processor

import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


@Component
class CardTextParsingProcessor: ItemProcessor<CardModel, CardModel>
{
    override fun process(item: CardModel): CardModel? {
        println(item)

        return item
    }

}