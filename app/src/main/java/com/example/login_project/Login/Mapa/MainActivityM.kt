package com.example.login_project.Login.Mapa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.login_project.Login.DashboardUserActivity
import com.example.login_project.Login.PerfilUser.MainActivity_perfiluser
import com.example.login_project.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions


class MainActivityM : AppCompatActivity() {
    private val places = arrayListOf(
        Place(
            "ESTG",
            LatLng(41.6934867, -8.8466533),
            "Escola Superior de Tecnologia e Gestão - Instituto Politécnico de Viana do Castelo",
        "9:00-20:00 de Segunda à Sexta",4.8f
        ),
    )
    private val places11 = arrayListOf(
        Place(
            "ESE",
            LatLng(41.7031951, -8.8211781),
            "Escola Superior de Educação - Instituto Politécnico de Viana do Castelo",
            "9:00-20:00 de Segunda à Sexta",4.9f
        ),
    )
    private val places2 = arrayListOf(
        Place(
            "ESS",
            LatLng(41.697404, -8.835277),
            "Escola Superior de Saude - Instituto Politécnico de Viana do Castelo",
            "9:00-20:00 de Segunda à Sexta", 4.10f
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_map)

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        mapFragment.getMapAsync { googleMap ->
            googleMap.setInfoWindowAdapter(MarkerInfoAdapter(this))
            addMarkers(googleMap)




            googleMap.setOnMapLoadedCallback {
                val bounds = LatLngBounds.builder()

                places11.forEach {
                    bounds.include(it.latLng)
                }
                places2.forEach {
                    bounds.include(it.latLng)
                }
                places.forEach {
                    bounds.include(it.latLng)
                }
                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 100))
            }
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        places.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .snippet(place.horario)
                    .position(place.latLng)
                    .icon(
                        BitmapHelper.vectorToBitmap(
                            this,
                            R.drawable.ic_baseline_school_24, ContextCompat.getColor(
                                this,
                                android.R.color.holo_orange_dark
                            )
                        )
                    )
            )
            if (marker != null) {
                marker.tag = place
            }
        }
        places11.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .snippet(place.horario)
                    .position(place.latLng)
                    .icon(
                        BitmapHelper.vectorToBitmap(
                            this,
                            R.drawable.ic_baseline_school_26, ContextCompat.getColor(
                                this,
                                R.color.Azul
                            )
                        )
                    )
            )
            if (marker != null) {
                marker.tag = place
            }
        }

        places2.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .snippet(place.horario)
                    .position(place.latLng)
                    .icon(
                        BitmapHelper.vectorToBitmap(
                            this,
                            R.drawable.ic_baseline_school_25, ContextCompat.getColor(
                                this,
                                R.color.pink
                            )
                        )
                    )
            )
            if (marker != null) {
                marker.tag = place
            }
        }
    }

    fun Funcionlide_1(view: View) {
        val intent = Intent(this, DashboardUserActivity::class.java).apply {

        }
        startActivity(intent)
    }

    fun Funcionlide_3(view: View) {
        val intent = Intent(this, MainActivityM::class.java).apply {

        }
        startActivity(intent)
    }
    fun Funcionlide_4(view: View) {
        val intent = Intent(this, MainActivity_perfiluser::class.java).apply {

        }
        startActivity(intent)
    }
}

data class Place(
    val name: String,
    val latLng: LatLng,
    val address: String,
    val horario: String,
    val rating: Float
)

