package simulation.anylogicwebservice.experiment.dto

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlRootElement

@XmlAccessorType(value = XmlAccessType.FIELD)
sealed interface ModelResponse {

    @XmlRootElement(name = "SuccessResponse")
    class SuccessResponse(var message: String? = null) : ModelResponse

    @XmlRootElement(name = "ErrorResponse")
    class ErrorResponse(var message: String? = null) : ModelResponse
}
