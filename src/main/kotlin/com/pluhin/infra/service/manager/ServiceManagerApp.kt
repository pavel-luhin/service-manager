package com.pluhin.infra.service.manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServiceManagerApp

fun main(args: Array<String>) {
    runApplication<ServiceManagerApp>(*args)
}