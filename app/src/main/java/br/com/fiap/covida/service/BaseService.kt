package br.com.fiap.covida.service

import com.google.gson.Gson

open class BaseService {
    val baseUrl: String = "http://10.0.2.2:8080/covida/api/"
    val gson = Gson()
}