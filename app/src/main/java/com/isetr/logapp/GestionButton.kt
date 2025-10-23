package iset.tn.tp3

import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.isetr.logapp.databinding.ActivityMainBinding
import java.util.Random

class GestionButton : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)
        title = "button radio checK"

        /*binding.button2.setOnLongClickListener {
            binding.lay.setBackgroundColor(Color.WHITE)
            binding.RG.clearCheck()
            binding.checkBox.isChecked = false
            true}
        //   getWindow().getDecorView().setBackgroundColor();
        binding.button.setOnClickListener { //recuperer id bouton radio coché au niveau radio groupe
            val x = binding.RG.checkedRadioButtonId
            if (x == -1) Toast.makeText(
                this,
                "veuillez choisir une couleur",
                Toast.LENGTH_LONG
            ).show()
            else {
                val RB = findViewById<RadioButton>(x)
                Toast.makeText(
                    this,
                    RB.text.toString(),
                    Toast.LENGTH_LONG
                ).show()
             /*   if (x == R.id.Rouge) {
                    binding.lay.setBackgroundColor(Color.parseColor(RB.contentDescription.toString()))
                    Toast.makeText(
                        this,
                        RB.contentDescription.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else if (RB.text === getString(R.string.jaune)) {
                    binding.lay.setBackgroundColor(Color.YELLOW)
                } else if (RB.text === getString(R.string.vert)) {
                    binding.lay.setBackgroundColor(Color.GREEN)
                }
            } */
                val colorName = RB.contentDescription.toString()
                val colorInt = when (colorName) {
                    "RED" -> Color.RED
                    "GREEN" -> Color.GREEN
                    "YELLOW" -> Color.YELLOW
                    // Add other colors as needed
                    else -> Color.BLACK // Default color if no match is found
                }
                binding.lay.setBackgroundColor(colorInt)
            }
                val checked = binding.checkBox.isChecked
            // int myColor=Color.rgb(100,100,50);
            val rnd = Random()
            val myColor =
                Color.rgb(rnd.nextInt(256),
                    rnd.nextInt(256), rnd.nextInt(256))
            // Check which checkbox was clicked
            if (checked) {
                binding.txtparag.setTextColor(myColor)
            } else {
                binding.txtparag.setTextColor(Color.BLACK)
            }
        }*/
    }
}
