package com.lev.modern_arch_2017.presentation.view.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import butterknife.BindView
import butterknife.ButterKnife
import com.lev.modern_arch_2017.R
import com.lev.modern_arch_2017.domain.entity.Task
import com.lev.modern_arch_2017.presentation.presenter.Presenter
import com.lev.modern_arch_2017.presentation.presenter.TaskListPresenter
import com.lev.modern_arch_2017.presentation.view.adapter.TaskListAdapter


/**
 * Author: Lev
 * Date: 17.05.2017
 */

class TaskListFragment : BaseFragment() {

    @BindView(R.id.recycler_view)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.progress_bar)
    lateinit var progressBar: View

    @BindView(R.id.zero_state)
    lateinit var zeroState: View

    private var mAdapter: TaskListAdapter? = null

    lateinit var presenter: TaskListPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = ViewModelProviders.of(activity).get(TaskListPresenter::class.java)
        mAdapter = TaskListAdapter(context, object : TaskListAdapter.OnItemClickListener {
            override fun onClick(id: Int) {
                presenter.onItemClick(id)
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.task_list_fragment, container, false)
        ButterKnife.bind(this, view)
        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadTasks()
    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE
        zeroState.visibility = View.GONE
        recyclerView.visibility = View.GONE
    }

    fun showZeroState() {
        progressBar.visibility = View.GONE
        zeroState.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    fun displayTasks(tasks: List<Task>) {
        mAdapter!!.setData(tasks)
        progressBar.visibility = View.GONE
        zeroState.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun basePresenter(): Presenter {
        return presenter
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_update) presenter.loadTasks()
        return true
    }
}
