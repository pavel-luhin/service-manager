package com.pluhin.infra.service.manager.service.status

import com.pluhin.infra.service.manager.model.ServiceStatus
import com.pluhin.infra.service.manager.repository.ServiceRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class SimpleStatusService(private val serviceRepository: ServiceRepository): StatusService {

    override fun getStatuses(): List<com.pluhin.infra.service.manager.model.Service> {
        return serviceRepository.findAll()
            .map { com.pluhin.infra.service.manager.model.Service(0, ServiceStatus.DOWN, 0, it.name) }
    }
}