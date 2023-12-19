package com.example.cs311_u4_ip_johntorres

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    // Button variables.
    private var addStringsBtn: Button? = null
    private var compareStringsBtn: Button? = null
    private var countVowelsBtn: Button? = null

    // Field variables
    private var string1Field: EditText? = null
    private var string2Field: EditText? = null
    private var outputField: TextView? = null

    // Validity flag for field validation.
    private var isValid = false

    // Field Validation
    private fun validateFields(): Boolean {
        // Check for entries in number fields and show error if blank.
        if (string1Field!!.length() == 0) {
            string1Field!!.error = "First string is required"
            return false
        }
        if (string2Field!!.length() == 0) {
            string2Field!!.error = "Second string is required"
            return false
        }

        // If valid, return true.
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Launch page layout.
        setContentView(R.layout.activity_main)

        // Pair button variables with layout IDs.
        addStringsBtn = findViewById(R.id.addStringsBtn)
        compareStringsBtn = findViewById(R.id.compareStringsBtn)
        countVowelsBtn = findViewById(R.id.countVowelsBtn)

        // Pair field variables with layout IDs.
        string1Field = findViewById(R.id.string1Input)
        string2Field = findViewById(R.id.string2Input)
        outputField = findViewById(R.id.outputField)

        // Add Strings button listener
        addStringsBtn?.setOnClickListener {

            // Runs validation.
            isValid = validateFields()

            // If valid, perform Add Strings operation.
            if (isValid) {
                // Get input values
                val string1 = string1Field!!.text
                val string2 = string2Field!!.text

                // Merge strings
                outputField!!.text = "$string1 $string2"
            }
        }

        // Compare Strings button listener
        compareStringsBtn?.setOnClickListener {

            // Runs validation.
            isValid = validateFields()

            // If valid, perform Compare Strings operation.
            if (isValid) {

                // Get input values
                val string1 = string1Field!!.text.toString()
                val string2 = string2Field!!.text.toString()

                // Compare strings and display if matching or not matching.
                if (string1 == string2) {
                    outputField!!.text = "Matching"
                } else {
                    outputField!!.text = "Not matching"
                }
            }
        }

        // Count Vowels button listener
        countVowelsBtn?.setOnClickListener {

            // Runs validation.
            isValid = validateFields()

            // If valid, perform Count Vowels operation.
            if (isValid) {

                // Get input values
                val string1 = string1Field!!.text.toString()
                val string2 = string2Field!!.text.toString()

                // Merge strings
                var fullString = "$string1 + $string2"

                // Initialize vowel counter
                var vowels = 0

                // Lower full string case for comparison.
                fullString = fullString.lowercase(Locale.ROOT)

                // Loop through string for vowels and increment vowel counter when there is a match.
                for (element in fullString) {
                    if (element == 'a' || element == 'e' || element == 'i'
                        || element == 'o' || element == 'u') {
                        ++vowels
                    }
                }
                // Display vowel counter output.
                outputField!!.text = vowels.toString()
            }
        }
    }
}