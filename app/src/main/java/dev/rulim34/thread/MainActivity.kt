package dev.rulim34.thread

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private lateinit var calculatePowerButton: Button
    private lateinit var editTextBase: EditText
    private lateinit var editTextExponent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.text_result)
        calculatePowerButton = findViewById(R.id.btn_calculate_power)
        editTextBase = findViewById(R.id.edittext_base)
        editTextExponent = findViewById(R.id.edittext_exponent)

        calculatePowerButton.setOnClickListener {
            // Get base and exponent values from the user input
            val base = editTextBase.text.toString().toDoubleOrNull()
            val exponent = editTextExponent.text.toString().toDoubleOrNull()

            if (base != null && exponent != null) {
                // Start the AsyncTask to perform the power calculation
                PowerCalculationTask().execute(base, exponent)
            } else {
                resultText.text = "Please enter valid numbers for base and exponent."
            }
        }
    }

    // Define an AsyncTask to perform power calculation in the background
    private inner class PowerCalculationTask : AsyncTask<Double, Void, String>() {

        @Deprecated("Deprecated in Java")
        override fun onPreExecute() {
            // Update UI before starting the background task
            resultText.text = "Calculating..."
        }

        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg params: Double?): String {
            val base = params[0] ?: 1.0
            val exponent = params[1] ?: 1.0

            // Perform the power calculation
            val result = base.pow(exponent)

            // Simulate delay
            Thread.sleep(3000) // Sleep for 3 seconds

            return "$base raised to the power of $exponent is $result"
        }

        @Deprecated("Deprecated in Java")
        override fun onPostExecute(result: String?) {
            // Update UI with the result after calculation
            resultText.text = result
        }
    }
}
