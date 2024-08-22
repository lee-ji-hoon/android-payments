package nextstep.payments

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule

open class BaseComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val resourceTestRule = ResourceTestRule()
}