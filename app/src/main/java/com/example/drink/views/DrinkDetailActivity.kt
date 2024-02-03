package com.example.drink.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.drink.R
import com.squareup.picasso.Picasso

class DrinkDetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_detail)

        val back_btn: ImageView = findViewById(R.id.back_btn)
        val drink_image : ImageView = findViewById(R.id.drink_image)
        val drink_name : TextView = findViewById(R.id.drink_name)
        val alcoholic_name : TextView = findViewById(R.id.alcoholic_name)
        val category : TextView = findViewById(R.id.category)
        val glass : TextView = findViewById(R.id.glass)
        val instruction : TextView = findViewById(R.id.instruction)
        val ingredient_1 : TextView = findViewById(R.id.ingredient_1)
        val ingredient_2 : TextView = findViewById(R.id.ingredient_2)
        val ingredient_3 : TextView = findViewById(R.id.ingredient_3)
        val ingredient_4 : TextView = findViewById(R.id.ingredient_4)
        val ingredient_5 : TextView = findViewById(R.id.ingredient_5)
        val measure_1 : TextView = findViewById(R.id.measure_1)
        val measure_2 : TextView = findViewById(R.id.measure_2)
        val measure_3 : TextView = findViewById(R.id.measure_3)
        val measure_4 : TextView = findViewById(R.id.measure_4)
        val measure_5 : TextView = findViewById(R.id.measure_5)

        back_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val DrinkImage = intent.getStringExtra("DrinkImage")
        val DrinkName = intent.getStringExtra("DrinkName")
        val Alcoholic = intent.getStringExtra("Alcoholic")
        val Category = intent.getStringExtra("Category")
        val Glass = intent.getStringExtra("Glass")
        val Instruction = intent.getStringExtra("Instruction")
        val ingredient1 = intent.getStringExtra("ingredient_1")
        val ingredient2 = intent.getStringExtra("ingredient_2")
        val ingredient3 = intent.getStringExtra("ingredient_3")
        val ingredient4 = intent.getStringExtra("ingredient_4")
        val ingredient5 = intent.getStringExtra("ingredient_5")
        val measure1 = intent.getStringExtra("measure_1")
        val measure2 = intent.getStringExtra("measure_2")
        val measure3 = intent.getStringExtra("measure_3")
        val measure4 = intent.getStringExtra("measure_4")
        val measure5 = intent.getStringExtra("measure_5")

        if (DrinkImage != null){
            Picasso.get().load(DrinkImage).into(drink_image)
        } else {
            Picasso.get().load(R.drawable.default_image).into(drink_image)
        }

        drink_name.text = DrinkName
        alcoholic_name.text = Alcoholic
        category.text = Category
        glass.text = Glass
        instruction.text = Instruction
        ingredient_1.text = "Ingredient 1 - $ingredient1"
        ingredient_2.text = "Ingredient 2 - $ingredient2"
        ingredient_3.text = "Ingredient 3 - $ingredient3"
        measure_1.text = "Measure 1 - $measure1"
        measure_2.text = "Measure 2 - $measure2"
        measure_3.text = "Measure 3 - $measure3"

        if (ingredient4 != null){
            ingredient_4.text = "Ingredient 4 - $ingredient4"
        } else {
            ingredient_4.visibility = View.GONE
        }

        if (ingredient5 != null){
            ingredient_5.text = "Ingredient 5 - $ingredient5"
        } else {
            ingredient_5.visibility = View.GONE
        }

        if (measure4 != null){
            measure_4.text = "Measure 4 - $measure4"
        } else {
            measure_4.visibility = View.GONE
        }

        if (measure5 != null){
            measure_5.text = "Measure 5 - $measure5"
        } else {
            measure_5.visibility = View.GONE
        }

    }
}