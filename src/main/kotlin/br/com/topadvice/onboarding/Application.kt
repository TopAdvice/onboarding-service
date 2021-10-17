package br.com.topadvice.onboarding

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.topadvice.onboarding")
		.start()
}

