package com.example.tprecyclerviewdog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tprecyclerviewdog.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    val detailArgs by navArgs<DetailFragmentArgs>()
    lateinit var db: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        db = FragmentDetailBinding.inflate(
            inflater,
            container,
            false)
        return db.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db.dog = detailArgs.dog
    }

}