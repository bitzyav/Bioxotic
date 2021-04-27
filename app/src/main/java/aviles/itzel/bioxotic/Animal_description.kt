package aviles.itzel.bioxotic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_description.*
import kotlinx.android.synthetic.main.activity_item_species.*

class Animal_description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_description)

        val bundle= intent.extras

        if(bundle!=null){
            iv_image_specie.setImageResource(bundle.getInt("image"))
            tv_name_specie.setText(bundle.getString("name"))
            tv_description.setText(bundle.getString("description"))
        }
    }
}