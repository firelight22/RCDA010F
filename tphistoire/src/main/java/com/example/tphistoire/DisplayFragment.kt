package com.example.tphistoire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DisplayFragment : Fragment() {

    val args : DisplayFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val histoire = args.story
        val textView = view.findViewById<TextView>(R.id.textViewHistoire)
        textView.text =
            "Il était une fois ${histoire.prenom} qui vivait dans un(e) ${histoire.lieu}..."
    }
}