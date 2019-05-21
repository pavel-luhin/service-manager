package com.pluhin.infra.service.manager.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class HistoryEntity(
    @Id
    @GeneratedValue
    val id: Long,
    @OneToOne
    val component: ComponentEntity,
    val createdAt: LocalDateTime,
    val destroyedAt: LocalDateTime?
)