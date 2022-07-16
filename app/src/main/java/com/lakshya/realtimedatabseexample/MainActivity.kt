package com.lakshya.realtimedatabseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val texttt:TextView=findViewById(R.id.textView2)
        val butt :Button=findViewById(R.id.button)
        val bgg :LinearLayout=findViewById(R.id.linear)
        val data :EditText=findViewById(R.id.edit)
        val database = Firebase.database
        val myRef = database.getReference("message")
        butt.setOnClickListener{
            val getText=data.text.toString()
            myRef.setValue(getText)



        }
        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                texttt.setText(value)
                if(value.equals("Blue")|| value.equals("blue") )
                {
                   bgg.setBackgroundResource(R.color.blue)
                }
                else if(value.equals("yellow"))
                {
                    bgg.setBackgroundResource(R.color.yellow)
                }
                else if(value.equals("red"))
                {
                    bgg.setBackgroundResource(R.color.red)
                }
                else if(value.equals("purple"))
                {
                    bgg.setBackgroundResource(R.color.purple_200)
                }else if(value.equals("purple"))
                {
                    bgg.setBackgroundResource(R.color.purple_200)
                }


                }




            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}