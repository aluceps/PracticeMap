package me.aluceps.practicemap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import me.aluceps.practicemap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val callback = OnMapReadyCallback {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mapFragment = SupportMapFragment.newInstance()
        mapFragment.getMapAsync(callback)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, mapFragment)
            .commit()
    }
}
