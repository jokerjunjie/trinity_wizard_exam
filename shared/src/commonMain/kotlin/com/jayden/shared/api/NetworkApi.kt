package com.jayden.shared.api

import com.jayden.shared.model.MemberModel
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class NetworkApi(){
    companion object {
        private const val URL = "https://api.github.com/orgs/jetbrains/members"
    }

    private val httpApiClient: HttpClient = HttpClient {
        install(DefaultRequest){
            //custom header
            headers.append("Accept","application/xml;q=0.9")
        }
        install(HttpTimeout) {
            // Timeout
            requestTimeoutMillis = 60000
            connectTimeoutMillis = 60000
        }
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getMembers(): List<MemberModel> {
        return httpApiClient.get(URL)
    }
}

