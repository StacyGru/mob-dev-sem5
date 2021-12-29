package com.example.a10greatpersons

import android.content.Context
import android.os.Bundle
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10greatpersons.databinding.ActivityMainBinding

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

        binding.recyclerView.adapter = PersonsAdapter(PersonsHolder.getPersonsList())

        }

    class CircleImageView(
        context: Context
    ) : AppCompatImageView(context) {

        init {
            //the outline (view edges) of the view should be derived    from the background
            outlineProvider = ViewOutlineProvider.BACKGROUND
            //cut the view to match the view to the outline of the background
            clipToOutline = true
            //use the following background to calculate the outline
            setBackgroundResource(R.drawable.circle_image)

            //fill in the whole image view, crop if needed while keeping the center
            scaleType = ScaleType.CENTER_CROP
        }
    }

}