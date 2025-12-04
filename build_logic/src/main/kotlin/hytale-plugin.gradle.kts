
import org.jetbrains.gradle.ext.runConfigurations
import org.jetbrains.gradle.ext.settings
import org.jetbrains.gradle.ext.taskTriggers

plugins {
    application
    `java-library`
    id("org.jetbrains.gradle.plugin.idea-ext")
}

val hytaleExtension = extensions.create(HytaleExtension.EXTENSION_NAME, HytaleExtension::class)
project.apply { plugin("org.jetbrains.gradle.plugin.idea-ext") }

project.afterEvaluate {
    val ideaModel = extensions.ideaExt

    dependencies {
        // TODO should we make this configurable?
        implementation(files("${hytaleExtension.serverDir.get()}/HytaleServer.jar"))
    }

    mkdir(hytaleExtension.runDir)

    // TODO make server properties configurable
    val programArgs = listOf(
        "--allow-op",
        "--assets=${hytaleExtension.assetsDir.get()}",
        "--packs=${hytaleExtension.packsDir.get()}"
    )

    val aotFile = project.file("${hytaleExtension.serverDir.get()}/HytaleServer.aot")
    val aotArg = if (aotFile.exists()) "-XX:AOTCache=${aotFile.absolutePath}" else ""

    val javaArgs = listOf(aotArg)

    ideaModel.project.settings {
        runConfigurations {
            create<org.jetbrains.gradle.ext.Application>("HytaleServer") {
                mainClass = "com.hypixel.hytale.Main"
                moduleName = "${ideaModel.project.name}.main"
                programParameters = programArgs.joinToString(" ")
                jvmArgs = javaArgs.joinToString(" ")
                workingDirectory = hytaleExtension.runDir.get()

                beforeRun {
                    mkdir(hytaleExtension.runDir)
                }
            }
        }

        taskTriggers {
            hytaleExtension.syncTask.orNull?.let { afterSync(it) }
        }
    }

    tasks.register<JavaExec>("runServer") {
        mainClass = "com.hypixel.hytale.Main"
        modularity.inferModulePath = true
        classpath = sourceSets.main.get().runtimeClasspath
        args = programArgs
        jvmArgs = javaArgs
        workingDir(hytaleExtension.runDir)
    }
}
