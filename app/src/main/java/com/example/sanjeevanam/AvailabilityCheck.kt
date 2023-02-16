package com.example.sanjeevanam

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.sanjeevanam.databinding.ActivityAvailabilityCheckBinding

lateinit var binding : ActivityAvailabilityCheckBinding

class AvailabilityCheck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvailabilityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = arrayOf(
            "Artemis Blood Bank\n" +
                    "Address: Sector-51, Gurugram\n" +
                    "Contact Person: Dr. Anil Chhetarpal\n" +
                    "Phone Number: 09871019148",

            "Blood Bank General Hospital, Gurugram\n" +
                    "Address: General Hospital Gurugram\n" +
                    "Contact Person: Dr. Manoj Sharma\n" +
                    "Phone Number: 09868822200",
            "Paras Hospital Blood Bank\n" +
                    "Address: Paras Hospital, Sector-43, Gurugram\n" +
                    "Contact Person: Dr. Sonial Bindal\n" +
                    "Phone Number: 09560409965",
            "Metro Hospital Blood Bank\n" +
                    "Address: H- Block, Palam Vihar, Gurugram\n" +
                    "Contact Person: Dr. Ajay Gupta\n" +
                    "Phone Number: 09871115085",
            "Prem Nath Hospital\n" +
                    "Address: Delhi Road,\n" +
                    "Phone Number: 0124-2320641",
            "Pushpanjali Hospital\n" +
                    "\nAddress: John Hall Road Civil Lines,\n" +
                    "\nPhone Number: 0124-2323052, 2320050", "Saraswati Hospital\n" +
                    "\nAddress: Delhi Road\n",
            "\nAcharaya Anand Rishiji Blood Bank in Pune\n" +
                    "27, Sadashiv Peth\n" +
                    "Basement Of Poona Hospital\n" +
                    "Pune",
            "Red Cross Blood Bank\n" +
                    "593/2, Near Tarachand Hospital\n" +
                    "Rasta Peth, Pune\n" +
                    "Phone No - 020 2612 0950" ,
            "Sant Dnyaneshwar Hospital\n" +
                    "Hira Plaza, Pune Nashik Road\n" +
                    "Bhosari, Pune",
            "Ruby Hall Clinic Pune\n" +
                    "40, Ruby Hill Clinic\n" +
                    "Dhole Patil Road\n" +
                    "Pune\n" +
                    "Phone No - 020 2613 6318\n","\nInstitute of Blood Transfusion Medicine & Immuno Haematology (Central Blood Centre) - BCSU,\nkolkata\n",
            "\nSSKM Hospital Blood Centre - BCSU,\n kolkata\n",
            "\nKolkata,\nCalcutta Medical College & Hospital Blood Centre - BCSU\n"

        )

        val userAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, R.layout.simple_list_item_1,
            user
        )

        binding.userList.adapter = userAdapter;

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (user.contains(query)) {

                    userAdapter.filter.filter(query)

                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                userAdapter.filter.filter(newText)
                return false
            }


        })


    }
}