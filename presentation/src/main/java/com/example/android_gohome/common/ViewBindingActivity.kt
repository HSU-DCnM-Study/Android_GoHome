package com.example.android_gohome.common

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class ViewBindingActivity<VB : ViewBinding> : AppCompatActivity() {

    abstract val bindingInflater: (LayoutInflater) -> VB

    private var _binding: VB? = null
    protected val binding: VB get() = requireNotNull(_binding)

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}