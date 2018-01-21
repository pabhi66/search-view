package com.abhi.searchview.search

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.abhi.searchview.R
import com.abhi.searchview.utils.bindView
import com.abhi.searchview.utils.*

import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.google_material_typeface_library.GoogleMaterial

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 1/17/18.
 */
class SearchItem(val key: String,
                 val content: String = key,
                 val description: String? = null,
                 val iicon: IIcon? = GoogleMaterial.Icon.gmd_search,
                 val image: Drawable? = null
) : ItemHelper<SearchItem, SearchItem.ViewHolder>(
        R.layout.search_item,
        { ViewHolder(it) },
        R.id.item_search
) {

    companion object {
        var foregroundColor: Int = 0xdd000000.toInt()
        var backgroundColor: Int = 0xfffafafa.toInt()
    }

    var styledContent: SpannableStringBuilder? = null

    /**
     * Highlight the subText if it is present in the content
     */
    fun withHighlights(subText: String) {
        val index = content.indexOf(subText, ignoreCase = true)
        if (index == -1) return
        styledContent = SpannableStringBuilder(content)
        styledContent!!.setSpan(StyleSpan(Typeface.BOLD), index, index + subText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.title.setTextColor(foregroundColor)
        holder.desc.setTextColor(foregroundColor.adjustAlpha(0.6f))

        if (image != null) holder.icon.setImageDrawable(image)
        else holder.icon.setIcon(iicon, sizeDp = 18, color = foregroundColor)

        holder.container.setRippleBackground(foregroundColor, backgroundColor)
        holder.title.text = styledContent ?: content
        if (description?.isNotBlank() == true) holder.desc.visible().text = description
        holder.desc.visible().text = "ABC"
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val icon: ImageView by bindView(R.id.search_icon)
        val title: TextView by bindView(R.id.search_title)
        val desc: TextView by bindView(R.id.search_desc)
        val container: ConstraintLayout by bindView(R.id.search_item_frame)
    }


}