package app.kopikeun.domain.usecase

import app.kopikeun.common.enqueue
import app.kopikeun.data.model.SearchResponse
import app.kopikeun.data.repository.NetworkRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class SearchCafeUseCase @Inject constructor(
    private val networkRepository: NetworkRepository,
) {
    operator fun invoke(
        keyword: String,
        limit: Int = 10,
        scope: CoroutineScope,
        onLoading: (Boolean) -> Unit,
        onSuccess: (SearchResponse) -> Unit,
        onFailed: (SearchResponse) -> Unit,
        onError: (Throwable) -> Unit,
    ): Job {
        return scope.launch {
            onLoading(true)

            delay(400)

            try {
                networkRepository.api.getCafesByKeyword(keyword, limit).enqueue(
                    onLoading = onLoading,
                    onSuccess = onSuccess,
                    onFailed = onFailed,
                )
            } catch (t: Throwable) {
                when (t) {
                    is CancellationException -> {}
                    else -> {
                        onLoading(false)
                        onError(t)
                    }
                }
            }
        }
    }
}