package com.shift.cinemaapp.data


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.shift.cinemaapp.data.model.Film
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface CinemaUiState {
    data class Success(val cinemaSearch: List<Film>) : CinemaUiState
    object Error : CinemaUiState
    object Loading : CinemaUiState
}

class CinemaViewModel(
    private val cinemaRepository: CinemaRepository,
) : ViewModel() {

    /*
      Про отсуствие @composable услышал в View, суть в том что
      жизненный цикл у ViewModel больше чем у самого интрефейса,
      пока не очень понимаю как это исправить ибо опыта не хватает(((
      https://developer.android.com/topic/libraries/architecture/viewmodel?hl=en#implement-viewmodel
    */

    var cinemaUiState: CinemaUiState by mutableStateOf(CinemaUiState.Loading)
        private set
    init {
        getFilm()
    }

    fun getFilm() {
        viewModelScope.launch {
            cinemaUiState = CinemaUiState.Loading
            cinemaUiState =
                try {
                    CinemaUiState.Success(cinemaRepository.getToday())
                } catch (e: IOException) {
                    CinemaUiState.Error
                } catch (e: HttpException) {
                    CinemaUiState.Error
                }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CinemaApplication)
                val cinemaRepository = application.container.cinemaRepository
                CinemaViewModel(cinemaRepository = cinemaRepository)
            }
        }
    }
}