package org.http4k.server

import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.testingStopMode
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.io.File

@Disabled("temporarily disabled")
class Jetty11Http2Test {

    @Test
    fun `can configure http2`() {
        val server = { _: Request -> Response(Status.OK) }.asServer(
            Jetty11(
                0,
                testingStopMode,
                http2(
                    0,
                    File("src/test/resources/keystore.jks").absolutePath,
                    "password"
                )
            )
        )
        server.start().stop()
    }
}
