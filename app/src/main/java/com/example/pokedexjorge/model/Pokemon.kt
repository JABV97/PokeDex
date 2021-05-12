package com.example.pokedexjorge.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pokemon_table")
class Pokemon (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val base_experience: Int,
): Parcelable


