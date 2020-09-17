package com.android.infocus

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class InFocus : DialogFragment() {

    private val backgroundColorResource: Int = android.R.color.transparent

    companion object {

        @JvmStatic
        fun newInstance(): InFocus {
            return InFocus()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.infocus_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeFullScreen()

    }

    private fun makeFullScreen() {
        val window = dialog?.window ?: return
        window.setBackgroundDrawableResource(backgroundColorResource)
        window.decorView.setPadding(0, 0, 0, 0)
        with(window.attributes) {
            gravity = Gravity.BOTTOM
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.MATCH_PARENT
        }
    }

    fun launch(activity: AppCompatActivity) {
        show(activity.supportFragmentManager, "InFocus")
    }
}