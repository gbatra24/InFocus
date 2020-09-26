package com.android.infocus.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.infocus.R
import com.android.infocus.adapters.UpdatesAdapter
import com.android.infocus.data.ItemUpdates
import com.android.infocus.databinding.InfocusHomeBinding

class InFocus : DialogFragment() {

    private lateinit var binding : InfocusHomeBinding
    private val backgroundColorResource: Int = android.R.color.transparent
    private var itemTitleColor: Int? = null
    private var itemContentColor: Int? = null
    private var iconColor: Int? = null

    val mItems: ArrayList<ItemUpdates> by lazy {
        requireArguments().getParcelableArrayList<ItemUpdates>(ARGUMENT) as ArrayList<ItemUpdates>
    }

    companion object {

        const val TAG = "InFocus"
        const val ARGUMENT = "arg"

        @JvmStatic
        fun newInstance(vararg items: ItemUpdates): InFocus = this.newInstance(items.toList())

        @JvmStatic
        fun newInstance(items: List<ItemUpdates>) : InFocus {
            val list = ArrayList<ItemUpdates>()
            list.addAll(items)

            val bundle = Bundle().apply {
                putParcelableArrayList(ARGUMENT, list)
            }

            return InFocus().apply { arguments = bundle }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.infocus_home, container, false)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeFullScreen()
        setupRecyclerView()

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

    private fun setupRecyclerView() {
        with(binding.itemsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = UpdatesAdapter(mItems, requireContext()).apply {
                this@InFocus.itemContentColor?.let { this@apply.contentColor = it }
                this@InFocus.itemTitleColor?.let { this@apply.titleColor = it }
                this@InFocus.iconColor?.let { this@apply.iconColor = it } }
        }
    }

    fun launch(activity: AppCompatActivity) {
        show(activity.supportFragmentManager, TAG)
    }
}