package kr.ac.kopo.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.View.OnClickListener
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1: EditText
    lateinit var edit2: EditText

    lateinit var btnPlus: Button
    lateinit var btnMinus: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivide: Button
    lateinit var btnMod: Button

    lateinit var textResult: TextView

    var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 위젯 객체의 참조값을 필드로 선언된 참조변수에 대입
        edit1 = findViewById<EditText>(R.id.edit1)
        edit2 = findViewById<EditText>(R.id.edit2)
        btnPlus = findViewById<Button>(R.id.btnPlus)
        btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnDivide = findViewById<Button>(R.id.btnDivide)
        btnMod = findViewById<Button>(R.id.btnMod)
        textResult = findViewById<TextView>(R.id.textResult)

        btnPlus.setOnClickListener(btnListener)
        btnMinus.setOnClickListener(btnListener)
        btnMultiply.setOnClickListener(btnListener)
        btnDivide.setOnClickListener(btnListener)
        btnMod.setOnClickListener(btnListener)

//        btnPlus.setOnClickListener {
//            val num1 = edit1.text.toString().toInt()
//            var num2 = edit2.text.toString().toInt()
//
//            result = num1 + num2
//            textResult.text = "계산 결과: " + result.toString()
//        }
//
//        btnMinus.setOnClickListener {
//            val num1 = edit1.text.toString().toInt()
//            var num2 = edit2.text.toString().toInt()
//
//            result = num1 - num2
//            textResult.text = "계산 결과: " + result.toString()
//        }
//
//        btnMultiply.setOnClickListener {
//            val num1 = edit1.text.toString().toInt()
//            var num2 = edit2.text.toString().toInt()
//
//            result = num1 * num2
//            textResult.text = "계산 결과: " + result.toString()
//        }
//
//        btnDivide.setOnClickListener {
//            val num1 = edit1.text.toString().toFloat()
//            var num2 = edit2.text.toString().toFloat()
//
//            var result: Float? = null
//
//            result = num1 / num2
//            textResult.text = "계산 결과: " + result.toString()
//        }


    }

    var btnListener = OnClickListener {
        val numStr1 = edit1.text.toString()
        val numStr2 = edit2.text.toString()

        if (numStr1 == "" || numStr2 == "") {
            Toast.makeText(baseContext, "입력을 하지않았습니다.", Toast.LENGTH_LONG).show()

            return@OnClickListener
        }
//        else if ((it.id == R.id.btnDivide || it.id == R.id.btnMod) && numStr2 == "0") {
//            Toast.makeText(baseContext, "0으로 나누거나 할 수 없습니다.", Toast.LENGTH_LONG).show()
//
//            return@OnClickListener
//        }

        val num1 = numStr1.toDouble()
        val num2 = numStr2.toDouble()

        when (it.id) {
            R.id.btnPlus -> result = num1 + num2
            R.id.btnMinus -> result = num1 - num2
            R.id.btnMultiply -> result = num1 * num2
            R.id.btnDivide -> {
                if (num2 == 0.0) {
                    Toast.makeText(baseContext, "0으로 나누거나 할 수 없습니다.", Toast.LENGTH_LONG).show()

                    return@OnClickListener
                }
                result = num1 / num2
            }
            R.id.btnMod ->{
                if (num2 == 0.0) {
                    Toast.makeText(baseContext, "0으로 나누거나 할 수 없습니다.", Toast.LENGTH_LONG).show()

                    return@OnClickListener
                }
                result = num1 % num2
            }
        }
        textResult.text = "계산 결과: " + result
    }
}