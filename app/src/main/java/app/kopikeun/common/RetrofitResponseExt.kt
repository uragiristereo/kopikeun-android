package app.kopikeun.common

import retrofit2.Response

fun <T> Response<T>.enqueue(
    onLoading: (Boolean) -> Unit,
    onSuccess: (T) -> Unit,
    onFailed: (T) -> Unit,
) {
    onLoading(true)

    val response = this@enqueue

    response.body()?.let {
        onLoading(false)

        if (response.isSuccessful)
            onSuccess(it)
        else
            onFailed(it)
    }
}