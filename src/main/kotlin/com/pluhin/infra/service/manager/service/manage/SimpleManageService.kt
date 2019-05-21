package com.pluhin.infra.service.manager.service.manage

import com.pluhin.infra.service.manager.entity.ComponentEntity
import com.pluhin.infra.service.manager.repository.ComponentRepository
import reactor.core.publisher.Mono

@org.springframework.stereotype.Service
class SimpleManageService(private val repository: ComponentRepository): ManageService {

    override fun create(name: String, filename: String): Mono<ComponentEntity> {
       return Mono.just(name)
           .map { ComponentEntity(0, name, filename) }
           .doOnNext { repository.save(it) }
    }
}