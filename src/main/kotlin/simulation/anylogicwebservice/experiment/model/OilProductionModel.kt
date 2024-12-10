package simulation.anylogicwebservice.experiment.model

import pr11.CustomExperiment
import pr11.Main
import simulation.anylogicwebservice.experiment.dto.ModelRequest
import java.util.*

object OilProductionModel {

    fun start(request: ModelRequest) {
        val random = Random(System.currentTimeMillis())

        val experiment = CustomExperiment(null)
        val engine = experiment.createEngine().apply {
            defaultRandomGenerator = random
        }

        val main = Main(engine, null, null).apply {
            setParametersToDefaultValues()
            defaultRandomGenerator = random
        }
        engine.start(main)

        val startDate = Date()
        val calendar = Calendar.getInstance().apply {
            time = startDate
            add(Calendar.YEAR, 30)
        }
        val stopDate = calendar.time

        engine.apply {
            this.startDate = startDate
            this.stopDate = stopDate
            realTimeMode = false
        }

        main.apply {
            Сценарий = request.scenarioNumber!!
            Темп_бурения = request.drillingRate!!
            Цена_на_нефть = request.oilPrice!!
            Курс_доллара = request.dollarRate!!
        }

        while (engine.time < 30) {
            engine.step()
        }
        engine.stop()
    }
}