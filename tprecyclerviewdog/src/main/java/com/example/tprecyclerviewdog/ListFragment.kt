package com.example.tprecyclerviewdog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvd = view.findViewById<RecyclerView>(R.id.recyclerViewDog)
        val alDog = arrayListOf(
            Dog("Rex","Berger Allemand","Brun",5,"https://static.wamiz.com/images/news/facebook/article/sans-titre-12-fb-5da6ea9429e72.png"),
            Dog("Cookie", "Husky","blanc, marron", 14, "https://images.dog.ceo/breeds/eskimo/n02109961_3992.jpg"
            ),
            Dog("Moche", "affenpinscher","noir", 3, "https://images.dog.ceo/breeds/affenpinscher/n02110627_11759.jpg", ),
            Dog("Sempaï", "Akita","blanc, marron", 8, "https://images.dog.ceo/breeds/akita/Akita_Inu_dog.jpg"),
            Dog("Pomme", "Berger Australien","marron, roux, blanc", 8, "https://images.dog.ceo/breeds/australian-shepherd/forest.JPG"),
            Dog("Bob", "Bouvier","marron, noir", 11, "https://images.dog.ceo/breeds/bouvier/n02106382_3856.jpg"),
            Dog("Hooper", "Yorkshire","marron, noir, gris, roux", 8, "https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_730.jpg"),
            Dog("Joyce", "Jack Russel","blanc, marron", 7, "https://images.dog.ceo/breeds/terrier-russell/jack1.jpg"),
            Dog("Max", "Jack Russel","noir", 11, "https://images.dog.ceo/breeds/terrier-cairn/n02096177_9014.jpg"),
            Dog("JeanJean", "Border Collie","noir, gris, blanc", 5, "https://media.ooreka.fr/public/image/3-306107-2705-main-13060599.jpg")

        )
        rvd.layoutManager = LinearLayoutManager(context)
        rvd.adapter = DogAdapter(alDog, {
                val direction = ListFragmentDirections.actionListToDetail(it);
                Navigation.findNavController(view).navigate(direction)
            }
        )
        //Navigation.findNavController(view).navigate(R.id.actionListToDetail)
    }
}