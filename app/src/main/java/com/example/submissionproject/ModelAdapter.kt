package com.example.submissionproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ModelAdapter(private val listModel: ArrayList<Model>) :
	RecyclerView.Adapter<ModelAdapter.ViewHolder>() {

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
		var tvDescription: TextView = itemView.findViewById(R.id.tv_description)
		var imgPhoto: ImageView = itemView.findViewById(R.id.iv_image)
		var btnDetail: Button = itemView.findViewById(R.id.btn_card)
	}

	override fun getItemCount(): Int {
		return listModel.size
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val model = listModel[position]
		holder.tvTitle.text = model.title
		holder.tvDescription.text = model.description
		holder.imgPhoto.setImageResource(model.image)

		holder.btnDetail.setOnClickListener {
			val context = holder.itemView.context
			val intent = android.content.Intent(context, DetailActivity::class.java)
			intent.putExtra("title", model.title)
			intent.putExtra("description", model.description)
			intent.putExtra("image", model.image)
			intent.putExtra("author", model.author)
			intent.putExtra("publisher", model.publisher)
			intent.putExtra("year", model.year)
			context.startActivity(intent)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view: View =
			LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
		return ViewHolder(view)
	}
}