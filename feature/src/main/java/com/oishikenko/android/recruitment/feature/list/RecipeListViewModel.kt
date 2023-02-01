package com.oishikenko.android.recruitment.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.oishikenko.android.recruitment.data.CookingRecordPagingSource
import com.oishikenko.android.recruitment.data.repository.CookingRecordsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private var cookingRecordsRepository: CookingRecordsRepository
) : ViewModel() {
    val cookingRecords = Pager(
        PagingConfig(pageSize = 2)
    ) {
        CookingRecordPagingSource(cookingRecordsRepository)
    }.flow.cachedIn(viewModelScope)
}