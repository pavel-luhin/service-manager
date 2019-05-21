package com.pluhin.infra.service.manager.repository

import com.pluhin.infra.service.manager.entity.Service
import org.springframework.data.jpa.repository.JpaRepository
import reactor.core.publisher.Mono

interface ServiceRepository: JpaRepository<Service, Long> {

    fun findByName(name: String): Service
}