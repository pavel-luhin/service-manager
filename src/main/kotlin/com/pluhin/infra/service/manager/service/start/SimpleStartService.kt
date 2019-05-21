package com.pluhin.infra.service.manager.service.start

import com.pluhin.infra.service.manager.entity.History
import com.pluhin.infra.service.manager.repository.HistoryRepository
import com.pluhin.infra.service.manager.repository.ServiceRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime


@Service
class SimpleStartService(
    private val historyRepository: HistoryRepository,
    private val serviceRepository: ServiceRepository
) : StartService {

    override fun start(serviceName: String) {
        Mono.just(serviceName)
            .map { serviceRepository.findByName(serviceName) }
            .map { History(0, it, LocalDateTime.now(), null) }
            .doOnNext { historyRepository.save(it) }
    }
}