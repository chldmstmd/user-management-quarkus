package org.acme.model
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import jakarta.persistence.*
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion


@Entity
@Table(name="person")
class Person: PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


    lateinit var name:String

    @ManyToMany(mappedBy = "members")
    var projects = mutableSetOf<Project>()

    companion object: PanacheCompanion<Person>
}




//@Entity
//class Person: PanacheEntityBase {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long? = null
//    var name: String? = null
//
//    companion object : PanacheCompanion<Person> {
//        fun findByName(name:String) = find("name",name).firstResult()
//
//    }
//}