package com.example.appcalcuradorabasica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numeros
        Uno.setOnClickListener { appendOnExpresstion("1", true) }
        Dos.setOnClickListener { appendOnExpresstion("2", true) }
        Tres.setOnClickListener { appendOnExpresstion("3", true) }
        Cuatro.setOnClickListener { appendOnExpresstion("4", true) }
        Cinco.setOnClickListener { appendOnExpresstion("5", true) }
        Seis.setOnClickListener { appendOnExpresstion("6", true) }
        Siete.setOnClickListener { appendOnExpresstion("7", true) }
        Ocho.setOnClickListener { appendOnExpresstion("8", true) }
        Nueve.setOnClickListener { appendOnExpresstion("9", true) }
        Cero.setOnClickListener { appendOnExpresstion("0", true) }
        Punto.setOnClickListener { appendOnExpresstion(".", true) }

        //Operaciones Basicas
        Sumar.setOnClickListener { appendOnExpresstion("+", false) }
        Restar.setOnClickListener { appendOnExpresstion("-", false) }
        Multiplicar.setOnClickListener { appendOnExpresstion("*", false) }
        Dividir.setOnClickListener { appendOnExpresstion("/", false) }
        Abrir.setOnClickListener { appendOnExpresstion("(", false) }
        Cerrar.setOnClickListener { appendOnExpresstion(")", false) }

        Borrar.setOnClickListener {
            tvExpression.text = ""
            tvResultado.text = ""
        }

        Regresar.setOnClickListener {
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResultado.text = ""
        }

      // Dividir.setOnClickListener{
        //    if (tvExpression.text"/"){
          //      println("Error")
            //}
        //}


        Igual.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResultado.text = longResult.toString()
                else
                    tvResultado.text = result.toString()


            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }

        }

    }

  //  fun <T> tryOrDefault(defaultValue: T, f: () -> T): T {
    //    return try {
      //      f()
       // } catch (e: Exception) {
         //   defaultValue
        //}
    //}

    //fun test(a: Int, b: Int) : Int = tryOrDefault(0) {
      //  a / b
    //}


    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if(tvResultado.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (canClear) {
            tvResultado.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResultado.text)
            tvExpression.append(string)
            tvResultado.text = ""
        }
    }

}


