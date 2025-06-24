plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

tasks {
    register("startBothContinuous") {
        group = "build"
        description = "Starts both the site and server in continuous mode"
        doLast {
            val javaHome = System.getProperty("java.home")
            val javaPath = "$javaHome/bin/java"
            val gradleJar = File(rootDir, "gradle/wrapper/gradle-wrapper.jar")

            val kobwebProcess =
                ProcessBuilder()
                    .command(javaPath, "-jar", gradleJar.absolutePath, ":site:kobwebStart", "--continuous")
                    .directory(rootDir)
                    .start()

            val serverProcess =
                ProcessBuilder()
                    .command(javaPath, "-jar", gradleJar.absolutePath, ":server:runServer", "--continuous")
                    .directory(rootDir)
                    .start()

            // Redirect kobweb output through Gradle's logger
            Thread {
                kobwebProcess.inputStream.bufferedReader().use { reader ->
                    reader.lines().forEach { line ->
                        logger.lifecycle("[KOBWEB] $line")
                    }
                }
            }.start()

            Thread {
                kobwebProcess.errorStream.bufferedReader().use { reader ->
                    reader.lines().forEach { line ->
                        logger.error("[KOBWEB-ERROR] $line")
                    }
                }
            }.start()

            // Redirect server output through Gradle's logger
            Thread {
                serverProcess.inputStream.bufferedReader().use { reader ->
                    reader.lines().forEach { line ->
                        logger.lifecycle("[SERVER] $line")
                    }
                }
            }.start()

            Thread {
                serverProcess.errorStream.bufferedReader().use { reader ->
                    reader.lines().forEach { line ->
                        logger.error("[SERVER-ERROR] $line")
                    }
                }
            }.start()

            // Add shutdown hook for cleanup
            Runtime.getRuntime().addShutdownHook(
                Thread {
                    logger.lifecycle("Shutting down processes...")
                    kobwebProcess.destroyForcibly()
                    serverProcess.destroyForcibly()
                },
            )

            logger.lifecycle("Both processes started. Press Ctrl+C to stop both.")

            try {
                // Wait for either process to finish
                kobwebProcess.waitFor()
                serverProcess.waitFor()
            } catch (_: InterruptedException) {
                logger.lifecycle("Interrupted, stopping processes...")
                kobwebProcess.destroyForcibly()
                serverProcess.destroyForcibly()
            }
        }
    }
}
