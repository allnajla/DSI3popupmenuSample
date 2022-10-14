package com.example.popupmenu

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var button :Button
    lateinit var constraintLayout : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constraintLayout =findViewById(R.id.constraintLayout)
        button = findViewById(R.id.button)
        // button click listener
        button.setOnClickListener {
            showPopupMenu()
        }
    }


    // method to show popup menu
    private fun showPopupMenu(){
        PopupMenu(this,button).apply {

            // inflate the popup menu
            menuInflater.inflate(R.menu.popupmenu,menu)

            // popup menu item click listener
            setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.red->{
                        constraintLayout.background = ColorDrawable(Color.RED)
                    }R.id.green->{
                    constraintLayout.background = ColorDrawable(Color.GREEN)
                }R.id.yellow->{
                    constraintLayout.background = ColorDrawable(Color.YELLOW)
                }R.id.gray->{
                    constraintLayout.background = ColorDrawable(Color.GRAY)
                }
                }

                false
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // show icon on popup menu
                this.setForceShowIcon(true)
            }

            // finally, show the popup menu
            show()
        }
    }
}