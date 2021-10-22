package br.com.topadvice.onboarding.api

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

data class UserRequestDTO(
    @NotNull var name: String,
    @NotNull var age: Int,
    @NotNull var monthlyIncome: BigDecimal,
    @NotNull var monthlyExpenses: BigDecimal,
    @NotNull var contribution: BigDecimal
)

data class UserResponseDTO(
    @NotNull var userData: UserRequestDTO,
    @NotEmpty var xAxisLabels: List<Int>,
    @NotEmpty var yAxisLabels: List<BigDecimal>,
    @NotEmpty var coordinates: List<CoordinateDTO>,
)

data class CoordinateDTO(@NotNull var x: Int, @NotNull var y: Int, @NotNull var label: String)

@Validated
@Controller("/onboarding-user")
open class OnboardingAPI {

    @Post(produces = [MediaType.APPLICATION_JSON])
    fun calculate(@Body @Valid userRequestDTO: UserRequestDTO): HttpResponse<UserResponseDTO> =
        HttpResponse.ok(mock(userRequestDTO))


    companion object {
        fun mock(userRequestDTO: UserRequestDTO): UserResponseDTO =
            UserResponseDTO(
                userData = userRequestDTO,
                xAxisLabels = listOf(20),
                yAxisLabels = listOf(BigDecimal.TEN),
                coordinates = listOf(
                    CoordinateDTO(0, 0, "Mock")
                )
            )
    }


}