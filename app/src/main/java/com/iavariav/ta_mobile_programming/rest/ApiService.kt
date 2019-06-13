package com.iavariav.ta_mobile_programming.rest

import com.iavariav.ta_mobile_programming.model.RootJadwalKuliah
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

interface ApiService {

    //    http://informatika.upgris.ac.id/mobile/data/index.php/api/example/detil_jadwal?key=33c227f799464dac08f60f1b0d5770&npm=16670025
    @GET("detil_jadwal?")
    fun getProfil(
        @Query("key") key: String,
        @Query("npm") npm: String
    ): Observable<RootJadwalKuliah>

}