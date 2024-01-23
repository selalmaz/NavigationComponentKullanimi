package com.example.navigationcomponentkullanimi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.navigationcomponentkullanimi.databinding.FragmentAnaSayfaBinding
import com.google.android.material.snackbar.Snackbar

class AnaSayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnaSayfaBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnaSayfaBinding.inflate(inflater, container, false)

        binding.anasayfaButton.setOnClickListener {
            //Snackbar.make(it,"merhaba",Snackbar.LENGTH_SHORT).show()

            val urun = Urunler(100,"tv")
            // verileri gönderme
            val gecis = AnaSayfaFragmentDirections.detayGecis(urun)
            Navigation.findNavController(it).navigate(gecis)

            // veri gondermeden gecis
         //   Navigation.findNavController(it).navigate(R.id.detayGecis)
        }


        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Yaşam Döngüsü","oncreate")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Yaşam Döngüsü","onpause")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Yaşam Döngüsü","onresume")
    }


}