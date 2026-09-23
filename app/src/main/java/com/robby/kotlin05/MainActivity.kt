package com.robby.kotlin05

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.robby.kotlin05.databinding.ActivityMainBinding
import com.robby.kotlin05.entity.Department
import java.util.Calendar

/**
 * @author Robby Tan
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Radio Button
        binding.rbMale.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.text_male) + " is " + if (b) "selected" else "unselected",
                Toast.LENGTH_LONG
            ).show()
        }

        //  Checkbox
        binding.chReading.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.text_reading) + " is " + if (b) "selected" else "unselected",
                Toast.LENGTH_LONG
            ).show()
        }

        //  Create ArrayList for spinner data
        val departments = ArrayList<Department>()
        departments.add(Department("1", "Medicine"))
        departments.add(Department("2", "Engineering"))
        departments.add(Department("3", "Psychology"))
        departments.add(Department("7", "Information Technology"))
        val arrayAdapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,
            departments
        );
        binding.spinDepartment.adapter = arrayAdapter

        //  Spinner
        binding.spinDepartment.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(
                    this@MainActivity,
                    p0?.getItemAtPosition(p2).toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //  Date Picker
        val calendar = Calendar.getInstance()
        binding.buttonDate.setOnClickListener {
            DatePickerDialog(
                this@MainActivity,
                { datePicker, i, i2, i3 ->
                    calendar.set(Calendar.YEAR, i)
                    calendar.set(Calendar.MONTH, i2)
                    calendar.set(Calendar.DATE, i3)
                    Toast.makeText(this@MainActivity, calendar.time.toString(), Toast.LENGTH_SHORT).show()
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DATE]
            ).show()
        }
    }
}