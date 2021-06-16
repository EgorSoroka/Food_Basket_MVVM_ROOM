package com.example.foodbasket.magpie.food

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbasket.magpie.R
import com.example.foodbasket.magpie.databinding.FragmentFoodBinding
import com.example.foodbasket.magpie.databinding.FragmentMainBinding
import com.example.foodbasket.magpie.models.AppFood
import com.example.foodbasket.magpie.screens.main.MainAdapter
import com.example.foodbasket.magpie.screens.main.MainFragmentViewModel
import com.example.foodbasket.magpie.utilits.APP_ACTIVITY


class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: FoodFragmentViewModel
    private lateinit var mCurrentFood:AppFood

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentFoodBinding.inflate(layoutInflater, container, false)
        mCurrentFood = arguments?.getSerializable("food") as AppFood
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this).get(FoodFragmentViewModel::class.java)
        mBinding.foodName.text = mCurrentFood.name
        mBinding.foodText.text = mCurrentFood.quantity
        mBinding.itemShelfLife.text = mCurrentFood.date
        mBinding.itemCategories.text = mCurrentFood.category
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.food_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_delete -> {
                mViewModel.delete(mCurrentFood){
                    APP_ACTIVITY.navController.navigate(R.id.action_foodFragment_to_mainFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}