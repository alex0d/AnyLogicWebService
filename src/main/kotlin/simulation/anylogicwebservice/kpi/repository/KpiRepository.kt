package simulation.anylogicwebservice.kpi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import simulation.anylogicwebservice.kpi.model.KpiData

@Repository
interface KpiRepository : JpaRepository<KpiData, Int> {
    fun findByScenarioNumberOrderBySimYear(scenarioNumber: Int): List<KpiData>
}