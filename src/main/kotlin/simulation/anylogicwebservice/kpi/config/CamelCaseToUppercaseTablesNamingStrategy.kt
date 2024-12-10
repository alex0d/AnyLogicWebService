package simulation.anylogicwebservice.kpi.config

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy
import org.hibernate.boot.model.naming.Identifier
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment

class CamelCaseToUppercaseTablesAndColumnsNamingStrategy : CamelCaseToUnderscoresNamingStrategy() {
    override fun toPhysicalTableName(name: Identifier?, context: JdbcEnvironment?): Identifier {
        return super.toPhysicalTableName(name, context).uppercase()
    }

    override fun toPhysicalColumnName(logicalName: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier {
        return super.toPhysicalColumnName(logicalName, jdbcEnvironment).uppercase()
    }

    private fun Identifier.uppercase(): Identifier {
        val adjustedName: String = this.text.uppercase()
        return Identifier(adjustedName, true)
    }
}
