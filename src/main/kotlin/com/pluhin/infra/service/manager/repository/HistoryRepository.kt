package com.pluhin.infra.service.manager.repository

import com.pluhin.infra.service.manager.entity.History
import org.springframework.data.jpa.repository.JpaRepository

interface HistoryRepository: JpaRepository<History, Long>