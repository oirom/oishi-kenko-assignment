package com.oishikenko.android.recruitment.data.repository

import com.oishikenko.android.recruitment.data.model.CookingRecords
import com.oishikenko.android.recruitment.data.network.CookingRecordsNetworkApi
import kotlinx.coroutines.delay
import javax.inject.Inject

class CookingRecordsRepositoryImpl @Inject constructor (
    var cookingRecordsNetworkApi: CookingRecordsNetworkApi
): CookingRecordsRepository {
    override suspend fun getCookingRecords(offset: Int, limit: Int): CookingRecords {
        delay(2000L)
        return cookingRecordsNetworkApi.getCookingRecords(offset = offset, limit = limit)
    }
}