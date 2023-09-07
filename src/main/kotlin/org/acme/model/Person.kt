package org.acme.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase


@Entity
class Person: PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null

    companion object : PanacheCompanion<Person> {
        fun findByName(name:String) = find("name",name).firstResult()

    }
}