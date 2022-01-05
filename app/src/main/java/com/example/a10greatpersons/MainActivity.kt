package com.example.a10greatpersons

import android.content.Context
import android.os.Bundle
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10greatpersons.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PersonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = PersonsAdapter(PersonsHolder.getPersonsList(), ::onClickCard, ::onClickLike)

        }

    private fun onClickCard(person: Person): Unit
    {
        Snackbar.make(binding.root, "Нажата карточка: " + person.name, Snackbar.LENGTH_LONG).show()
    }

    private fun onClickLike(person: Person): Unit
    {
        Snackbar.make(binding.root, "Нажат лайк: " + person.name, Snackbar.LENGTH_LONG).show()
    }

}