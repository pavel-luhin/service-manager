package com.pluhin.infra.service.manager.service.status

import com.pluhin.infra.service.manager.model.Component
import com.pluhin.infra.service.manager.model.ServiceStatus
import com.pluhin.infra.service.manager.repository.ComponentRepository
import org.springframework.stereotype.Service

@Service
class SimpleStatusService(private val componentRepository: ComponentRepository): StatusService {

    override fun getStatuses(): List<Component> {
        return componentRepository.findAll()
            .map { Component(0, ServiceStatus.DOWN, 0, it.name) }
    }
}