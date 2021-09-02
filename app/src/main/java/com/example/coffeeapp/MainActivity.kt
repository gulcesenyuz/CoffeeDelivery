package com.example.coffeeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var total: Double = 10.0
    var lastTotal: Double = 0.0
    lateinit var radioButton: RadioButton
    var checkedExtras = ArrayList<String>()
    var number: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
            checkedExtras.add(checked1.text as String)
                total += 0.0
                println("3: $total")

                println(total)
                price.text = total.toString()

            }
            checked2.setOnCheckedChangeListener { buttonView, isChecked ->
                checkedExtras.add(checked2.text as String)

                total += 0.0
                println("3: $total")

                println(total)
                price.text = total.toString()

            }
            checked3.setOnCheckedChangeListener { buttonView, isChecked ->
                checkedExtras.add(checked3.text as String)

                println("durum : " + checked4.isChecked)

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
                println("durum : " + checked4.isChecked)
                checkedExtras.add(checked4.text as String)

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
                    lastTotal = total.times(p1)
                    number= p1

                    price.text = lastTotal.toString()


                }

                override fun onStartTrackingTouch(seek: SeekBar) {
                }

                override fun onStopTrackingTouch(seek: SeekBar) {

                }
            })


        }


    }

    fun submit(view: View){
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val selectedOption: Int = radioGroup.checkedRadioButtonId
        var name: EditText=findViewById(R.id.customerName)
        val price: TextView = findViewById(R.id.price)

        val intent= Intent(applicationContext, SecondPage::class.java)
        radioButton = findViewById(selectedOption)
        for( item in checkedExtras ){
            print("5555    ")
            println(item)

        }
        intent.putExtra("customer_name", name.text.toString())
        intent.putExtra("selectedSize", radioButton.text)
        intent.putExtra("selectedExtras", checkedExtras)
        println("number:  ${number}")
        intent.putExtra("totalPrice", price.text)
        intent.putExtra("number", number.toString())

        startActivity(intent)

    }
}

