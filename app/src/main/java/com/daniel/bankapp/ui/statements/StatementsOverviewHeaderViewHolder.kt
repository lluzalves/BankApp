package com.daniel.bankapp.ui.statements

import android.view.View
import com.daniel.bankapp.base.BaseViewHolder
import com.daniel.domain.dto.Statement
import kotlinx.android.synthetic.main.cell_header.view.*
import kotlinx.android.synthetic.main.cell_item_statement.view.*


class StatementsOverviewHeaderViewHolder constructor(itemView: View) :
    BaseViewHolder<String>(itemView), View.OnClickListener {
    private lateinit var headerTitle: String

    override fun onClick(v: View?) {
        //
    }

    override fun show(model: String) {
        headerTitle = model
        itemView.headerTitle.text = headerTitle
    }
}