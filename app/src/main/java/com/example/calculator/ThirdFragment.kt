package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.fragment.app.activityViewModels


class ThirdFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val plusBtn : Button = view.findViewById(R.id.plus)
        val minusBtn : Button = view.findViewById(R.id.minus)
        val multBtn : Button = view.findViewById(R.id.multiply)
        val divBtn : Button = view.findViewById(R.id.divide)
        plusBtn.setOnClickListener{
            dataModel.action.value = "+"
        }
        minusBtn.setOnClickListener{
            dataModel.action.value = "-"
        }
        multBtn.setOnClickListener{
            dataModel.action.value = "*"
        }
        divBtn.setOnClickListener{
            dataModel.action.value = "/"
        }

        val prevBtn : Button = view.findViewById(R.id.previous)
        prevBtn.setOnClickListener{
            val fragment = SecondFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val nextBtn : Button = view.findViewById(R.id.next)
        nextBtn.setOnClickListener{
            val fragment = FourthFragment()
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
        val frag3Btn : Button = view.findViewById(R.id.fragment_3)
        frag3Btn.setOnClickListener{
            val fragment = ThirdFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        return view
    }

}
