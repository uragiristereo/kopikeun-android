package app.kopikeun.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import app.kopikeun.common.Constant
import app.kopikeun.domain.entity.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var selectedCafeId by mutableStateOf(savedStateHandle.get<Int>(Constant.STATE_SELECTED_CAFE) ?: 0)
        private set
    var selectedPhotoList by mutableStateOf(savedStateHandle.get<List<Photo>>(Constant.STATE_PHOTO_LIST) ?: emptyList())
        private set
    var selectedPhotoUrl by mutableStateOf(savedStateHandle.get<String>(Constant.STATE_SELECTED_PHOTO_URL) ?: "")
        private set

    fun setSelectedCafe(cafeId: Int) {
        selectedCafeId = cafeId
        savedStateHandle.set(Constant.STATE_SELECTED_CAFE, cafeId)
    }

    fun setSelectedPhotos(photoList: List<Photo>) {
        selectedPhotoList = photoList
        savedStateHandle.set(Constant.STATE_PHOTO_LIST, photoList)
    }

    fun setSelectedPhoto(photoUrl: String) {
        selectedPhotoUrl = photoUrl
        savedStateHandle.set(Constant.STATE_SELECTED_PHOTO_URL, photoUrl)
    }
}