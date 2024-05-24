package com.busanit.ex2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.busanit.ex2.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,  container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(binding.root.context)
            builder.apply {
                setTitle("기본 다이얼로그")
                setPositiveButton("예") { dialog, which ->
                    binding.text.text = "예, 두번째 프레그먼트 입니다."
                }
                setNegativeButton("아니요") { dialog, which ->
                    binding.text.text = "아니오, 두번째 프레그먼트 입니다."
                }
            }
            builder.show()
        }


    }
}