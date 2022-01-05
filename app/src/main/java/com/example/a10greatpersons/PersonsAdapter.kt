package com.example.a10greatpersons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a10greatpersons.databinding.RecyclerviewItemBinding

class PersonsAdapter(
    var personsList: MutableList<Person>,
    private val clickCard: (Person) -> Unit,
    private val clickLike: (Person) -> Unit) :
RecyclerView.Adapter<PersonsAdapter.PersonsHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonsHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonsHolder(binding, clickCard, clickLike)
    }

    override fun onBindViewHolder(holder: PersonsHolder, position: Int) {
        val person = personsList[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return personsList.size
    }

    inner class PersonsHolder internal constructor(
        private val binding: RecyclerviewItemBinding,
        private val clickCard: (Person) -> Unit,
        private val clickLike: (Person) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) = binding.run {
            name.text = person.name
            gender.text = person.gender
            years.text = person.years_of_life
            description.text = person.description
            photo.setImageResource(person.photo)

            binding.card.setOnClickListener()
            {
                clickCard.invoke(person)
            }

            binding.like.setOnClickListener()
            {
                clickLike.invoke(person)
            }
        }
    }
}


