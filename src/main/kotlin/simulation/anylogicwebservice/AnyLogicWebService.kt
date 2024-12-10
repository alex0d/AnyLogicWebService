package simulation.anylogicwebservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnyLogicWebService

fun main(args: Array<String>) {
    runApplication<AnyLogicWebService>(*args)
}
