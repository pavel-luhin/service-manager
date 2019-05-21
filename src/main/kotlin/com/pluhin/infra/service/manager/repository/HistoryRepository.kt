package com.pluhin.infra.service.manager.repository

import com.pluhin.infra.service.manager.entity.HistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface HistoryRepository: JpaRepository<HistoryEntity, Long>