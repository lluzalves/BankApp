package com.daniel.domain.usecases

import com.daniel.domain.dto.Statement
import com.daniel.domain.repositories.statements.StatementRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class StatementsUseCase : UseCase<Statement>(), KoinComponent {

    private val statementRepository: StatementRepository by inject()

    override fun buildUseCase(): Single<List<Statement>> {
        return statementRepository.retrieveListOf()
    }

}