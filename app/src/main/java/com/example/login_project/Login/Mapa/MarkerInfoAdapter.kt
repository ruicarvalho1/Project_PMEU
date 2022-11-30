package com.example.login_project.Login.Mapa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.login_project.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class MarkerInfoAdapter(private val context: Context) : GoogleMap.InfoWindowAdapter {

    override fun getInfoWindow(marker: Marker): View? = null


    override fun getInfoContents(marker: Marker): View? {
        val place = marker.tag as? Place ?: return null


        val view = LayoutInflater.from(context).inflate(R.layout.custom_marker_info, null)

        view.findViewById<TextView>(R.id.txt_title).text   = place.name
        view.findViewById<TextView>(R.id.txt_address).text = place.address
        view.findViewById<TextView>(R.id.txt_horario).text = place.horario
        view.findViewById<TextView>(R.id.txt_rating).text  = context.getString(R.string.rating, place.rating)

        return view
    }


}
