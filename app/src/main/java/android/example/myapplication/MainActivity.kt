package android.example.myapplication

import android.annotation.SuppressLint
import android.example.myapplication.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun onClickResult(view: View) {
        if (!isFieldEmpty()) {
            val result = getString(R.string.result_info) + getResult()
            binding.tvResult.text = result
        }
    }

    private fun isFieldEmpty():Boolean {
        binding.apply {
            val errorMessage = getString(R.string.errorMessage)

            if (edA.text.isNullOrEmpty()) edA.error = errorMessage
            if (edB.text.isNullOrEmpty()) edB.error = errorMessage
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String {
        var a: Double
        var b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
            return sqrt((a.pow(2) + b.pow(2))).toString()

    }
}