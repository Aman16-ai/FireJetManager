package com.example.mvvmnote.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize


@Entity(tableName = "new_note_table")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    @ColumnInfo(name = "Title")
    var title:String,
    @ColumnInfo(name="Body")
    var body:String
):Parcelable


