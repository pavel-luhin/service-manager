package com.pluhin.infra.service.manager.repository

import com.pluhin.infra.service.manager.entity.ComponentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ComponentRepository: JpaRepository<ComponentEntity, Long> {

    fun findByName(name: String): ComponentEntity
}