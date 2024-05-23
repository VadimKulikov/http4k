package org.http4k.server

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.client.ApacheClient
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.testingStopMode
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@Disabled("temporarily disabled")
class Jetty11LoomTest :
    ServerContract({ Jetty11Loom(it, testingStopMode) }, ApacheClient()) {
    override fun requestScheme() = equalTo("http")

    @Test
    fun `returns status with pre-defined standardized description`() {
        val response = client(Request(GET, "${baseUrl}/status-with-foobar-description"))

        assertThat(response.status.code, equalTo(201))
        assertThat(response.status.description, equalTo("Created"))
    }
}
