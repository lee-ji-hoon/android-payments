package nextstep.payments.ui.screen.editcard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.payments.R
import nextstep.payments.ui.component.card.PaymentCard
import nextstep.payments.ui.component.text.CreditCardVisualTransformation
import nextstep.payments.ui.component.text.ExpirationDateVisualTransformation
import nextstep.payments.ui.component.topbar.PaymentsDefaultTopBar
import nextstep.payments.ui.screen.newcard.model.BankTypeModel

@Composable
fun EditCardRoute(
    modifier: Modifier = Modifier
) {
    val snackbarHostState = remember { SnackbarHostState() }
}

@Composable
internal fun EditCardScreen(
    cardNumber: String,
    expiredDate: String,
    ownerName: String,
    password: String,
    bankType: BankTypeModel?,
    snackbarHostState: SnackbarHostState,
    onSaveClick: () -> Unit,
    onBackClick: () -> Unit,
    setCardNumber: (String) -> Unit,
    setExpiredDate: (String) -> Unit,
    setOwnerName: (String) -> Unit,
    setPassword: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            PaymentsDefaultTopBar(
                title = stringResource(R.string.edit_card_top_bar_action_icon),
                onBackClick = { onBackClick() },
                onSaveClick = { onSaveClick() }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(14.dp))

            PaymentCard(
                cardNumber = cardNumber,
                cardOwnerName = ownerName,
                cardExpiredDate = expiredDate,
                bankType = bankType,
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = cardNumber,
                onValueChange = setCardNumber,
                label = { Text("카드 번호") },
                placeholder = { Text("0000 - 0000 - 0000 - 0000") },
                visualTransformation = CreditCardVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = expiredDate,
                onValueChange = setExpiredDate,
                label = { Text("만료일") },
                placeholder = { Text("MM / YY") },
                visualTransformation = ExpirationDateVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = ownerName,
                onValueChange = setOwnerName,
                label = { Text("카드 소유자 이름(선택)") },
                placeholder = { Text("카드에 표시된 이름을 입력하세요.") },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = password,
                onValueChange = setPassword,
                label = { Text("비밀번호") },
                placeholder = { Text("0000") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditCardScreenPreview() {
    EditCardScreen(
        cardNumber = "1111222233334444",
        expiredDate = "22 / 33",
        ownerName = "이지훈",
        password = "12345678",
        bankType = BankTypeModel.BC,
        snackbarHostState = SnackbarHostState(),
        onSaveClick = {},
        onBackClick = {},
        setCardNumber = {},
        setExpiredDate = {},
        setOwnerName = {},
        setPassword = {},
    )
}