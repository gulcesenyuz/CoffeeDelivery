package com.example.coffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    var total: Double = 10.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("----------------------")

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val price: TextView = findViewById(R.id.price)
        val seek = findViewById<SeekBar>(R.id.seekBar)
        var checked1: CheckBox = findViewById(R.id.sugarbutton)
        var checked2: CheckBox = findViewById(R.id.creambutton)
        var checked3: CheckBox = findViewById(R.id.nutbutton)
        var checked4: CheckBox = findViewById(R.id.mintbutton)



        radioGroup.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId == R.id.tallbutton) {
                total = 10.0
                total += 0.0
                if(checked1.isChecked){
                    checked1.toggle()

                    total=10.0

                }
                if(checked2.isChecked){
                    checked2.toggle()
                    total=10.0


                }
                if(checked3.isChecked){
                    checked3.toggle()
                    total=10.0


                }
                if(checked4.isChecked){
                    checked4.toggle()
                    total=10.0


                }


                price.text = total.toString()
                //TODO
            } else if (checkedId == R.id.grandebutton) {
                total = 10.0
                total += 2.5
                if(checked1.isChecked){
                    checked1.toggle()

                    total=12.5

                }
                if(checked2.isChecked){
                    checked2.toggle()
                    total=12.5


                }
                if(checked3.isChecked){
                    checked3.toggle()
                    total=12.5


                }
                if(checked4.isChecked){
                    checked4.toggle()
                    total=12.5


                }


                price.text = total.toString()


                //TODO
            } else {
                if(checked1.isChecked){
                    checked1.toggle()

                    total=14.75

                }
                if(checked2.isChecked){
                    checked2.toggle()
                    total=14.75


                }
                if(checked3.isChecked){
                    checked3.toggle()
                    total=14.75


                }
                if(checked4.isChecked){
                    checked4.toggle()
                    total=14.75


                }


                price.text = total.toString()

            }


            checked1.setOnCheckedChangeListener { buttonView, isChecked ->

                total += 0.0
                println("3: $total")

                println(total)
                price.text = total.toString()

            }
            checked2.setOnCheckedChangeListener { buttonView, isChecked ->

                total += 0.0
                println("3: $total")

                println(total)
                price.text = total.toString()

            }
            checked3.setOnCheckedChangeListener { buttonView, isChecked ->

                println("durum : " +checked4.isChecked)

                if (checked3.isChecked) {
                    println(checked4.isChecked)

                    total += 2.5
                    println("ekle: $total")

                    println(total)
                    price.text= total.toString()

                }
                if (!checked3.isChecked) {
                    println(checked4.isChecked)
                    total -= 2.5
                    println("cıkar: $total")

                    println(total)
                    price.text= total.toString()

                }


            }

            checked4.setOnCheckedChangeListener { buttonView, isChecked ->
                println("durum : " +checked4.isChecked)

                 if (checked4.isChecked) {
                     println(checked4.isChecked)

                     total += 2.5
                println("ekle: $total")

                println(total)
                price.text= total.toString()

            }
                if (!checked4.isChecked) {
                    println(checked4.isChecked)
                    total -= 2.5
                    println("cıkar: $total")

                    println(total)
                    price.text= total.toString()

                }


            }





            seek?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    val seekBarTexti: TextView = findViewById(R.id.num)
                    seekBarTexti.setText("Number: $p1")
                }

                override fun onStartTrackingTouch(seek: SeekBar) {
                    // write custom code for progress is started
                }

                override fun onStopTrackingTouch(seek: SeekBar) {

                }
            })


        }


    }
}


