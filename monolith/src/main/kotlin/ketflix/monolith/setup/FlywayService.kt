package ketflix.monolith.setup

import jakarta.annotation.PostConstruct
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class FlywayService(private val env: Environment) {

    @PostConstruct
    fun migrate() {
        val flyway = org.flywaydb.core.Flyway.configure()
            .dataSource(
                env.getProperty("spring.datasource.url"),
                env.getProperty("spring.datasource.username"),
                env.getProperty("spring.datasource.password")
            )
            .load()
        flyway.migrate()
    }

}