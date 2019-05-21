package com.pluhin.infra.service.manager.service.manage

import com.pluhin.infra.service.manager.entity.Service
import com.pluhin.infra.service.manager.repository.ServiceRepository
import reactor.core.publisher.Mono

@org.springframework.stereotype.Service
class SimpleManageService(private val repository: ServiceRepository): ManageService {

    override fun create(name: String, filename: String): Mono<Service> {
       return Mono.just(name)
           .map { Service(0, name, filename) }
           .doOnNext { repository.save(it) }
    }
}