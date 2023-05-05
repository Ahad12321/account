package com.lesson.account.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class CreateAccountRequest (
    @field:NotBlank
    val customerId:String,
    @field:Min(0, message = "This must be positive number")
    val initialCredit: BigDecimal
)