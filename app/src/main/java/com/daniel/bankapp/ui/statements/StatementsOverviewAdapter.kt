package com.daniel.bankapp.ui.statements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daniel.bankapp.R
import com.daniel.domain.dto.Statement


private const val TYPE_HEADER = 0
private const val TYPE_ITEM = 1

class StatementsOverviewAdapter constructor(private val statements: List<Statement>, private val headerTitle : String) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var holder: RecyclerView.ViewHolder

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.cell_item_statement, null)
            holder = StatementsOverviewViewHolder(view)
        } else if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_header, null)
            holder = StatementsOverviewHeaderViewHolder(view)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return statements.size+1
    }

    override fun getItemViewType(position: Int): Int {
        return if (isPositionHeader(position)) {
            TYPE_HEADER
        } else {
            TYPE_ITEM
        }
    }

    private fun isPositionHeader(position: Int): Boolean {
        return position == 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StatementsOverviewViewHolder) {
            holder.show(statements[position-1])
        }else if(holder is StatementsOverviewHeaderViewHolder){
            holder.show(headerTitle)
        }
    }


}