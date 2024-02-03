package com.example.drink.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.drink.R
import com.example.drink.model.Drink
import com.example.drink.views.DrinkDetailActivity
import com.squareup.picasso.Picasso

class HomeAdapter(private val drinks: List<Drink>, private val context: Context, ) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {


    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.drink_name)
        val image: ImageView = itemView.findViewById(R.id.drink_image)
        val card: CardView = itemView.findViewById(R.id.cd)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_layout, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val Drink = drinks[position]
        holder.name.text = Drink.strDrink
        Picasso.get().load(Drink.strDrinkThumb).into(holder.image)

        holder.card.setOnClickListener {
            val intent = Intent(context, DrinkDetailActivity::class.java).apply {
                putExtra("DrinkImage", Drink.strDrinkThumb)
                putExtra("DrinkName", Drink.strDrink)
                putExtra("Alcoholic", Drink.strAlcoholic)
                putExtra("Category", Drink.strCategory)
                putExtra("Glass", Drink.strGlass)
                putExtra("Instruction", Drink.strInstructions)
                putExtra("ingredient_1", Drink.strIngredient1)
                putExtra("ingredient_2", Drink.strIngredient2)
                putExtra("ingredient_3", Drink.strIngredient3)
                putExtra("ingredient_4", Drink.strIngredient4)
                putExtra("ingredient_5", Drink.strIngredient5)
                putExtra("measure_1", Drink.strMeasure1)
                putExtra("measure_2", Drink.strMeasure2)
                putExtra("measure_3", Drink.strMeasure3)
                putExtra("measure_4", Drink.strMeasure4)
                putExtra("measure_5", Drink.strMeasure5)
            }
            context.startActivity(intent)
        }
    }
}