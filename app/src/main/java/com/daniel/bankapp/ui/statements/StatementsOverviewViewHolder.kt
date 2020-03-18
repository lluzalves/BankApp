package com.daniel.bankapp.ui.statements

import android.view.View
import com.daniel.bankapp.R
import com.daniel.bankapp.base.BaseViewHolder
import com.daniel.domain.dto.Statement
import kotlinx.android.synthetic.main.cell_item_statement.view.*


class StatementsOverviewViewHolder constructor(itemView: View) : BaseViewHolder<Statement>(itemView), View.OnClickListener {
    private lateinit var statement: Statement

    override fun show(model: Statement) {
        statement = model
        itemView.paymentAmount.text = itemView.context.getString(R.string.amount,statement.value.toString())
        itemView.paymentDate.text = statement.date
        itemView.paymentDescription.text = statement.description
        itemView.paymentLabel.text = statement.title
    }

    override fun onClick(v: View?) {
        //
    }
}