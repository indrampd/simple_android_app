package com.example.submissionproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
	private lateinit var rvModel: RecyclerView
	private var arrayList: ArrayList<Model> = arrayListOf()

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.action_menu, menu)
		return super.onCreateOptionsMenu(menu)
	}

	// Profile Menu when Selected
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.about_page -> {
				val intent = Intent(this@MainActivity, AboutPage::class.java)
				this.startActivity(intent)
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		rvModel = findViewById(R.id.recyclerView)
		rvModel.setHasFixedSize(true)

		arrayList.addAll(ObjectModel.listData)

		rvModel.layoutManager = LinearLayoutManager(this)
		rvModel.adapter = ModelAdapter(arrayList)


	}


}