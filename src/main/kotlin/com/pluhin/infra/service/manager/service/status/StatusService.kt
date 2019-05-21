package com.pluhin.infra.service.manager.service.status

import com.pluhin.infra.service.manager.model.Component

interface StatusService {

    fun getStatuses(): List<Component>
}