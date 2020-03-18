package com.daniel.domain

import com.daniel.domain.dto.Statement
import com.daniel.domain.usecases.StatementsUseCase
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class StatementsUseCaseTest {

    @Test
    fun shouldRetrieveStatementSuccessfully() {
        // given
        val statement: Statement = mock(Statement::class.java)
        val statements: ArrayList<Statement> = Mockito.spy(ArrayList())
        statements.add(statement)
        val userId = "1"

        val useCase: StatementsUseCase = mock(StatementsUseCase::class.java)
        val expectedResult: Single<List<Statement>> = Single.just(statements)

        // when
        `when`(useCase.getStatements(userId)).thenReturn(expectedResult)
        val resultList: List<Statement> = useCase.getStatements(userId).blockingGet()

        //then
        TestCase.assertEquals(statements, resultList)
    }
}