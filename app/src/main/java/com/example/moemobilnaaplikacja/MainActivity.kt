package com.example.moemobilnaaplikacja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Toast
import java.lang.NullPointerException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class StackWithList{
            val elements: MutableList<Any> = mutableListOf()

            fun isEmpty() = elements.isEmpty()

            fun size() = elements.size

            fun push(item: Any) = elements.add(item)

            fun pop() : Any? {
                val item = elements.lastOrNull()
                if (!isEmpty()){
                    elements.removeAt(elements.size -1)
                }
                return item
            }
            fun peek() : Any? = elements.lastOrNull()

            override fun toString(): String = elements.toString()
        }
        var stacklist  = StackWithList()

        fun DzialanieDodawanie(){
            if (findViewById<RadioButton>(R.id.radioButton).isChecked == true) {


            } else if (findViewById<RadioButton>(R.id.radioButton2).isChecked == true) {
                if(findViewById<EditText>(R.id.editTextNumber).text.toString()!= ""){
                    stacklist.push(findViewById<EditText>(R.id.editTextNumber).text)
                    findViewById<TextView>(R.id.textView).text = "Wartość została dodana"
                }
                else{
                    findViewById<TextView>(R.id.textView).text = "Okno jest puste"
                }
            }
        }
        fun DzalanieOdejmowanie() {
            if (findViewById<RadioButton>(R.id.radioButton).isChecked == true) {


            } else if (findViewById<RadioButton>(R.id.radioButton2).isChecked == true) {
                if(stacklist.isEmpty() == true){
                    findViewById<TextView>(R.id.textView).text = "Stos jest pusty"
                }
                else {
                    findViewById<TextView>(R.id.textView).text = "Usunięto: " + stacklist.pop()

                }
            }
        }
        findViewById<Button>(R.id.button).setOnClickListener{
            DzialanieDodawanie()
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            DzalanieOdejmowanie()
        }
        findViewById<Button>(R.id.button3).setOnClickListener{
            if(stacklist.isEmpty() == true){
                findViewById<TextView>(R.id.textView).text = "Stos jest pusty"
            }
            else if (stacklist.isEmpty() == false) {
                findViewById<TextView>(R.id.textView).text = stacklist.peek().toString()
            }
        }
        findViewById<RadioButton>(R.id.radioButton2).setOnClickListener{
            findViewById<Button>(R.id.button3).visibility = View.VISIBLE
        }
        findViewById<RadioButton>(R.id.radioButton).setOnClickListener {
            findViewById<Button>(R.id.button3).visibility = View.INVISIBLE
        }
    }
}