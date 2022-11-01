package com.example.submissionproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)

		supportActionBar?.title = "Detail Buku"
		val tvTitle: TextView = findViewById(R.id.tv_title)
		val tvAuthor: TextView = findViewById(R.id.tv_author)
		val tvPublisher: TextView = findViewById(R.id.tv_publisher)
		val tvYear: TextView = findViewById(R.id.tv_year)
		val tvDescription: TextView = findViewById(R.id.tv_description)
		val imgPhoto: ImageView = findViewById(R.id.iv_detail_image)

		tvTitle.text = intent.getStringExtra("title")
		tvAuthor.text = intent.getStringExtra("author")
		tvPublisher.text = intent.getStringExtra("publisher")
		tvYear.text = intent.getIntExtra("year", 0).toString()
		tvDescription.text = intent.getStringExtra("description")
		imgPhoto.setImageResource(intent.getIntExtra("image", 0))

	}
}