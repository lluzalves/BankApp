package com.daniel.bankapp.ui.statements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daniel.bankapp.R
import com.daniel.domain.dto.Statement

class StatementsOverviewAdapter constructor(private val statement: List<Statement>) : RecyclerView.Adapter<StatementsOverviewViewHolder>() {

    private lateinit var holder: StatementsOverviewViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatementsOverviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_item_statement, null)
        holder = StatementsOverviewViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return statement.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: StatementsOverviewViewHolder, position: Int) {
        holder.show(statement[position])
    }
}