package simulation.anylogicwebservice.kpi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "KPI")
class KpiData(
    @Column(name = "SIM_YEAR")
    var simYear: Int,

    @Column(name = "SCENARIO_NUMBER")
    var scenarioNumber: Int,

    @Column(name = "PROFIT")
    var profit: Double,

    @Id @Column(name = "ID")
    var id: Int? = null,
)