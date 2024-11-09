package com.example.cld

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var isPlayer1 = true
    var gameEnd = false

    private lateinit var top: ImageView
    private lateinit var topStar: ImageView
    private lateinit var topEnd: ImageView

    private lateinit var center: ImageView
    private lateinit var centerStart: ImageView
    private lateinit var centerEnd: ImageView

    private lateinit var bottom: ImageView
    private lateinit var bottomStart: ImageView
    private lateinit var bottomEnd: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        top = findViewById(R.id.top)
        topStar = findViewById(R.id.top_Start)
        topEnd = findViewById(R.id.top_End)

        bottom = findViewById(R.id.bottom)
        bottomStart = findViewById(R.id.bottom_Start)
        bottomEnd = findViewById(R.id.bottom_End)

        center = findViewById(R.id.center)
        centerStart = findViewById(R.id.center_Start)
        centerEnd = findViewById(R.id.center_End)

        val reset: Button = findViewById(R.id.button_reset)
        reset.setOnClickListener {
            resetBox(top)
            resetBox(topStar)
            resetBox(topEnd)

            resetBox(center)
            resetBox(centerStart)
            resetBox(centerEnd)

            resetBox(bottom)
            resetBox(bottomStart)
            resetBox(bottomEnd)

        }


        configureBox(top)
        configureBox(topStar)
        configureBox(topEnd)

        configureBox(center)
        configureBox(centerStart)
        configureBox(centerEnd)

        configureBox(bottom)
        configureBox(bottomStart)
        configureBox(bottomEnd)

        }

       private fun resetBox(box: ImageView) {
           box.setImageDrawable(null)
           box.tag = null
           isPlayer1 = true
           gameEnd = false

       }

        private fun configureBox(box: ImageView) {
            box.setOnClickListener {
                if (box.tag == null && !gameEnd) {
                    if (isPlayer1) {
                        box.setImageResource(R.drawable.baseline_circle_29)
                        isPlayer1 = false
                        box.tag = 1
                    } else {
                        box.setImageResource(R.drawable.baseline_clear_24)
                        isPlayer1 = true
                        box.tag = 2

                    }

                    if (playerWin(1)) {
                        Toast.makeText(this@MainActivity, "Player 1 venceu!", Toast.LENGTH_SHORT).show()
                        gameEnd = true
                    } else if (playerWin(2)) {
                        Toast.makeText(this@MainActivity, "Player 2 venceu!", Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }

        private fun playerWin(value: Int): Boolean {
            if ( (top.tag == value && center.tag == value && bottom.tag == value) ||
                 (topStar.tag == value && centerStart.tag == value && bottomStart.tag == value) ||
                 (topEnd.tag == value && centerEnd.tag == value && bottomEnd.tag == value) ||


                (topStar.tag == value && top.tag == value && topEnd.tag == value) ||
                (centerStart.tag == value && center.tag == value && centerEnd.tag == value) ||
                (bottomStart.tag == value && bottom.tag == value && bottomEnd.tag == value) ||

                (topStar.tag == value && center.tag == value && bottomEnd.tag == value) ||
                (topEnd.tag == value && center.tag == value && bottomStart.tag == value)

                 ){
                return true
            }
                return false
            }


        }




