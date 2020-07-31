package com.rtomyj.ygo.api.batch.processor

import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


@Component
class CardTextParsingProcessor: ItemProcessor<CardModel, CardModel>
{
    override fun process(item: CardModel): CardModel? {
        val referenceRegex = Regex("\"[^.,\\s].*?\"+")

//        val results = hashSetOf(referenceRegex.findAll(item.cardEffect, 0).map { it. })
        val results = referenceRegex.findAll(item.cardEffect, 0).map { it.value }.toHashSet()
        print("All references for ${item.cardName}: ")
        for (result in results)
        {
            print("$result &&& ")
        }
        println()
        return item
    }

}