package org.acme.api

import org.eclipse.microprofile.graphql.*
import org.acme.model.Person
import jakarta.transaction.Transactional
@GraphQLApi
class PersonGraphQLAPI {

    @Query
    @Transactional
    fun allPersons(): List<Person> = Person.listAll()

    @Mutation
    @Transactional
    fun addPeople(name: String): Person {
        val person = Person()
        person.name = name
        person.persist()
        return person
    }
}
