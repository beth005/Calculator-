package com.example.calculator2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator2.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClear.setOnClickListener{
            binding.input.editableText.clear()
            binding.output.text = ""
        }
        binding.buttonBracketOpen.setOnClickListener{
            setExpression("(")
        }
        binding.buttonBracketClose.setOnClickListener{
            setExpression(")")
        }
        binding.buttonDivision.setOnClickListener{
            setExpression("/")
        }
        binding.buttonSeven.setOnClickListener{
            setExpression("7")
        }
        binding.buttonEight.setOnClickListener{
            setExpression("8")
        }
        binding.buttonNine.setOnClickListener{
            setExpression("9")
        }
        binding.buttonMultiplication.setOnClickListener{
            setExpression("*")
        }
        binding.buttonFour.setOnClickListener{
            setExpression("4")
        }
        binding.buttonFive.setOnClickListener{
            setExpression("5")
        }
        binding.buttonSix.setOnClickListener{
            setExpression("6")
        }
        binding.buttonMinus.setOnClickListener{
            setExpression("-")
        }
        binding.buttonOne.setOnClickListener{
            setExpression("1")
        }
        binding.buttonTwo.setOnClickListener{
            setExpression("2")
        }
        binding.buttonThree.setOnClickListener{
            setExpression("3")
        }
        binding.buttonAddition.setOnClickListener{
            setExpression("+")
        }
        binding.buttonZero.setOnClickListener{
            setExpression("0")
        }
        binding.buttonPoint.setOnClickListener{
            setExpression(".")
        }
        binding.buttonEquals.setOnClickListener{
            val text = binding.input.text.toString()
            val expression = ExpressionBuilder(text).build()
            // Check for division by zero using regular expressions
            if (text.matches(Regex(".*\\/.*0.*"))) {
                binding.output.text = "Error."
            } else {
                val result = expression.evaluate()
                binding.output.text = result.toString()
            }
        }


        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
           // val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
           // v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //insets
        //}
    }

    private fun setExpression(expression:String){
        binding.input.append(expression)

    }
}