package com.example.safeargs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


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
        val button = view.findViewById<Button>(R.id.buttonSignIn)
        val editTextNom = view.findViewById<EditText>(R.id.editTextNom)
        val editTextPrenom = view.findViewById<EditText>(R.id.editTextPrenom)
        //Je détecte l'appui sur le bouton
        button.setOnClickListener {
            //Je récupère le nom et le prénom des champs EditText
            val nom = editTextNom.text.toString()
            val prenom = editTextPrenom.text.toString()
            // J'en créé un User
            val user = User(nom,prenom)
            //Et l'envoi à Display Fragment
            val action = FormFragmentDirections.actionFormFragmentToDisplayFragment(user)
            Navigation.findNavController(view).navigate(action)
        }

    }
}