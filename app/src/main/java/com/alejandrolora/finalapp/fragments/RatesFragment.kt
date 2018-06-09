package com.alejandrolora.finalapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alejandrolora.finalapp.R
import com.alejandrolora.finalapp.adapters.RatesAdapter
import com.alejandrolora.finalapp.dialogues.RateDialog
import com.alejandrolora.finalapp.models.Rate
import kotlinx.android.synthetic.main.fragment_rates.view.*

class RatesFragment : Fragment() {

    private lateinit var _view: View

    private lateinit var adapter: RatesAdapter
    private val ratesList: ArrayList<Rate> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _view = inflater.inflate(R.layout.fragment_rates, container, false)

        setUpRecyclerView()
        setUpFab()

        return _view
    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(context)
        adapter = RatesAdapter(ratesList)

        _view.recyclerView.setHasFixedSize(true)
        _view.recyclerView.layoutManager = layoutManager
        _view.recyclerView.itemAnimator = DefaultItemAnimator()
        _view.recyclerView.adapter = adapter
    }

    private fun setUpFab() {
        _view.fabRating.setOnClickListener { RateDialog().show(fragmentManager, "") }
    }
}
