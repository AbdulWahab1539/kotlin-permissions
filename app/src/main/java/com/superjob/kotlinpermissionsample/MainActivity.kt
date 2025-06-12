package com.superjob.kotlinpermissionsample

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlinpermissions.KotlinPermissions
import com.superjob.kotlinpermissionsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.locationButton.setOnClickListener { _ ->
            KotlinPermissions.with(this)
                .permissions(Manifest.permission.ACCESS_COARSE_LOCATION)
                .onAccepted {
                    setLocationStatus("Granted")
                }
                .onDenied {
                    setLocationStatus("Denied")
                }
                .onForeverDenied {
                    setLocationStatus("Forever denied")
                }
                .ask()
        }

        binding.cameraButton.setOnClickListener { _ ->

            KotlinPermissions.with(this)
                .permissions(Manifest.permission.CAMERA)
                .onAccepted {
                    setCameraStatus("Granted")
                }
                .onDenied {
                    setCameraStatus("Denied")
                }
                .onForeverDenied {
                    setCameraStatus("Forever denied")
                }
                .ask()

        }
    }

    private fun setCameraStatus(status: String) {
        binding.cameraStatusTextView.text = status
    }

    private fun setLocationStatus(status: String) {
        binding.locationStatusTextView.text = status
    }
}