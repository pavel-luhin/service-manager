package com.pluhin.infra.service.manager.service.status

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class SimpleStatusService: StatusService {

    override fun getStatuses(): Flux<com.pluhin.infra.service.manager.model.Service> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}