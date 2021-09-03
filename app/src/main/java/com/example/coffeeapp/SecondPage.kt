package com.example.coffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        var name: TextView = findViewById(R.id.name)
        var drinkSize: TextView = findViewById(R.id.size)
        var extra:TextView=findViewById(R.id.extras)
        var priceTotal: TextView=findViewById(R.id.textView6)
        var numDrink: TextView=findViewById(R.id.number)

        val intent=intent
        val customer= intent.getStringExtra("customer_name")
        val size= intent.getStringExtra("selectedSize")
        val extras= intent.getStringArrayListExtra("selectedExtras")
        val total=intent.getStringExtra("totalPrice")
        val num=intent.getStringExtra("number")

        name.text=customer
        drinkSize.text=size
        extra.text= extras.toString()
        priceTotal.text=total
        numDrink.text=num
    }
}