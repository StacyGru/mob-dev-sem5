package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner


class FourthFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fourth, container, false)
        val prevBtn: Button = view.findViewById(R.id.previous)

        var result = 0.0
        val num1Text: TextView = view.findViewById(R.id.first_number)
        val num2Text: TextView = view.findViewById(R.id.second_number)
        val actText: TextView = view.findViewById(R.id.action)
        val resText: TextView = view.findViewById(R.id.result)

        dataModel.firstNumber.observe(activity as LifecycleOwner, {
            num1Text.text = it
        })
        dataModel.secondNumber.observe(activity as LifecycleOwner, {
            num2Text.text = it
        })
        dataModel.action.observe(activity as LifecycleOwner, {
            actText.text = it
        })

        if (dataModel.action.value == "+") result = dataModel.firstNumber.value!!.toDouble() + dataModel.secondNumber.value!!.toDouble()
        if (dataModel.action.value == "-") result = dataModel.firstNumber.value!!.toDouble() - dataModel.secondNumber.value!!.toDouble()
        if (dataModel.action.value == "*") result = dataModel.firstNumber.value!!.toDouble() * dataModel.secondNumber.value!!.toDouble()
        if (dataModel.action.value == "/") result = dataModel.firstNumber.value!!.toDouble() / dataModel.secondNumber.value!!.toDouble()

        resText.text = result.toString()

        prevBtn.setOnClickListener {
            val fragment = ThirdFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val frag1Btn: Button = view.findViewById(R.id.fragment_1)
        frag1Btn.setOnClickListener {
            val fragment = FirstFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val frag2Btn: Button = view.findViewById(R.id.fragment_2)
        frag2Btn.setOnClickListener {
            val fragment = SecondFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val frag3Btn: Button = view.findViewById(R.id.fragment_3)
        frag3Btn.setOnClickListener {
            val fragment = ThirdFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val frag4Btn: Button = view.findViewById(R.id.fragment_4)
        frag4Btn.setOnClickListener {
            val fragment = FourthFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        return view
    }
}
