package com.learn.indonesiauniversity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learn.indonesiauniversity.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val university = intent.getParcelableExtra<University>("EXTRA_UNIVERSITY")

        if (university != null) {
            binding.imgDetailPhoto.setImageResource(university.photo)
            binding.tvDetailName.text = university.name
            binding.tvDetailDescription.text = university.description
        }
    }
}