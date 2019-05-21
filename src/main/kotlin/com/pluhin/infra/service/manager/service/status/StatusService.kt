package com.pluhin.infra.service.manager.service.status

import com.pluhin.infra.service.manager.model.Service
import reactor.core.publisher.Flux

interface StatusService {

    fun getStatuses(): List<Service>
}