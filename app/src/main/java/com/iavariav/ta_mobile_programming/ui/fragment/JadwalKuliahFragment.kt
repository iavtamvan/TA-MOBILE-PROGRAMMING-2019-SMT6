package com.iavariav.ta_mobile_programming.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.iavariav.ta_mobile_programming.R
import com.iavariav.ta_mobile_programming.adapter.JadwalPribadiAdapter
import com.iavariav.ta_mobile_programming.helper.Config
import com.iavariav.ta_mobile_programming.model.DataItem
import com.iavariav.ta_mobile_programming.presenter.JadwalKuliahPresenter
import kotlinx.android.synthetic.main.fragment_jadwal_kuliah.view.*

/**
 * A simple [Fragment] subclass.
 * Generate by iav
 */
class JadwalKuliahFragment : Fragment() {
    private lateinit var jadwalPribadiAdapter: JadwalPribadiAdapter
    private lateinit var jadwalKuliahPresenter: JadwalKuliahPresenter
    private var dataItem: ArrayList<DataItem> = ArrayList()

    private lateinit var npm:String
    private lateinit var key:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_jadwal_kuliah, container, false)
        val rv = view.rv
        npm = activity?.intent!!.getStringExtra(Config.BUNDLE_NPM)
        key = activity?.intent!!.getStringExtra(Config.BUNDLE_KEY)
        jadwalPribadiAdapter = JadwalPribadiAdapter(
            dataItem, activity)
        jadwalKuliahPresenter = JadwalKuliahPresenter(
            dataItem, activity, rv, jadwalPribadiAdapter)
        jadwalKuliahPresenter.getJadwalKuliah(key, npm)
        return view;
    }


}
