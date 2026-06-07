package com.example.currencyconverter.repository

import com.example.currencyconverter.Network.Apiprovider
import com.example.currencyconverter.commonstate.ResultState
import com.example.currencyconverter.data.DataResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class repo {
    suspend fun getRates(): Flow<ResultState<DataResponse>> = flow {
        emit(ResultState.Loading)
        try {
            val response = Apiprovider.provideApi().getRates()
            if (response.isSuccessful && response.body() != null) {
                emit(ResultState.Success(response.body()!!))
            } else {
                emit(ResultState.Error(Exception("Error: ${response.code()} ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(ResultState.Error(e))
        }
    }

    suspend fun getRates(base: String): Flow<ResultState<DataResponse>> = flow {
        emit(ResultState.Loading)
        try {
            val response = Apiprovider.provideApi().getRates(base)
            if (response.isSuccessful && response.body() != null) {
                emit(ResultState.Success(response.body()!!))
            } else {
                emit(ResultState.Error(Exception("Error: ${response.code()} ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(ResultState.Error(e))
        }
    }


}


