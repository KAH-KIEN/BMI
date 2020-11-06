package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

// variableName : Type
// val = value(after we assign, we dont change it), var = variable(can make changes)
// E.g. val pi = 3.142
// E.g. var number: Float

class MainActivity : AppCompatActivity() {
    //Global variable
    //lateinit = late initialize
    //private = access modifier
    private lateinit var imageViewBMI: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Display the UI
        //R = resources class (res  folder)
        setContentView(R.layout.activity_main)
        //Link UI to the program code
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        imageViewBMI = findViewById(R.id.imageViewBMI)


        buttonReset.setOnClickListener{
            editTextWeight.text = null
            editTextHeight.text.clear() // claer text for edit text
            textViewBMI.text = "" // claer text for text view
            imageViewBMI.setImageResource(R.drawable.empty)
        }

        buttonCalculate.setOnClickListener {
            //To retrieve value from a View
            //Alt + Enter to automatically import the library (button)
            val weight: Float = editTextWeight.text.toString().toFloat()
            val height: Float = editTextHeight.text.toString().toFloat()

            //BMI = kg/m pow2
            val bmi = weight/(height/100).pow(2)

            if (bmi <= 18.5){
                //textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.underweight))
                textViewBMI.text = "BMI : ${bmi.toString().toFloat()}, Status : ${getString(R.string.underweight)}"
                imageViewBMI.setImageResource(R.drawable.under)
            }
            else if (bmi in 18.6..24.9){
                //textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.normal))
                textViewBMI.text = "BMI : ${bmi.toString()}, Status : ${getString(R.string.normal)}"
                imageViewBMI.setImageResource(R.drawable.normal)
            }
            else{
                //textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.overweight))
                textViewBMI.text = "BMI : ${bmi.toString()}, Status : ${getString(R.string.overweight)}"
                imageViewBMI.setImageResource(R.drawable.over)
            }

        }//end of onClickListener


    }//end of Function
}//end of Class