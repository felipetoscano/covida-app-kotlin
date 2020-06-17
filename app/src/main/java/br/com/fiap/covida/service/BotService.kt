package br.com.fiap.covida.service

import br.com.fiap.covida.model.BotModel
import com.google.gson.reflect.TypeToken
import java.net.HttpURLConnection
import java.net.URL

class BotService : BaseService(){

    fun findAllAsync() : List<BotModel>{
        val url = URL(baseUrl + "bots")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"

        val botType = object : TypeToken<List<BotModel>>() {}.type
        val json = connection.inputStream.bufferedReader().readText()
        return gson.fromJson(json, botType)
    }

    private fun findAll() : String{
        return "[{\"id\":1,\"name\":\"Becky\",\"welcomeMessage\":\"Olá! Eu sou a Becky, sua nova companhia. Estou aqui pra te ajudar sempre que precisar. Por onde quer começar?\",\"farewellMessage\":\"Poxa, que pena que você já vai. Mas sempre que precisar, estarei aqui! Tchau :)\",\"defaultMessage\":\"Opa, não entendi. Você pode falar de novo?\",\"downtimeMinutes\":0}]"
    }
}