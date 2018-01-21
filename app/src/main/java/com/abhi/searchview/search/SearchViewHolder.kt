package com.abhi.searchview.search

import android.view.MenuItem

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 1/17/18.
 *
 * Interface to help facilitate searchview binding and actions
 */
interface SearchViewHolder {

    var searchView: SearchView?

    fun searchViewBindIfNull(binder: () -> SearchView) {
        if (searchView == null) searchView = binder()
    }

    fun searchViewOnBackPress() = searchView?.onBackPressed() ?: false

    fun searchViewUnBind(replacementMenuItemClickListener: ((item: MenuItem) -> Boolean)? = null) {
        searchView?.unBind(replacementMenuItemClickListener)
        searchView = null
    }
}