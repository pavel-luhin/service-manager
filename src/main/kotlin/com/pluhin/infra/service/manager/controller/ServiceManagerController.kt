package com.pluhin.infra.service.manager.controller

import com.pluhin.infra.service.manager.model.CreateServiceDTO
import com.pluhin.infra.service.manager.model.Service
import com.pluhin.infra.service.manager.model.ServiceStatus
import com.pluhin.infra.service.manager.service.check.CheckService
import com.pluhin.infra.service.manager.service.manage.ManageService
import com.pluhin.infra.service.manager.service.report.ReportService
import com.pluhin.infra.service.manager.service.start.StartService
import com.pluhin.infra.service.manager.service.status.StatusService
import com.pluhin.infra.service.manager.service.stop.StopService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class ServiceManagerController(
    private val startService: StartService,
    private val stopService: StopService,
    private val checkService: CheckService,
    private val reportService: ReportService,
    private val statusService: StatusService,
    private val manageService: ManageService
) {

    @GetMapping("/all")
    fun getAll(): List<Service> {
        return statusService.getStatuses();
    }

    @PostMapping("/start/{serviceName}")
    fun start(@PathVariable serviceName: String) {
        startService.start(serviceName)
    }

    @PostMapping("/create")
    fun create(@RequestBody dto: CreateServiceDTO): Mono<Service> {
        return manageService.create(dto.name, dto.filename)
            .map { Service(0, ServiceStatus.DOWN, 0, it.name) }
    }
}