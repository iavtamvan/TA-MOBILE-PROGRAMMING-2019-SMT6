package com.iavariav.ta_mobile_programming.presenter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.iavariav.ta_mobile_programming.adapter.JadwalPribadiAdapter
import com.iavariav.ta_mobile_programming.model.DataItem
import com.iavariav.ta_mobile_programming.rest.ApiService
import com.iavariav.ta_mobile_programming.rest.RetroConfig
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class JadwalKuliahPresenter(
    private var items: ArrayList<DataItem> = arrayListOf(),
    private val context: FragmentActivity?,
    private var rv: RecyclerView,
    private var mAdapter: JadwalPribadiAdapter
) {
    fun getJadwalKuliah() {
        val apiService: ApiService = RetroConfig.provideApi()
        apiService.getProfil("33c227f799464dac08f60f1b0d5770", "16670025")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.data as ArrayList<DataItem>
                rv.layoutManager = LinearLayoutManager(context)
                mAdapter = JadwalPribadiAdapter(items, context)
                rv.adapter = mAdapter
            }, {
                error("Error" + it.message)
            })
    }
}