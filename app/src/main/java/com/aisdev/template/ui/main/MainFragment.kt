package com.aisdev.template.ui.main

import android.content.Context
import androidx.fragment.app.viewModels
import com.aisdev.template.databinding.FragmentMainBinding
import com.aisdev.template.ui.BaseFragment
import com.aisdev.template.di.ViewModelFactory
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override val binding: FragmentMainBinding
        get() = FragmentMainBinding.inflate(layoutInflater)

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels(factoryProducer = { factory })

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel.bind()
    }

    companion object {

        fun newInstance() = MainFragment()
    }
}
