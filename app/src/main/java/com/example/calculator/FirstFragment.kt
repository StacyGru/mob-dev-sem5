package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels


class FirstFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val firstInput : EditText = view.findViewById(R.id.first_number)

        val nextBtn : Button = view.findViewById(R.id.next)
        nextBtn.setOnClickListener{
            dataModel.firstNumber.value = firstInput.text.toString()

            val fragment = SecondFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        val frag1Btn : Button = view.findViewById(R.id.fragment_1)
        frag1Btn.setOnClickListener{
            val fragment = FirstFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)?.commit()
        }
        return view
    }

//    override fun onViewCreated(
//        view: View,
//        inflater: LayoutInflater,
//        savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }

}
