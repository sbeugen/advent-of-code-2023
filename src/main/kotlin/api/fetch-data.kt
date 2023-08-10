package api

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun fetchData(day: Int): String {
    val sessionToken = System.getenv("SESSION_TOKEN")
        ?: throw Exception("Please provide session token via evn variable SESSION_TOKEN.")

    val client = HttpClient.newHttpClient();
    val request =
        HttpRequest.newBuilder(URI.create("https://adventofcode.com/2022/day/$day/input"))
            .header("Cookie", "session=$sessionToken")
            .GET().build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

    return response.body()
}