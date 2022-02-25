package app.kopikeun.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kopikeun.domain.entity.cafe.Cafe
import app.kopikeun.domain.usecase.SearchCafeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchCafeUseCase: SearchCafeUseCase,
) : ViewModel() {
    val query = mutableStateOf(TextFieldValue(""))
    var progressVisible by mutableStateOf(false)
        private set
    var cafes: List<Cafe> by mutableStateOf(emptyList())
        private set
    var searchError by mutableStateOf("")
        private set
    private var job: Job? = null

    fun searchCafe(keyword: String) {
        job?.cancel()

        job = searchCafeUseCase(
            keyword = keyword,
            scope = viewModelScope,
            onLoading = {
                progressVisible = it
            },
            onSuccess = {
                searchError = ""
                cafes = it.data
            },
            onFailed = {
                searchError = it.msg
            },
            onError = {
                cafes = emptyList()
                searchError = it.toString()
            }
        )
    }

    fun clearSearches() {
        job?.cancel()
        searchError = ""
        cafes = emptyList()
        progressVisible = false
    }
}