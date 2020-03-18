package com.daniel.bankapp.ui.statements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.daniel.bankapp.R
import com.daniel.bankapp.base.DataState
import com.daniel.bankapp.base.ModelListDataState
import com.daniel.domain.dto.Statement
import com.daniel.domain.dto.UserAccount
import kotlinx.android.synthetic.main.statements_overview.*
import org.koin.android.ext.android.inject

class StatementsOverviewFragment : Fragment() {

    private val viewModel: StatementsOverviewViewModel by inject()
    private lateinit var statements: MutableList<Statement>
    private lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager
    private lateinit var statementsOverviewAdapter: StatementsOverviewAdapter
    private lateinit var userAccount: UserAccount


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.statements_overview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareUi()
        viewModel.value.observe(viewLifecycleOwner, Observer { dataState ->
            val data = dataState ?: return@Observer
            onDataStateChangeHandleViewState(data)
        })
        viewModel.getStatements(userAccount.userId.toString())
    }

    private fun prepareUi() {
        val bundle = arguments
        userAccount = bundle?.getSerializable("userAccount") as (UserAccount)
        clientName.text = userAccount.name
        bankAccountAgencyInfo.text =
            getString(R.string.account_agency_info, userAccount.bankAccount, userAccount.agency)
        totalAmountCredit.text = getString(R.string.amount, userAccount.balance.toString())
    }

    private fun onDataStateChangeHandleViewState(statementsData: ModelListDataState<Statement>) {
        when (statementsData.state) {
            DataState.COMPLETED -> {
                progressBarStatements.visibility = View.INVISIBLE
                statements = statementsData.data?.toMutableList() ?: return
                prepareRecycler()
            }
            DataState.LOADING -> {
                progressBarStatements.visibility = View.VISIBLE
                recyclerStatement.visibility = View.INVISIBLE
            }
            DataState.FAILED -> {
                progressBarStatements.visibility = View.INVISIBLE
            }
            DataState.INITIAL -> {
                progressBarStatements.visibility = View.INVISIBLE
            }
        }
    }

    private fun prepareRecycler() {
        staggeredGridLayoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerStatement.layoutManager = staggeredGridLayoutManager
        staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        registerForContextMenu(recyclerStatement)
        recyclerStatement.visibility = View.VISIBLE
        statementsOverviewAdapter = StatementsOverviewAdapter(statements)
        recyclerStatement.adapter = statementsOverviewAdapter
    }

}
