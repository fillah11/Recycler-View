package com.fillah.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Place>

    lateinit var imageId: Array<Int>
    lateinit var named: Array<String>
    lateinit var placeDesc: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        imageId = arrayOf(
            R.drawable.pura_besakih,
            R.drawable.kepulauan_derawan,
            R.drawable.taman_nasional_way_kambas,
            R.drawable.pantai_parai_tenggiri,
            R.drawable.nusa_dua_bali,
            R.drawable.gunung_rinjani,
            R.drawable.danau_toba,
            R.drawable.nusa_penida,
        )

        named = arrayOf(
            "Pura Besakih",
            "Kepulauan Derawan",
            "Taman Nasional Way Kambas",
            "Pantai Parai Tenggiri (Bangka Belitung)",
            "Nusa Dua Bali",
            "Gunung Rinjani (Lombok, NTB)",
            "Danau Toba (Sumatera Utara)",
            "Nusa Penida (Bali)",
        )

        placeDesc = arrayOf(
            getString(R.string.pura),
            getString(R.string.derawan),
            getString(R.string.kambas),
            getString(R.string.tenggiri),
            getString(R.string.dewa),
            getString(R.string.rinjani),
            getString(R.string.toba),
            getString(R.string.penida),

        )

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Place>()
        getUserData()
    }

    private fun getUserData() {

        for (i in imageId.indices) {

            val place = Place(imageId[i], named[i], placeDesc[i])
            newArrayList.add(place)

        }

        newRecyclerView.adapter = MyAdapter(newArrayList)

    }
}