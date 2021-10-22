package br.com.topadvice.onboarding

import io.micronaut.runtime.Micronaut.build
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info


@OpenAPIDefinition(
	info = Info(
		title = "Topadvice - Onboarding API",
		version = "1.0",
		contact = Contact(url = "https://topadvice.com.br", email = "contato@topadvice.com.br")
	)
)
object Application {
	@JvmStatic
	fun main(args: Array<String>) {
		build()
			.args(*args)
			.packages("br.com.topadvice.onboarding")
			.start()
	}
}
