package com.kapps.wallet.presentation

import com.kapps.wallet.MainDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class WalletViewModelTest {
    @get:Rule
    val dispatcherRule = MainDispatcherRule()
    private lateinit var viewModel: WalletViewModel

    @Test
    fun `transaction value 가 변화하고 currentValueInput이 파라미터와 동일하다`() = runTest {
        val newTransactionValue = "1000"
        viewModel = WalletViewModel()
        //when
        viewModel.onTransactionValueChange(newTransactionValue)

        //then
        val result = viewModel.transactionDialogState.currentValueInput
        assertEquals(newTransactionValue,result)

    }
    @Test
    fun `onDepositClick 이후 1000 점 5 afterComma is 50 beforeComma is 1000`() = runTest {
        val newTransactionValue = "1000.5"
        viewModel = WalletViewModel()

        //when
        viewModel.onDepositClick()
        viewModel.onTransactionValueChange(newTransactionValue)
        viewModel.onTransactionConfirm()

        val beforeComma = viewModel.totalAmountBeforeComma
        val afterComma = viewModel.totalAmountAfterComma

        //then
        assertEquals(beforeComma,1000)
        assertEquals(afterComma,50)
    }

}