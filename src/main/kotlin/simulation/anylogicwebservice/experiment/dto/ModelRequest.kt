package simulation.anylogicwebservice.experiment.dto

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "ModelRequest")
@XmlAccessorType(value = XmlAccessType.FIELD)
class ModelRequest(
    var scenarioNumber: Int? = null,
    var drillingRate: Int? = null,
    var oilPrice: Double? = null,
    var dollarRate: Double? = null
)