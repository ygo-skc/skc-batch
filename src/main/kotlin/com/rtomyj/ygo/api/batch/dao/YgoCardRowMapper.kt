package com.rtomyj.ygo.api.batch.dao

import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class YgoCardRowMapper: RowMapper<CardModel>
{

    override fun mapRow(rs: ResultSet, rowNum: Int): CardModel {
        return CardModel(rs.getString(1), rs.getString(2))
    }

}