package com.example.teamdraw.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.teamdraw.models.Contest

@Entity(tableName = "contest_table")
class ContestsEntity(
    var contest: Contest
) {
    @PrimaryKey()
    var id: Long = 0L
}