package com.lev.modern_arch_2017.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.lev.modern_arch_2017.R
import com.lev.modern_arch_2017.domain.entity.Task
import java.util.*

/**
 * Author: Lev
 * Date: 17.05.2017
 */

class TaskListAdapter(context: Context, private val mListener: TaskListAdapter.OnItemClickListener?) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(mInflater.inflate(R.layout.task_list_item, parent, false)) {
        @BindView(R.id.title)
        lateinit var title: TextView

        @BindView(R.id.description)
        lateinit var description: TextView

        @BindView(R.id.checkBox)
        lateinit var checkBox: CheckBox

        init {
            ButterKnife.bind(this, itemView)
        }

        fun setOnClickListener(listener: View.OnClickListener) {
            itemView.setOnClickListener(listener)
        }
    }

    interface OnItemClickListener {
        fun onClick(id: Int)
    }

    private val mInflater: LayoutInflater
    private val mData = ArrayList<Task>()

    init {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = mData[position]
        holder.title.text = task.title
        holder.description.text = task.description

        if (mListener != null)
            holder.setOnClickListener(View.OnClickListener {
                v -> mListener.onClick(mData[position].id) })
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setData(tasks: Collection<Task>) {
        mData.clear()
        mData.addAll(tasks)
        notifyDataSetChanged()
    }
}
