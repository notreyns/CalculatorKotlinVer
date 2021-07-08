package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var firstNum: EditText
    private lateinit var secondNum: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNum= findViewById(R.id.first_input_text_view)
        secondNum= findViewById(R.id.second_input_text_view)



    }

    fun division(view: View) {
        if(firstNum.text.toString().trim().isNotEmpty() && secondNum.text.toString().trim().isNotEmpty()){
            var result: Double = firstNum.text.toString().toDouble()/secondNum.text.toString().toDouble()
            goToNewActivity(result)
        }else{
            setErrorMsg()
        }
    }

    private fun setErrorMsg() {
        if(secondNum.text.isEmpty()){
            secondNum.setError("Please, enter the number")
            secondNum.requestFocus()
            return;
        }
        if(firstNum.text.isEmpty()){
            firstNum.setError("Please, enter the number")
            firstNum.requestFocus()
            return;
        }
    }

    fun product(view: View) {
        if(firstNum.text.toString().trim().isNotEmpty() && secondNum.text.toString().trim().isNotEmpty()){
            var result: Double = firstNum.text.toString().toDouble()*secondNum.text.toString().toDouble()
            goToNewActivity(result)
        }else{
            setErrorMsg()
        }
    }
    fun sum(view: View) {
        if(firstNum.text.toString().trim().isNotEmpty() && secondNum.text.toString().trim().isNotEmpty()){
            var result: Double = firstNum.text.toString().toDouble()+secondNum.text.toString().toDouble()
            goToNewActivity(result)
        }else{
            setErrorMsg()
        }
    }
    fun difference(view: View) {
        if(firstNum.text.toString().trim().isNotEmpty() && secondNum.text.toString().trim().isNotEmpty()){
            var result: Double = firstNum.text.toString().toDouble()-secondNum.text.toString().toDouble()
            goToNewActivity(result)
        }else{
            setErrorMsg()
        }
    }
    private fun goToNewActivity(result:Double) {
        var intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("result",result.toString())
        }
        startActivity(intent)
    }
}