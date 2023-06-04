package com.app.modul9.network

import com.app.modul9.model.response.ResponseDataMahasiswa
import com.app.modul9.model.response.ResponseDetailMahasiswa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET ("sub/restapi-slim/public/datamahasiswa/")
    fun getDataMahasiswa() : Call<ResponseDataMahasiswa>

    @GET ("sub/restapi-slim/public/datamahasiswa/{nim}")
    fun getDetailMahasiswa(@Path("nim")nim : String) : Call<ResponseDetailMahasiswa>
}