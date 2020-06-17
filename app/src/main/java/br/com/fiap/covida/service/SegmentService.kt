package br.com.fiap.covida.service

import br.com.fiap.covida.model.chat.bot.ChatBotSegmentModel
import com.google.gson.reflect.TypeToken
import java.net.HttpURLConnection
import java.net.URL

class SegmentService: BaseService() {

    fun getSegmentsByIdAsync(idBot: Int): List<ChatBotSegmentModel> {
        val url = URL(baseUrl + "segments/" + idBot)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"

        val segmentType = object : TypeToken<List<ChatBotSegmentModel>>() {}.type
        val json = connection.inputStream.bufferedReader().readText()
        return gson.fromJson(json, segmentType)
    }

    private fun getSegmentsById1(): String{
        return "[{\"id\":1,\"name\":\"Preciso de ajuda :(\",\"idBot\":1},{\"id\":2,\"name\":\"Me indica um passatempo?\",\"idBot\":1}]"
    }
}