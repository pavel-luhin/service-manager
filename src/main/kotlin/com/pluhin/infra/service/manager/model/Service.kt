package com.pluhin.infra.service.manager.model

data class Service(
    private val pid: Long,
    private val status: ServiceStatus,
    private val uptime: Long,
    private val name: String
)

enum class ServiceStatus {
    UP, DOWN
}