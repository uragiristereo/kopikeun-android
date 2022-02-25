package app.kopikeun.domain.usecase

import app.kopikeun.common.Constant
import app.kopikeun.common.enqueue
import app.kopikeun.data.model.CafeDetailResponse
import app.kopikeun.data.repository.NetworkRepository
import kotlinx.coroutines.*
import javax.inject.Inject


class GetCafeInfoUseCase @Inject constructor(
    private val networkRepository: NetworkRepository,
) {
    operator fun invoke(
        cafeId: Int,
        scope: CoroutineScope,
        onLoading: (Boolean) -> Unit,
        onSuccess: (CafeDetailResponse) -> Unit,
        onFailed: (CafeDetailResponse) -> Unit,
        onError: (Throwable) -> Unit,
    ): Job {
        return scope.launch {
            onLoading(true)

            delay(Constant.NETWORK_DELAY)

            try {
                networkRepository.api.getCafeInfo(cafeId).enqueue(
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