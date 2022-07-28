package com.example.tpcolorme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlin.random.Random


class PinkFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBlank = view.findViewById<Button>(R.id.buttonPink)
        buttonBlank.setOnClickListener {
            if(Random.nextBoolean())
                Navigation.findNavController(view).navigate(R.id.action_pinkFragment_to_orangeFragment)
            else
                Navigation.findNavController(view).navigate(R.id.action_pinkFragment_to_blueFragment2)

        }
    }
}