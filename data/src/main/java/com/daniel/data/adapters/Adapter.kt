package com.daniel.data.adapters

import com.daniel.data.entities.StatementEntity
import com.daniel.data.entities.UserAccountEntity
import com.daniel.domain.dto.Statement
import com.daniel.domain.dto.UserAccount


object Adapter {
    fun toStatement(statementEntity: StatementEntity) = Statement(
        title = statementEntity.title,
        description = statementEntity.description,
        date = statementEntity.date,
        value = statementEntity.value
    )

    fun toUserAccount(userAccountEntity: UserAccountEntity) = UserAccount(
        userId = userAccountEntity.userId,
        name = userAccountEntity.name,
        agency = userAccountEntity.agency,
        balance = userAccountEntity.balance,
        bankAccount = userAccountEntity.bankAccount
    )
}