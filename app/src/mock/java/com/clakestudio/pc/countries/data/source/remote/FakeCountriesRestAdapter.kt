package com.clakestudio.pc.countries.data.source.remote

import com.clakestudio.pc.countries.data.Country
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

class FakeCountriesRestAdapter(retrofit: Retrofit) {

        var countriesService: CountriesService

    init {
        countriesService = retrofit.create(CountriesService::class.java)
    }

    interface CountriesService {

        @GET(URLManager.all)
        fun getAllCountries(): Call<Response<List<Country>>>

        @GET(URLManager.name)
        fun getCountryByName(@Path("alpha") name: String): Call<Response<Country>>


    }

    fun getAllCountries() = countriesService.getAllCountries()

    fun getCountryByName(name: String) = countriesService.getCountryByName(name)


}