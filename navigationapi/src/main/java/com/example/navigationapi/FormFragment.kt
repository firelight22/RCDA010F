package com.example.navigationapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlin.random.Random

class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //On réucupère le bouton du fragment
        val button = view.findViewById<Button>(R.id.button)
        //Lors d'un clic sur le bouton
        button.setOnClickListener {
            //On récupère le contrôleur de navigation et on va vers Display
            Navigation.findNavController(view)
                .navigate(R.id.action_formFragment_to_displayFragment)
        }
        Random.nextBoolean()
        //button.setOnClickListener(
        //    Navigation.createNavigateOnClickListener(
        //        R.id.action_formFragment_to_displayFragment
        //    )
        //)

    }

}