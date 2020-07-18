package com.rtomyj.ygo.api.batch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class Test {

    @Autowired
    lateinit var dao: Dao

//    @PostConstruct
//    fun test()
//    {
//        dao.test()
//    }

}