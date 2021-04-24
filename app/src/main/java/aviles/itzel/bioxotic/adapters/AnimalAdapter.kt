package aviles.itzel.bioxotic.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import aviles.itzel.bioxotic.R
import aviles.itzel.bioxotic.entities.Animal
//import kotlinx.android.synthetic.main.activity_item_animals.view.*

class AnimalAdapter : BaseAdapter{

    var lstAnimals = ArrayList<Animal>()
    var context: Context? = null

    constructor(lstAnimals: ArrayList<Animal>, context: Context?) : super() {
        this.lstAnimals = lstAnimals
        this.context = context
    }

    override fun getCount(): Int {
        return lstAnimals.size
    }

    override fun getItem(p0: Int): Any {
        return lstAnimals[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var animal=lstAnimals[p0]

        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.activity_item_animals, null)

//        view.tv_.setText(animal.name)
//        view.ivAnimal.setImageResource(animal.image)
//        view.btnSeeMore.setOnClickListener {
//            Toast.makeText(context, "Se dio click a: "+animal.name, Toast.LENGTH_LONG).show()
//        }

        return view
    }
}