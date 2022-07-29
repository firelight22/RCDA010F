package com.example.tphistoire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.tphistoire.databinding.FragmentFormBinding


class FormFragment : Fragment() {
    lateinit var ffb : FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        ffb = FragmentFormBinding.inflate(inflater,container,false)
        return ffb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ffb.buttonStartHistory.setOnClickListener {
            val histoire = Histoire(
                ffb.editTextPrenom.text.toString(),
                ffb.editTextLieu.text.toString(),
            )
            val direction = FormFragmentDirections.actionFormFragmentToDisplayFragment(histoire)
            Navigation.findNavController(view).navigate(direction)
        }
    }

}