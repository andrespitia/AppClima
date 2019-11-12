package com.andres.appclima

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

class Network {

    companion object{
        //metodo para saber si hay internet o no en el dispositivo
        fun hayRed(activity:AppCompatActivity):Boolean{

            val connManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connManager.activeNetworkInfo

            return ((networkInfo != null) && (networkInfo.isConnected))
        }
    }
}