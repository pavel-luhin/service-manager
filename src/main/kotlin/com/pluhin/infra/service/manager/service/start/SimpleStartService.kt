package com.pluhin.infra.service.manager.service.start

import com.pluhin.infra.service.manager.entity.HistoryEntity
import com.pluhin.infra.service.manager.repository.HistoryRepository
import com.pluhin.infra.service.manager.repository.ComponentRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime


@Service
class SimpleStartService(
    private val historyRepository: HistoryRepository,
    private val componentRepository: ComponentRepository
) : StartService {

    override fun start(serviceName: String) {
        Mono.just(serviceName)
            .map { componentRepository.findByName(serviceName) }
            .map { HistoryEntity(0, it, LocalDateTime.now(), null) }
            .doOnNext { historyRepository.save(it) }
    }
}