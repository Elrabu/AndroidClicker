package de.example.androidclicker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import de.example.androidclicker.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    lateinit var button2 : Button
    lateinit var score : TextView
    lateinit var click : Button
    lateinit var multiplier : Button
    lateinit var textclick : TextView
    lateinit var textmultiplier : TextView
    lateinit var totalpoints : TextView

    var bonus : Int = 0
    var overallpoints : Int = 0
    var points : Int = 0
    var multi : Int = 1
    var pts : Int = 10
    var mul = 100
    var totalpts : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        button2 = findViewById(R.id.button2)
        click = findViewById(R.id.click)
        multiplier = findViewById(R.id.multiplier)
        score = findViewById<TextView>(R.id.points)
        textclick = findViewById<TextView>(R.id.textclick)
        textmultiplier = findViewById<TextView>(R.id.textmultiplier)
        totalpoints = findViewById<TextView>(R.id.totalpoints)

        button2.setOnClickListener(listener2)
        click.setOnClickListener(listenerclick)
        multiplier.setOnClickListener(listenermultiplier)


    }

    val listener2 = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.button2 -> {
                //   button2.setText("test")
                points = 1

                // println(bonus)
                textclick.text = " $bonus" //$bonus
                multiplier.text= ("Upgarde Multiplier: $mul")
                totalpts = (points + bonus) * multi
                totalpoints.text = ("Points per Click: $totalpts")
                overallpoints += (points + bonus) * multi //Hier noch den Multiplier einfügen?

                //   score.textSize = 20.0F
                score.text = "Your Points: $overallpoints"
                println(multi)
                println(overallpoints)
                println(mul)
            }
        }
    }

    val listenerclick = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.click -> {
                if(overallpoints >= pts) {
                    //    println("test")
                    overallpoints -= pts

                    score.text = "Your Points: $overallpoints"
                    totalpoints.text = ("Points per Click: $totalpts")
                    pts += pts / 2
                    bonus += 5
                    textclick.text = " $bonus"
                    //  pts = 20 // Erhöhen der Upgarde Kosten
                    click.setText("Upgrade Points per Click: $pts")

                    //     var str2 = bonus
                    //    textclick.text = "$str2"
                }
                //To-Do: check nach 10 points, dann Kosten erhöhen //

            }
        }
    }

    val listenermultiplier = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.multiplier -> {
                if(overallpoints >= mul) {
                    overallpoints -= mul

                    score.text = "Your Points: $overallpoints"
                    totalpoints.text = ("Points per Click: $totalpts")
                    mul *= 2
                    //  println("test2")
                    multi += 1

                    //To-Do: check nach 100 points, dann Kosten erhöhen
                    //  mul = 200 // Erhöhen der Upgrade Kosten
                    multiplier.setText("Upgarde Multiplier: $mul")
                    //   multi = 2
                    var str3 = multi
                    textmultiplier.text = "X $str3"
                }


            }
        }
    }
}