package ted.gun0912.movie.remote.api.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class NetworkLoggingInterceptor : Interceptor {
    private val tag = "NetworkLog"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // 요청 로깅
        Log.d(tag, "Request: ${request.method} ${request.url}")
        request.headers.forEach { Log.d(tag, "Header: ${it.first}: ${it.second}") }

        try {
            // 요청 시작 시간
            val startTime = System.currentTimeMillis()

            // 요청 실행
            val response = chain.proceed(request)

            // 요청 소요 시간
            val duration = System.currentTimeMillis() - startTime

            // 응답 로깅
            val responseCode = response.code
            val isSuccessful = response.isSuccessful
            Log.d(
                tag,
                "Response: $responseCode (${if (isSuccessful) "Success" else "Failure"}) in ${duration}ms for ${request.url}"
            )

            return response
        } catch (e: Exception) {
            // 네트워크 예외 로깅
            Log.e(tag, "Network Failure for ${request.url}", e)
            Log.e(tag, "Error message: ${e.message}")
            Log.e(tag, "Error type: ${e.javaClass.simpleName}")

            // 예외 다시 던지기
            throw e
        }
    }
}
