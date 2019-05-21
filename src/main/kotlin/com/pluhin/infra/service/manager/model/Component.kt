package com.pluhin.infra.service.manager.model

data class Component(
    val pid: Long,
    val status: ServiceStatus,
    val uptime: Long,
    val name: String
)

enum class ServiceStatus {
    UP, DOWN
}