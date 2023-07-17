package com.burakboz.mykronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View

import com.burakboz.mykronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var zamaniDurdur : Long = 0

        binding.buttonStart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()+zamaniDurdur
            binding.kronometre.start()
            binding.buttonStart.visibility = View.GONE
            binding.buttonPause.visibility = View.VISIBLE
            binding.imageView2.setImageDrawable(getDrawable(R.drawable.pause))

        }
        binding.buttonPause.setOnClickListener {
            zamaniDurdur = binding.kronometre.base - SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.buttonPause.visibility = View.GONE
            binding.buttonStart.visibility = View.VISIBLE
            binding.imageView2.setImageDrawable(getDrawable(R.drawable.start))

        }
        binding.buttonReset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur = 0
            binding.buttonPause.visibility = View.GONE
            binding.buttonStart.visibility = View.VISIBLE
            binding.imageView2.setImageDrawable(getDrawable(R.drawable.start))

        }



    }
}