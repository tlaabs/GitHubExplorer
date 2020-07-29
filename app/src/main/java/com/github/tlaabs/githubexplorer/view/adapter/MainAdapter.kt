package com.github.tlaabs.githubexplorer.view.adapter

import android.content.res.Resources
import android.view.View
import com.github.tlaabs.githubexplorer.R
import com.github.tlaabs.githubexplorer.listener.FilterListener
import com.github.tlaabs.githubexplorer.model.MainContent
import com.github.tlaabs.githubexplorer.model.Repository
import com.github.tlaabs.githubexplorer.viewholder.FilterVH
import com.github.tlaabs.githubexplorer.viewholder.ItemVH
import com.github.tlaabs.githubexplorer.viewholder.ProfileVH
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.skydoves.baserecyclerviewadapter.SectionRow

class MainAdapter(
    private val filterListener: FilterListener
) : BaseAdapter() {
    private val SECTION_COUNT = 3

    private val SECTION_PROFILE = 0
    private val SECTION_FILTER = 1
    private val SECTION_ITEM = 2

    init {
        for (i in 0 until SECTION_COUNT) {
            addSection(ArrayList<Any>())
        }
    }

    fun addRepoItems(items: List<Repository>?) {
        val count = sectionCount(SECTION_ITEM)
        if (items != null) {
            addItemListOnSection(SECTION_ITEM, items)
            notifyItemRangeInserted(sectionCount(SECTION_ITEM)+SECTION_COUNT-1,count)
        }
    }

    fun init(content: MainContent) {
        clear()
        if (content.user != null) {
            addItemOnSection(SECTION_PROFILE, content.user)
        }

        if(content.filter != null) {
            addItemOnSection(SECTION_FILTER, content.filter)
        }

        if (content.repos != null) {
            addItemListOnSection(SECTION_ITEM, content.repos)
        }
        notifyDataSetChanged()
    }

    fun clear() {
        for (i in 0 until SECTION_COUNT) {
            sections()[i].clear()
        }
        notifyDataSetChanged()
    }

    override fun layout(sectionRow: SectionRow): Int {
        when (sectionRow.section) {
            SECTION_PROFILE -> return R.layout.list_user
            SECTION_FILTER -> return R.layout.list_filter
            SECTION_ITEM -> return R.layout.list_item
        }
        throw Resources.NotFoundException("not founded section type")
    }

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        when (layout) {
            R.layout.list_user -> return ProfileVH(view)
            R.layout.list_filter -> return FilterVH(view,filterListener)
            R.layout.list_item -> return ItemVH(view)
        }
        throw Resources.NotFoundException("not founded layout")
    }
}