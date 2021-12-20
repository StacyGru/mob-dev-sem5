package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels


class SecondFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val secondInput : EditText = view.findViewById(R.id.second_number)

        val prevBtn : Button = view.findViewById(R.id.previous)
        prevBtn.setOnClickListener{
            val fragment = FirstFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val nextBtn : Button = view.findViewById(R.id.next)
        nextBtn.setOnClickListener{
            dataModel.secondNumber.value = secondInput.text.toString()

            val fragment = ThirdFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val frag1Btn : Button = view.findViewById(R.id.fragment_1)
        frag1Btn.setOnClickListener{
            val fragment = FirstFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val frag2Btn : Button = view.findViewById(R.id.fragment_2)
        frag2Btn.setOnClickListener{
            val fragment = SecondFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        return view
    }

}
