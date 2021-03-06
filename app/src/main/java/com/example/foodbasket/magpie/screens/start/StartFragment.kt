package com.example.foodbasket.magpie.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.foodbasket.magpie.R
import com.example.foodbasket.magpie.databinding.FragmentStartBinding
import com.example.foodbasket.magpie.utilits.APP_ACTIVITY

class StartFragment : Fragment() {

    private var _binding:FragmentStartBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }


    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        mViewModel.initDatabase()
        mBinding.btnAboutTheApp.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_aboutTheApplication)
        }
        mBinding.btnOpenBasket.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




