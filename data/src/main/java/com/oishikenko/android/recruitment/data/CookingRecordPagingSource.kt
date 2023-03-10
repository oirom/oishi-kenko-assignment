package com.oishikenko.android.recruitment.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.oishikenko.android.recruitment.data.model.CookingRecord
import com.oishikenko.android.recruitment.data.repository.CookingRecordsRepository

class CookingRecordPagingSource(
    private val repository: CookingRecordsRepository
): PagingSource<Int, CookingRecord>() {
    override fun getRefreshKey(state: PagingState<Int, CookingRecord>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CookingRecord> {
        return try {

            val offset = params.key ?: 0
            val response = repository.getCookingRecords(offset, 10)

            LoadResult.Page(
                data = response.cookingRecords,
                prevKey = null,
                nextKey = if (response.cookingRecords.isNotEmpty()) offset + 10 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}