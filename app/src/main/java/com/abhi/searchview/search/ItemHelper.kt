package com.abhi.searchview.search

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import com.mikepenz.fastadapter.IClickable
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.items.AbstractItem

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 1/17/18.
 */
open class ItemHelper<Item, VH : RecyclerView.ViewHolder>(
        @param:LayoutRes private val layoutRes: Int,
        private val viewHolder: (v: View) -> VH,
        private val type: Int = layoutRes
) : AbstractItem<Item, VH>() where Item : IItem<*, *>, Item : IClickable<*> {
    override final fun getType(): Int = type
    override final fun getViewHolder(v: View): VH = viewHolder(v)
    override final fun getLayoutRes(): Int = layoutRes

}