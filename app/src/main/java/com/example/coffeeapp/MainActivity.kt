package com.example.coffeeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var total: Double = 10.0
    lateinit var radioButton: RadioButton
    var checkedExtras = ArrayList<String>()
    var number: Int=0
    lateinit var checked1: CheckBox
    lateinit var checked2: CheckBox
    lateinit var checked3: CheckBox
    lateinit var checked4: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val price: TextView = findViewById(R.id.price)
        val seek = findViewById<SeekBar>(R.id.seekBar)
        checked1= findViewById(R.id.sugarbutton)
        checked2 = findViewById(R.id.creambutton)
        checked3= findViewById(R.id.nutbutton)
        checked4 = findViewById(R.id.mintbutton)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            checkRadioButtons(radioGroup,checked1.isChecked,checked2.isChecked,checked3.isChecked,checked4.isChecked,price)

            checked1.setOnCheckedChangeListener { buttonView, isChecked ->
                checkRadioButtons(radioGroup,checked1.isChecked,checked2.isChecked,checked3.isChecked,checked4.isChecked,price)
            }
            checked2.setOnCheckedChangeListener { buttonView, isChecked ->
                checkRadioButtons(radioGroup,checked1.isChecked,checked2.isChecked,checked3.isChecked,checked4.isChecked,price)
            }
            checked3.setOnCheckedChangeListener { buttonView, isChecked ->
                checkRadioButtons(radioGroup,checked1.isChecked,checked2.isChecked,checked3.isChecked,checked4.isChecked,price)
            }
            checked4.setOnCheckedChangeListener { buttonView, isChecked ->
                checkRadioButtons(radioGroup,checked1.isChecked,checked2.isChecked,checked3.isChecked,checked4.isChecked,price)
            }

            seek?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    val seekBarTexti: TextView = findViewById(R.id.num)
                    seekBarTexti.text = "Number: $p1"
                    var lastTotal = total.times(p1)
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

    fun checkCheckBoxes(checkBox1State:Boolean,checkBox2State:Boolean,checkBox3State:Boolean,checkBox4State:Boolean){
        if(checkBox1State){
            total+= 0.0
        }
        if(checkBox2State){
            total+= 0.0
        }
        if(checkBox3State){
            total+= 2.5;
        }
        if(checkBox4State){
            total+= 2.5;
        }
    }

    fun checkRadioButtons(radioGroup: RadioGroup, checkBox1State:Boolean,checkBox2State:Boolean,checkBox3State:Boolean,checkBox4State:Boolean,price:TextView){
        var selectedRadioButton: RadioButton = findViewById(radioGroup.checkedRadioButtonId)
        var radioButtonText = selectedRadioButton.text
        println(radioButtonText)
        when(radioButtonText){
            "Tall" -> {
                println("gets in case 1")
                total = 10.0
                checkCheckBoxes(checkBox1State, checkBox2State, checkBox3State, checkBox4State)
                price.text = total.toString()
            }
            "Grande  +2.5"->{
                println("gets in case 2")
                total = 12.5
                checkCheckBoxes(checkBox1State, checkBox2State, checkBox3State, checkBox4State)
                price.text = total.toString()
            }
            "Venti  +4.75"->{
                println("gets in case 3")
                total = 14.75
                checkCheckBoxes(checkBox1State, checkBox2State, checkBox3State, checkBox4State)
                price.text = total.toString()
            }
        }
    }

    fun submit(view: View){
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val selectedOption: Int = radioGroup.checkedRadioButtonId
        radioButton = findViewById(selectedOption)

        var name: EditText=findViewById(R.id.customerName)
        val price: TextView = findViewById(R.id.price)

        if(name.text.isEmpty() || name.text.startsWith(" ") || name.text.length<3 || number == 0){
            if(number == 0){
                val alertDialogg= AlertDialog.Builder(this)
                alertDialogg.setTitle(R.string.empty_order_title)
                alertDialogg.setMessage(R.string.empty_order_message)
                alertDialogg.show()
            }else {
                val alertDialogg= AlertDialog.Builder(this)
                alertDialogg.setTitle(R.string.empty_name_et_title)
                alertDialogg.setMessage(R.string.empty_name_et_message)
                alertDialogg.show()
            }

        }else {
            val checkBoxList = arrayListOf<CheckBox>()
            checkBoxList.add(checked1)
            checkBoxList.add(checked2)
            checkBoxList.add(checked3)
            checkBoxList.add(checked4)

            checkBoxList.forEach{
                if (it.isChecked){
                    checkedExtras.add(it.text.toString())
                }
            }
            val intent= Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("number", number.toString())
            intent.putExtra("customer_name", name.text.toString())
            intent.putExtra("selectedSize", radioButton.text)
            intent.putExtra("selectedExtras", checkedExtras)
            intent.putExtra("totalPrice", price.text)
            startActivity(intent)
        }
    }
}