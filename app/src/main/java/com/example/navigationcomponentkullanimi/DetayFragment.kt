package com.example.navigationcomponentkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentkullanimi.databinding.FragmentDetayBinding
import com.google.android.material.snackbar.Snackbar


class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  FragmentDetayBinding.inflate(inflater, container, false)

        val bundle :DetayFragmentArgs by navArgs()  // verileri alma

        val gelenId = bundle.urun.id
        val gelenAd = bundle.urun.ad

        binding.textView2.text= "${gelenId} ${gelenAd}"

        //geri tusu ayarları  true yaparsak geri donmeyi devre dışı bırakıyorz
                //false yaparsak geri tuşu çalışır
        val backPress = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Snackbar.make(binding.textView2,"Geri Dönmek ister misin",Snackbar.LENGTH_SHORT)
                    .setAction("evet"){
                        isEnabled = false // geri dönüş aktif
                        requireActivity().onBackPressedDispatcher.onBackPressed()
                    }
                    .show()

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backPress)

        return binding.root
    }






}