package com.aisdev.template.ui.main

import android.os.Bundle
import androidx.fragment.app.commit
import com.aisdev.moduleandroid.AndroidModuleClass
import com.aisdev.modulekotlin.KotlinModuleClass
import com.aisdev.template.R
import com.aisdev.template.databinding.ActivityMainBinding
import com.aisdev.template.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val binding: ActivityMainBinding
        get() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.container, MainFragment.newInstance())
            }
        }

        // Verify new binding API is working
        checkNotNull(binding.container)

        // Ensure module dependencies are working
        KotlinModuleClass()
        AndroidModuleClass()
    }
}
