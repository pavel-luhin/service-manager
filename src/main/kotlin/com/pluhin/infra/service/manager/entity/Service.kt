package com.pluhin.infra.service.manager.entity

import javax.persistence.*

@Entity
@Table(name = "services")
data class Service(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val filename: String
)