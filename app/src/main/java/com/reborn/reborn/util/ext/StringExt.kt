package com.reborn.reborn.util.ext



object StringExt{



    fun convertToTimeSeconds(time : Int) : String{

        val times = time
        val day = times / (60 * 60 * 24)
        val hour = (times - day * 60 * 60 * 24) / (60 * 60)
        val minute = (times - day * 60 * 60 * 24 - hour * 3600) / 60
        val second = times % 60


        return "소요시간 : $minute:$second"

    }

}