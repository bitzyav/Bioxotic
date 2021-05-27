package trinidad.daniel.bioxotic

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_menu_animal_species.*
import kotlinx.android.synthetic.main.item_species.view.*
import trinidad.daniel.bioxotic.entities.Specie
import trinidad.daniel.bioxotic.ui.home.HomeFragment
import java.util.*
import kotlin.collections.ArrayList

class Menu_animal_species : AppCompatActivity() {
    var species = ArrayList<Specie>()

    var adapter: SpeciesAdapter ? = null

    private lateinit var iv_category_animals: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_animal_species)
        supportActionBar?.hide()

        val intent:Intent = getIntent()

        val category = intent.getStringExtra("category")

        iv_category_animals = findViewById(R.id.iv_category_animals)

        if(category.equals("fishes")){
            loadFishes()
            iv_category_animals.setImageResource(R.drawable.fishes)
        }else if(category.equals("birds")){
            loadBirds()
            iv_category_animals.setImageResource(R.drawable.birds)
        }else if(category.equals("amphibians")){
            loadAmphibians()
            iv_category_animals.setImageResource(R.drawable.amphibians)
        }else if(category.equals("felines")){
            loadFelines()
            iv_category_animals.setImageResource(R.drawable.felines)
        }else if(category.equals("rodents")){
            loadRodents()
            iv_category_animals.setImageResource(R.drawable.rodents)
        }else if(category.equals("reptiles")){
            loadReptiles()
            iv_category_animals.setImageResource(R.drawable.reptiles)
        }

        val lv_species: ListView = findViewById(R.id.lv_species)


        adapter = SpeciesAdapter(this, species, category.toString())
        lv_species.adapter = adapter

        val ib_back_menu_species: ImageButton = findViewById(R.id.ib_back_menu_species)
        ib_back_menu_species.setOnClickListener{
            var signInIntent: Intent? = Intent(this, MainActivity::class.java)
            startActivity(signInIntent)
        }

        val button_user_profile: ImageButton = findViewById(R.id. ib_user_profile)
        button_user_profile.setOnClickListener {
            var userProfileIntent: Intent? = Intent(this, Profile::class.java)
            startActivity(userProfileIntent)
        }
    }


    fun loadBirds(){
        species.add(Specie(R.drawable.parakeetssquare,R.drawable.parakeets, "Parakeet", "They are sociable pets so it is recommended to keep the couple or at least 2 in their cage.\n" +
                "Care: keep the cage clean, place them in a place with good lighting, eventually let them out.\n" +
                "Food: oatmeal or birdseed.\n"))
        species.add(Specie(R.drawable.canariessquare, R.drawable.canaries,"Canarie", "The best-known singer of pet birds, known precisely for his melodious trills and the intense yellow color of his feathers.\n" +
                "Care: leave an element such as stones in its cage where it can wear down its beak and legs to prevent them from growing too much.\n" +
                "Food: birdseed, other seeds, fruits and vegetables.\n"))
        species.add(Specie(R.drawable.nymphssquare, R.drawable.nymphs,"Nymph", "They are birds that may initially seem a bit nervous but that little by little they gain confidence and develop a close relationship with their owner, over time they can learn words and whistle some tunes.\n" +
                "Care: they require a large cage.\n" +
                "Food: fruits, fresh vegetables, boiled egg and worms.\n"))
        species.add(Specie(R.drawable.goldfinchsquare, R.drawable.goldfinch, "Goldfinch", "Lovers of hot climates, it is in these moments that he sings with more joy, which characterizes him as a hyperactive bird.\n" +
                "Care: they require very large cages and it is advisable to put twigs and some other obstacles in the cage so that it can jump from side to side, as it usually does in the wild.\n" +
                "Food: birdseed, other seeds, fruits and vegetables.\n"))
    }

    fun loadFishes(){
        species.add(
            Specie(R.drawable.bettafishsquare,R.drawable.bettafish,"Betta Fish", "It is known as \"Siamese fighting fish\", because the males compete with each other, even killing their adversaries. \n" +
                    "Aquarium conditions: As a general rule, they survive well in a 50-liter aquarium, which can vary in size depending on the species and the community of fish that accompany it. The water temperature must be kept between 22º and 30ºC, with a pH between 6 and 8, as we will see acceptable\n")
        )
        species.add(Specie(R.drawable.guppyfishsquare,R.drawable.guppyfish,"Guppy Fish", "Among the freshwater aquarium fish they are probably the most popular, there are four basic reasons for their popularity: They are very easy to care for, suitable for the most novice aquarists.\n" +
                "Aquarium conditions: The size of the aquarium should be 80 liters, 45x30x30. The water temperature should be between 22º and 28º, with a good pH it is between 7 and 8.5.\n")
        )
        species.add(
            Specie(R.drawable.lionfishsquare, R.drawable.lionfish, "Lion Fish", "This species is the most spectacular because of the shape of its body. It is covered in dangerous thorns and some of them are poisonous.\n" +
                    "Aquarium conditions: The aquarium should be between 200 and 400 liters in size. The temperature of the water from 23ºC to 26ºC, with a pH of 8.10 to 8.40.\n")
        )
        species.add(
            Specie(R.drawable.mandarinfishsquare,R.drawable.mandarinfish,"Mandarin Fish", "It is a very small tropical fish that is very striking for its bright colors and curious stripes.\n" +
                    "Aquarium conditions: They need a well-established and mature marine aquarium, with a minimum size of 200 liters. The water conditions, so that they remain in optimal conditions, are temperature between 24ºC and 27ºC, with a temperature between 8.1 and 8.4.\n")
        )
    }

    fun loadFelines(){
        species.add(Specie(R.drawable.lionssquare,R.drawable.lions,"Lion", "Sometimes lionesses abandon their cubs for example because it is their first time, in that case we have to raise the little lions ourselves. It is vitally important to have a record for each puppy where they will put their daily weight, the amount of milk they ingest and any important information"))
        species.add(Specie(R.drawable.tigerssquare,R.drawable.tigers, "Tiger King", "It is obvious that tigers are very beautiful and imposing animals, which have been a symbol of strength and power in many cultures. Despite being frowned upon by many people, a large number of tigers are held captive in parks and zoos."))

    }

    fun loadReptiles(){
        species.add(Specie(R.drawable.iguanassquare, R.drawable.iguanas,"Iguana", "The green iguana is one of the most common reptiles in captivity and the one that will attract your attention the most when buying your first reptile; However, it is not the best reptile for beginners as it requires some experience and a lot of care, although nothing is impossible if you inform yourself very well first."))
        species.add(Specie(R.drawable.moreletticrocodilesquare, R.drawable.moreletticrocodile,"Crocodile Moreletti", "Think twice before buying the crocodile, as it is an adventurer's task. Keeping a crocodile as a pet can be very dangerous, they have large jaws, sharp teeth, a long body and a bitter character. They can be very difficult to own and handle."))
        species.add(Specie(R.drawable.beardeddragonssquare,R.drawable.beardeddragons, "Bearded dragons", "The bearded dragon is one of the types of lizards that is currently the most recognized species of the genus of pogonas. Due to their small size, docile character and high sociability, bearded dragons are usually easier to handle and care for than other larger and more territorial lizards, such as iguanas."))
        species.add(Specie(R.drawable.ballpythonsquare,R.drawable.ballpython,"Ball python", "The ball python or royal python in Europe is the most popular snake as a pet around the world, since, although they are somewhat shy, they tolerate handling and human interaction very well. In addition, they are small in size and there is a wide variety of patterns and colors available."))
    }

    fun loadAmphibians(){
        species.add(Specie(R.drawable.frogsquare,R.drawable.frog, "Green Frog", "They behave like fish and can be fed like them. Its evolution can be followed: first without legs, then the hind legs come out, etc."))
        species.add(Specie(R.drawable.axolotlcsquare,R.drawable.axolotl, "Axolotl", "The correct maintenance of axolotls is summarized in water quality, temperature, filtering and lighting. For an adult individual, a minimum urn of 40 liters is recommended, since the space available for the animal is reduced when the accessories are inserted."))
        species.add(Specie(R.drawable.salamandersquare,R.drawable.salamander, "Salamander", "Salamanders are carnivores, but the exact type of food you should feed them varies depending on what species you have and whether it is a baby or an adult."))
    }

    fun loadRodents(){
        species.add(Specie(R.drawable.hamsterssquare,R.drawable.hamsters, "Hamster", "The hamster is a small rodent of the Cricetidae family that can be with us for between 2 and 5 years, depending on the species, if we strive to provide it with what it needs, such as an appropriate and healthy diet for its characteristics."))
        species.add(
            Specie(R.drawable.sugargliderssquare,R.drawable.sugargliders, "Sugar Glider", "In captivity, it is not difficult to provide a suitable diet for our Gliders.\n" +
                    "Basic diet for gliders: The basic diet for gliders is a varied diet that contains everything, so that they eat everything, fruits, vegetables, proteins, sugars, cereals, etc.\n")
        )
    }

}



class SpeciesAdapter : BaseAdapter {
    var species = ArrayList<Specie>()
    var context: Context? = null
    var category: String?=null
    constructor(context: Context, species:ArrayList<Specie>, category: String){
        this.context = context
        this.species = species
        this.category=category
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var  specie = species[position]
        var inflador = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflador.inflate(R.layout.item_species, null) as View
        view.tv_name_specie.setText(specie.name)
        view.iv_image_specie.setImageResource(specie.image)

        view.btn_see_more.setOnClickListener {
            var intent = Intent(context, Animal_description::class.java)
            intent.putExtra("image", specie.image)
            intent.putExtra("imageRec", specie.imageRec)
            intent.putExtra("name", specie.name)
            intent.putExtra("description", specie.description)
            intent.putExtra("category",category)
            context!!.startActivity(intent)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return species[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return species.size
    }
}