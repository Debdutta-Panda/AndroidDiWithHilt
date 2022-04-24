package com.debduttapanda.androiddiwithhilt

interface CryptocurrencyRepository {
    suspend fun getCryptoCurrency(): List<Cryptocurrency>
}