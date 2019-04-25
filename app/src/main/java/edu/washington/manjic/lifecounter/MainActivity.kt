package edu.washington.manjic.lifecounter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val playerIds: IntArray =
        intArrayOf(R.id.player1, R.id.player2, R.id.player3,
            R.id.player4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var n: Int = 0
        for (i in playerIds){
            n += 1
            startGame(i, n)
        }
    }

    private fun startGame(playerID: Int, playerNumber: Int){
        val player = findViewById<View>(playerID)
        activateButtons(player, R.id.btn_minus1, -1, playerNumber)
        activateButtons(player, R.id.btn_minus5, -5, playerNumber)
        activateButtons(player, R.id.btn_plus1, 1, playerNumber)
        activateButtons(player, R.id.btn_plus5, 5, playerNumber)
    }

    private fun activateButtons(player: View, buttonID: Int, difference: Int, playerNumber: Int) {
        val lifeAmountLabel = player.findViewById<TextView>(R.id.text_player_life_amount)
        val button = player.findViewById<Button>(buttonID)

        button.setOnClickListener{
            var lifeAmount = lifeAmountLabel.text.toString().toInt()
            if (lifeAmount > 0){
                lifeAmount += difference
                lifeAmountLabel.text = lifeAmount.toString()
            }
            if (lifeAmount <= 0){
                val notifyDeath: TextView = findViewById(R.id.text_death_display)
                notifyDeath.text = "Player " + playerNumber + " LOSES!"
                notifyDeath.visibility = View.VISIBLE
            }
        }
    }
}
