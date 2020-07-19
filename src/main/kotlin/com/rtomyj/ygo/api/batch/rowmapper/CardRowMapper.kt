package com.rtomyj.ygo.api.batch.rowmapper

import com.rtomyj.ygo.api.batch.model.CardModel
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class CardRowMapper: RowMapper<CardModel>
{

    override fun mapRow(rs: ResultSet, rowNum: Int): CardModel
            = CardModel(rs.getString(1), rs.getString(2))

}