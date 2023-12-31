package com.karatas.recyclerviewappkotlin

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karatas.recyclerviewappkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        val ankara = Landmark("Ankara","Turkiye",R.drawable.ankara)
        val istanbul = Landmark("Istanbul","Turkiye",R.drawable.istanbul)
        val izmir = Landmark("Izmir","Turkiye",R.drawable.izmir)
        val osmancik = Landmark("Osmancik","Turkiye",R.drawable.osmancik)

        landmarkList.add(ankara)
        landmarkList.add(istanbul)
        landmarkList.add(izmir)
        landmarkList.add(osmancik)

        //RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = adapter
        /*
        //Adapter: Layout & Data

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })

        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList[position])
            //MySingleton.selectedLandmark = landmarkList[position]
            startActivity(intent)
        }

         */

    }
}