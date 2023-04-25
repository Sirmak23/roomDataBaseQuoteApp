package com.irmak.roomdatabasequoteapp.data.local.typeCoverter

import androidx.room.TypeConverter
import java.util.Date

class DateTimeConverter {
@TypeConverter
    fun convertToTimeStamp(date:Date):Long{
        return date.time
    }

    fun convertToDate(timeStamp:Long):Date{
        return Date(timeStamp)
    }
}