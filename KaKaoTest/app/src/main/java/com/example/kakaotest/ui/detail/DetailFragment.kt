package com.example.kakaotest.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.example.kakaotest.R
import com.example.kakaotest.binding.FragmentDataBindingComponent
import com.example.kakaotest.databinding.DetailFragmentBinding
import com.example.kakaotest.di.Injectable
import javax.inject.Inject

class DetailFragment : Fragment(),Injectable{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var detailViewModel: DetailViewModel

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    lateinit var binding : DetailFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<DetailFragmentBinding>(
            inflater,
            R.layout.detail_fragment,
            container,
            false
        )
        binding = dataBinding
        //sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        detailViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(DetailViewModel::class.java)
        val params = DetailFragmentArgs.fromBundle(arguments!!)
        detailViewModel.setId(params.imageUrl, params.siteName)
        binding.setLifecycleOwner(viewLifecycleOwner)
        binding.document = detailViewModel.document
    }

}