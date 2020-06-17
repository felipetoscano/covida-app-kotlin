package br.com.fiap.covida.service

import android.util.Log
import br.com.fiap.covida.model.chat.bot.ChatBotOptionModel
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class OptionService : BaseService(){

    fun getOptionsByIdAsync(idSegment: Int): List<ChatBotOptionModel> {
        val url = URL(baseUrl + "options/" + idSegment)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"

        val optionType = object : TypeToken<List<ChatBotOptionModel>>() {}.type
        val json = connection.inputStream.bufferedReader().readText()
        return gson.fromJson(json, optionType)
    }

    private fun getOptionsById1(): String {
        return "[{\"idOption\":1,\"nameOption\":\"Tenho tido pensamentos destrutivos :(\",\"message\":\"Sinto muito por isso. Mas queria te indicar o CVV, tenho certeza de que eles podem te ajudar! (cvv.org.br)\",\"idSegment\":1},{\"idOption\":2,\"nameOption\":\"Estou isolada(o) com meu agressor.\",\"message\":\"Tenho certeza de que esse não é um momento fácil, mas sei que você irá superar! Ligue 180(ou 190 se for uma emergência) e registre sua denúncia\",\"idSegment\":1}]"
    }
}