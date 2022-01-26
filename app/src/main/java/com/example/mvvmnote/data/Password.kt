package com.example.mvvmnote.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "password_table")
@Parcelize
data class Password(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    @ColumnInfo(name="password_name")
    var name:String?=null,
    @ColumnInfo(name="passwords")
    var password:String?=null
):Parcelable {

}