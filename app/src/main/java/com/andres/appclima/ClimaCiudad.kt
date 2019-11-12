package com.andres.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_clima_ciudad.*
import java.lang.Exception

class ClimaCiudad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima_ciudad)

        val tvGrados = findViewById<TextView>(R.id.tvGrados)
        val tvCiudad = findViewById<TextView>(R.id.tvCiudad)
        val tvClima = findViewById<TextView>(R.id.tvClima)
        val ciudad  = intent.getStringExtra("CIUDAD")
        val APIkey  = "e89d2a32f7844fd81406de1d5d69a4f6"
        //val APIkey  = "c370875ca4db7c6ed539adaf36328f79"


        //solicitudHTTP("http://api.openweathermap.org/data/2.5/weather?id="+3666608+"&appid="+APIkey)
        solicitudHTTP("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid="+APIkey+"&units=metric&lang=es")

        //val idCiudad = intent.getStringExtra("ciudad")
        //instancia de la clase y hace las veces del controlador, instancio del modelo Ciudad
        //val oTunja = Ciudad("Tunja",10,"Nublado")
        //val oBogota = Ciudad("Bogota",12,"Parcialmente Nublado")

        /*if (idCiudad == "id-tunja"){
            tvCiudad.text = oTunja.nombre
            tvGrados.text = oTunja.grados.toString()
            tvClima.text = oTunja.clima
        }else{
            tvCiudad.text = oBogota.nombre
            tvGrados.text = oBogota.grados.toString()
            tvClima.text = oBogota.clima
        }*/
       // tvCiudad.text = intent.getStringExtra("ciudad")
    }
    private fun solicitudHTTP(url:String){
        Log.d("solicitudHTTP", "solicitudHTTP")
        val queue = Volley.newRequestQueue( this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
                response ->
            try {
                Log.d("solicitudVolley", response)

                val oGson = Gson()
                val ciudad = oGson.fromJson(response, Ciudad::class.java)

                this.tvCiudad?.text = ciudad.name
                this.tvGrados?.text = ciudad.main?.temp.toString()
                this.tvClima?.text = ciudad.weather?.get(0)?.description

            } catch (e: Exception) {  }
        }, Response.ErrorListener {  })

        queue.add(solicitud)

    }
}
