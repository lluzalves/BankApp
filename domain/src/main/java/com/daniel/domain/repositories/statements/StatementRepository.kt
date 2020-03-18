package com.daniel.domain.repositories.statements

import com.daniel.domain.dto.Statement
import com.daniel.domain.repositories.Repository
import io.reactivex.Single

interface StatementRepository : Repository<Statement> {
    fun retrieveStatements(userId: String): Single<List<Statement>>
}