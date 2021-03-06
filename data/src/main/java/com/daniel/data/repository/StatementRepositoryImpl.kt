package com.daniel.data.repository

import com.daniel.commons.applyScheduler
import com.daniel.data.adapters.Adapter
import com.daniel.data.services.BankService
import com.daniel.data.services.Urls
import com.daniel.domain.dto.Statement
import com.daniel.domain.repositories.statements.StatementRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class StatementRepositoryImpl : StatementRepository, KoinComponent {

    private val bankService: BankService by inject()

    override fun retrieveStatements(userId: String) : Single<List<Statement>> {
        return bankService.getStatements(userId)
            .applyScheduler()
            .map { response ->
                val statements = ArrayList<Statement>()
                return@map response.statementList.mapTo(
                    destination = statements
                ) { statementEntity ->
                    Adapter.toStatement(statementEntity)
                }
            }
    }

    override fun retrieveListOf(): Single<List<Statement>> {
        TODO("Not yet implemented for now")

    }

    override fun retrieveItem(): Statement {
        TODO("Not yet implemented for now")
    }
}