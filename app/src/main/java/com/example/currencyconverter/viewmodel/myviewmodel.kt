package com.example.currencyconverter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.commonstate.ResultState
import com.example.currencyconverter.data.DataResponse
import com.example.currencyconverter.repository.repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class myviewmodel: ViewModel() {
    val repo = repo()
    private val _state1= MutableStateFlow(Ratesstate())
    val state1 = _state1.asStateFlow()
    private val _state2= MutableStateFlow(convertRates())
    val state2 = _state2.asStateFlow()
     fun getrates() {
         viewModelScope.launch(Dispatchers.IO) {
             repo.getRates().collect {
                 when (it) {
                     is ResultState.Success -> {
                         _state1.value = Ratesstate(rates = it.data, loading = false)
                     }

                     is ResultState.Error -> {
                         _state1.value = Ratesstate(error = it.exception.message)
                     }

                     is ResultState.Loading -> {
                         _state1.value = Ratesstate(loading = true)
                     }
                 }
             }
         }
     }
     fun getrates(base: String) {
         viewModelScope.launch(Dispatchers.IO) {
             repo.getRates(base).collect {
                 when (it) {
                     is ResultState.Success -> {
                         _state2.value = convertRates(rates = it.data, loading = false)
                     }

                     is ResultState.Error -> {
                         _state2.value = convertRates(error = it.exception.message)
                     }

                     is ResultState.Loading -> {
                         _state2.value = convertRates(loading = true)
                     }
                 }
             }
         }
     }

}
data class  Ratesstate(
    val loading: Boolean = false,
    val rates: DataResponse? = null,
    val error: String? = null

    )
data class  convertRates(
    val loading: Boolean = false,
    val rates: DataResponse? = null,
    val error: String? = null
)