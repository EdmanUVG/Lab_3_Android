package com.example.lab_3_android

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.lab_3_android.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var esVisible = true
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.model = Model("Edman", "Edad")

        btn_indicaciones.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
//            val  message: String = "Indicaciones"
//            intent.putExtra("Message", message)
            startActivity(intent)
        }

        btn_sintomas.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
//            val  message: String = "Sintomas"
//            intent.putExtra("Message", message)
            startActivity(intent)
        }

        btn_virus.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
//            val  message: String = "Virus"
//            intent.putExtra("Message", message)
            startActivity(intent)
        }
    }


    @SuppressLint("SetTextI18n")
    fun mostrarRiesgo(view: View) {

        if(!editText_name.text.toString().isEmpty() && !editText_edad.text.toString().isEmpty()) {
            val edad:Double = editText_edad.text.toString().toDouble()
            if (edad in 1.0..150.0) {
                // CAMBIAR a INVISIBLE los Views en pantalla
                if(esVisible == true) {
                    text_coronavirus.visibility = View.INVISIBLE
                    text_nombre.visibility = View.INVISIBLE
                    text_edad.visibility = View.INVISIBLE
                    editText_name.visibility = View.INVISIBLE
                    editText_edad.visibility = View.INVISIBLE
                    text_descripcion.visibility = View.VISIBLE

                    text_descripcion.text = editText_name.text.toString() + getText(R.string.mensaje_alto_riesgo)

                    editText_name.text = null
                    editText_edad.text = null
                    esVisible = false
                    
                } else {
                    text_coronavirus.visibility = View.VISIBLE
                    text_nombre.visibility = View.VISIBLE
                    text_edad.visibility = View.VISIBLE
                    editText_name.visibility = View.VISIBLE
                    editText_edad.visibility = View.VISIBLE
                    text_descripcion.visibility = View.INVISIBLE
                    esVisible = true
                }
            } else {
                Toast.makeText(applicationContext, R.string.edad_fuera_rango, Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(applicationContext, R.string.campo_vacio, Toast.LENGTH_LONG).show()
        }


    }
}
