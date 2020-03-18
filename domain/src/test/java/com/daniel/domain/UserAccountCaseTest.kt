package com.daniel.domain

import com.daniel.domain.dto.UserAccount
import com.daniel.domain.usecases.UserAccountUseCase
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserAccountCaseTest {

    @Test
    fun shouldRetrieveStatementSuccessfully() {
        // given
        val userAccount: UserAccount = mock(UserAccount::class.java)

        val useCase: UserAccountUseCase = mock(UserAccountUseCase::class.java)
        val expectedResult: Single<UserAccount> = Single.just(userAccount)

        // when
        `when`(useCase.getUserAccount("Test","test123")).thenReturn(expectedResult)
        val result: UserAccount = useCase.getUserAccount("Test","test123").blockingGet()

        //then
        TestCase.assertEquals(userAccount, result)
    }
}