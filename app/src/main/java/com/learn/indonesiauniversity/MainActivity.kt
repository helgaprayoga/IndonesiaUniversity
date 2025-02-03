package com.learn.indonesiauniversity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.indonesiauniversity.ListUniversityAdapter
import com.learn.indonesiauniversity.R
import com.learn.indonesiauniversity.University
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var rvUniversities: RecyclerView
    private val list = ArrayList<University>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUniversities = findViewById(R.id.rv_university)
        rvUniversities.setHasFixedSize(true)


        list.addAll(getListUniversity())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutMeActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListUniversity(): ArrayList<University> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listUniversity = ArrayList<University>()
        for (i in dataName.indices) {
            val hero = University(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listUniversity.add(hero)
        }
        return listUniversity
    }

    private fun showRecyclerList() {
        rvUniversities.layoutManager = LinearLayoutManager(this)
        val listUniversityAdapter = ListUniversityAdapter(list)
        rvUniversities.adapter = listUniversityAdapter

        listUniversityAdapter.setOnItemClickCallback(object : ListUniversityAdapter.OnItemClickCallback {
            override fun onItemClicked(data: University) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("EXTRA_UNIVERSITY", data)
                startActivity(intent)
            }
        })
    }

    private fun showSelectedUniversity(university: University) {
        Toast.makeText(this, "Kamu memilih " + university.name, Toast.LENGTH_SHORT).show()
    }

}