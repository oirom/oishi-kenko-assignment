package com.oishikenko.android.recruitment.data.repository

import com.oishikenko.android.recruitment.data.model.CookingRecords

interface CookingRecordsRepository {
    suspend fun getCookingRecords(offset: Int, limit: Int): CookingRecords
}