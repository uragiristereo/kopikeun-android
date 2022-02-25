package app.kopikeun.presentation.cafelist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kopikeun.domain.entity.cafe.Cafe
import app.kopikeun.domain.usecase.SearchCafeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class CafeListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchCafeUseCase: SearchCafeUseCase,
) : ViewModel() {
    var loading by mutableStateOf(true)
        private set
    var cafeList: List<Cafe> by mutableStateOf(emptyList())
        private set
    var error by mutableStateOf("")
        private set

    private var job: Job? = null

    init {
        getAllCafes()
    }

    private fun getAllCafes() {
        val count = 0

        job?.cancel()

        job = searchCafeUseCase(
            keyword = "",
            limit = count,
            scope = viewModelScope,
            onLoading = { loading = it },
            onSuccess = {
                error = ""
                cafeList = it.data
            },
            onFailed = {
                error = it.msg
                cafeList = emptyList()
            },
            onError = {
                error = it.toString()
                cafeList = emptyList()
            }
        )

    }
}