package com.pluhin.infra.service.manager.controller

import com.pluhin.infra.service.manager.model.Service
import com.pluhin.infra.service.manager.service.check.CheckService
import com.pluhin.infra.service.manager.service.report.ReportService
import com.pluhin.infra.service.manager.service.start.StartService
import com.pluhin.infra.service.manager.service.status.StatusService
import com.pluhin.infra.service.manager.service.stop.StopService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ServiceManagerController(
    private val startService: StartService,
    private val stopService: StopService,
    private val checkService: CheckService,
    private val reportService: ReportService,
    private val statusService: StatusService
) {

    @GetMapping("/all")
    fun getAll(): Flux<Service> {
        return statusService.getStatuses();
    }
}