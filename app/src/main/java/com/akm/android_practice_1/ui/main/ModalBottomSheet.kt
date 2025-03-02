package com.akm.android_practice_1.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akm.android_practice_1.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet: BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(
            R.layout.model_bottom_sheet,
            container, false
        )
        return v
    }
}