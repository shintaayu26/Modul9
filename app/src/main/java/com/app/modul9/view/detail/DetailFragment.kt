package com.app.modul9.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.modul9.R
import com.app.modul9.databinding.FragmentDetailBinding
import com.app.modul9.viewmodel.ViewModelMahasiswa

class DetailFragment : Fragment() {
    lateinit var viewModel: ViewModelMahasiswa
    lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nim = arguments?.getString("nim")

        val viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        viewModel.getDetailDataMahasiswa().observe(viewLifecycleOwner){
            if(it != null){
                binding.txtnim.text = it.data?.nIM
                binding.txtnama.text = it.data?.nama
                binding.txtTelepon.text = it.data?.telepon
            }else{
                Toast.makeText(context,"Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.getDetailData(nim!!)
    }
}