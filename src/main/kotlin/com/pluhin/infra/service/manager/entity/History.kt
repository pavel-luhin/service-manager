package com.pluhin.infra.service.manager.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class History(
    @Id
    @GeneratedValue
    val id: Long,
    @OneToOne
    val service: Service,
    val createdAt: LocalDateTime,
    val destroyedAt: LocalDateTime?
)