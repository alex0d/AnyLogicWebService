package simulation.anylogicwebservice.experiment.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import simulation.anylogicwebservice.experiment.dto.ModelRequest
import simulation.anylogicwebservice.experiment.dto.ModelResponse
import simulation.anylogicwebservice.experiment.model.OilProductionModel

@CrossOrigin
@RestController
class ModelController {

    @PostMapping(consumes = [MediaType.APPLICATION_XML_VALUE], produces = [MediaType.APPLICATION_XML_VALUE])
    fun runModel(@RequestBody modelRequest: ModelRequest): ModelResponse {
        return try {
            OilProductionModel.start(modelRequest)
            ModelResponse.SuccessResponse("Model has been run successfully")
        } catch (e: Exception) {
            ModelResponse.ErrorResponse(e.message)
        }
    }
}
