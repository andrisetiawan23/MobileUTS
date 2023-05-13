package com.example.andriuts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andriuts.Komik
import com.example.andriuts.R
import com.example.andriuts.detailKomikActivity
import com.example.andriuts.komikAdapter

class UntukmuFragment : Fragment() {
    private lateinit var adapter: komikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var komikArrayList: ArrayList<Komik>

    lateinit var image: Array<Int>
    lateinit var detailimage: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var chapter: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_untukmu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            komikAdapter(it, komikArrayList){
                val intent = Intent(context, detailKomikActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }
    private fun dataInitialize(){
        komikArrayList = arrayListOf<Komik>()

        detailimage = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,

        )

        image = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
        )

        title = arrayOf(
           "Spezia",
            "Empoli",
            "Monza",
            "Roma",
            "Inter",
            "Milan",
            "Lazio",
            "Napoli",
            "Juventus",
            "Lecce",
        )

        description = arrayOf(
            "A.S.D. Spezia Calcio 2008 yang dulunya bernama Spezia Calcio 1906 adalah klub sepak bola Italia, bermarkas di La Spezia Genova, Liguria",
            "sebuah klub sepak bola Italia yang didirikan pada tahun 1920. ",
            "sebuah klub sepak bola Italia dari kota Monza, Lombardia",
            "adalah klub Besar sepak bola Italia yang bermarkas di Roma, Italia. Klub AS Roma meraih 3 gelar scudetto di liga Italia, dan juara dalam edisi pertama Liga Konferensi 2022 ",
            "Football Club Internazionale Milano, atau yang dikenal dengan nama Internazionale ataupun juga Inter, ",
            "sebuah klub sepak bola profesional asal Italia yang saat ini bermain di Serie A Liga Italia.",
            "sebuah perkumpulan olahraga profesional Italia yang berbasis di Roma, ibu kota Italia, yang terkenal karena cabang sepak bolanya",
            "sebuah klub sepak bola Italia yang bermarkas di kota Napoli, Campania. ",
            "Juventus dan populer dengan nama Juve, adalah klub sepak bola profesional asal Italia yang berbasis di kota Turin, Piemonte.",
            "tim sepak bola Italia yang bermarkas di kota Lecce. ",

            )

        chapter = arrayOf(
            "Chapter 2",
            "Chapter 5",
            "Chapter 4",
            "Chapter 2",
            "Chapter 6",
            "Chapter 3",
            "Chapter 5",
            "Chapter 4",
            "Chapter 4",
            "Chapter 5",
        )
        for (i in image.indices){
            val komik = Komik(image[i], title[i], description[i], detailimage[i], chapter[i],)
            komikArrayList.add(komik)
        }
    }


}