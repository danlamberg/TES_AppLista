// Aluno: Daniel de Oliveira Lamberg. Atividade III Tópicos Especiais em Software

package com.example.applista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var btnAdd: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StringAdapter
    private val stringList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        btnAdd = findViewById(R.id.btnAdd)
        recyclerView = findViewById(R.id.recyclerView)

        adapter = StringAdapter(stringList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickListener(object : StringAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val selectedString = stringList[position]
                val intent = Intent(this@MainActivity, ItemActivity::class.java)
                intent.putExtra("selectedString", selectedString)
                startActivity(intent)
            }
        })

        btnAdd.setOnClickListener {
            val inputText = editText.text.toString().trim()
            if (inputText.isNotEmpty()) {
                stringList.add(inputText)
                adapter.notifyItemInserted(stringList.size - 1)
                editText.text.clear()
            } else {
                Toast.makeText(this, "Digite uma string válida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
