package br.com.fiap.covida.model

import java.io.Serializable

data class BotModel(
    val id: Int,
    val name: String,
    val welcomeMessage: String,
    val farewellMessage: String,
    val defaultMessage: String,
    val downtimeMinutes: Int? = 0
): Serializable