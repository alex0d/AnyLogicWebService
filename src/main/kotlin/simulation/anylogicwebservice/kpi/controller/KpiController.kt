package simulation.anylogicwebservice.kpi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import simulation.anylogicwebservice.kpi.dto.ProfitPoint
import simulation.anylogicwebservice.kpi.repository.KpiRepository

@CrossOrigin
@RestController
@RequestMapping("/api/kpi")
class KpiController(
    private val kpiRepository: KpiRepository,
) {

    @GetMapping("/{scenarioNumber}")
    fun getScenarioProfits(@PathVariable scenarioNumber: Int): ResponseEntity<List<ProfitPoint>> {
        val profitData = kpiRepository
            .findByScenarioNumberOrderBySimYear(scenarioNumber)
            .map { ProfitPoint(it.simYear, it.profit) }
        return ResponseEntity.ok(profitData)
    }
}