package com.pluhin.infra.service.manager.service.manage

import com.pluhin.infra.service.manager.entity.Service
import reactor.core.publisher.Mono

interface ManageService {

    fun create(name: String, filename: String): Mono<Service>
}