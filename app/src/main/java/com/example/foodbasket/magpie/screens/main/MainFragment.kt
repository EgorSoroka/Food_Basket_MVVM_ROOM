package com.example.foodbasket.magpie.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbasket.magpie.R
import com.example.foodbasket.magpie.databinding.FragmentMainBinding
import com.example.foodbasket.magpie.models.AppFood
import com.example.foodbasket.magpie.utilits.APP_ACTIVITY


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel:MainFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter:MainAdapter
    private lateinit var mObserverList: Observer<List<AppFood>>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mAdapter = MainAdapter()
        mRecyclerView  = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter.setList(list)
        }

        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mViewModel.allProducts.observe(this, mObserverList)
        mBinding.btnAddFood.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNewFoodFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mViewModel.allProducts.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }

    companion object{
        fun  click(food: AppFood){
            val bundle = Bundle()
            bundle.putSerializable("food", food)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_foodFragment, bundle)
        }
    }


}