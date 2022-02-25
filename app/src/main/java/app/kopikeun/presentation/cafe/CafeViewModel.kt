package app.kopikeun.presentation.cafe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kopikeun.domain.entity.cafe.CafeDetail
import app.kopikeun.domain.usecase.GetCafeInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CafeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getCafeInfoUseCase: GetCafeInfoUseCase,
) : ViewModel() {
    var cafeDetail by mutableStateOf<CafeDetail?>(null)
        private set
    var progress by mutableStateOf(true)
        private set
    var error by mutableStateOf("")
        private set
    private var job: Job? = null

    fun getCafeDetail(cafeId: Int) {
        job?.cancel()

        job = getCafeInfoUseCase(
            cafeId = cafeId,
            scope = viewModelScope,
            onLoading = {
                progress = it
            },
            onSuccess = {
                error = ""
                cafeDetail = it.data
                Timber.i("${it.data}")
            },
            onFailed = {
                error = it.msg
            },
            onError = {
                cafeDetail = null
                error = it.toString()
            }
        )
    }
}