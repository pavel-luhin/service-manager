package com.pluhin.infra.service.manager.controller

import com.pluhin.infra.service.manager.model.CreateServiceDTO
import com.pluhin.infra.service.manager.model.Component
import com.pluhin.infra.service.manager.model.ServiceStatus
import com.pluhin.infra.service.manager.service.check.CheckService
import com.pluhin.infra.service.manager.service.manage.ManageService
import com.pluhin.infra.service.manager.service.report.ReportService
import com.pluhin.infra.service.manager.service.start.StartService
import com.pluhin.infra.service.manager.service.status.StatusService
import com.pluhin.infra.service.manager.service.stop.StopService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class ComponentManagerController(
    private val startComponent: StartService,
    private val stopComponent: StopService,
    private val checkService: CheckService,
    private val reportService: ReportService,
    private val statusService: StatusService,
    private val manageService: ManageService
) {

    @GetMapping("/all")
    fun getAll(): List<Component> {
        return statusService.getStatuses();
    }

    @PostMapping("/start/{serviceName}")
    fun start(@PathVariable serviceName: String) {
        startComponent.start(serviceName)
    }

    @PostMapping("/create")
    fun create(@RequestBody dto: CreateServiceDTO): Mono<Component> {
        return manageService.create(dto.name, dto.filename)
            .map { Component(0, ServiceStatus.DOWN, 0, it.name) }
    }
}