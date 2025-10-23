package com.isetr.logapp

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.NumberPicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNumberPickerDialog(this)
    }

    private fun showNumberPickerDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        /*
        //val dialogView = inflater.inflate(R.layout.number_picker_dialog, null)

       // val numberPicker = dialogView.findViewById<NumberPicker>(R.id.number_picker)
        numberPicker.minValue = 0
        numberPicker.maxValue = 100
        numberPicker.value = 50 // Initial value

        builder.setTitle("Select a Number")
        builder.setView(dialogView)

        builder.setPositiveButton("OK") { dialog, _ ->
            val selectedNumber = numberPicker.value
            Toast.makeText(context, "Selected: $selectedNumber", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}*/
    }
}