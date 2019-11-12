package com.andres.appclima

import android.app.DownloadManager
import android.app.VoiceInteractor
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val  btbogota = findViewById<Button>(R.id.btBogota)
        val  bttunja = findViewById<Button>(R.id.btTunja)
        //llamamos los datos de el servidor con el id de las ciudades
        val idTunja = "3666608"
        val idBogota = "3688689"

        //ir de una actividad a otra
        val oIntent = Intent(this, ClimaCiudad::class.java)



        bttunja.setOnClickListener(View.OnClickListener {
            //ir de una actividad a otra
            if (Network.hayRed(this)){
                oIntent.putExtra("CIUDAD", idTunja)
                startActivity(oIntent)
                Toast.makeText(this, "Hay red", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, " NO hay red", Toast.LENGTH_SHORT).show()
            }
        })
        btbogota.setOnClickListener(View.OnClickListener {
            //ir de una actividad a otra
            if (Network.hayRed(this)){
                oIntent.putExtra("CIUDAD", idBogota)
                startActivity(oIntent)
                Toast.makeText(this, "Hay red", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, " NO hay red", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
