package com.example.tippingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var tipgroup = 0.00
    var costOfMeal = 0.00
    var tipcost = 0.00
    var totalWithTipcost = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var cost: EditText = findViewById(R.id.txtCost)
        var group: Spinner = findViewById(R.id.txtSpinner)
        var calculate: Button = findViewById(R.id.txtButton)
        var tip: TextView = findViewById(R.id.txtTip)
        var totalWithTip: TextView = findViewById(R.id.txtTotalWTip)

        calculate.setOnClickListener{
            costOfMeal = cost.text.toString().toDouble()
            tipgroup = group.selectedItem.toString().toDouble() * 0.01
            val currency = DecimalFormat("$###,###.00")
            tipcost = costOfMeal * tipgroup
            var tipcostformatted = currency.format(tipcost)
            tip.text = "Tip is $tipcostformatted."
            totalWithTipcost = costOfMeal + tipcost
            var totalWithTipformatted = currency.format(totalWithTipcost)
            totalWithTip.text = "Total with tip is $totalWithTipformatted"

        }


    }
}