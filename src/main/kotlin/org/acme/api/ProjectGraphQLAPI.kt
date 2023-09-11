package org.acme.api

import jakarta.transaction.Transactional
import org.eclipse.microprofile.graphql.*
import org.acme.model.Project
import org.acme.model.Person


@GraphQLApi
class ProjectGraphQLAPI {

    @Query
    @Transactional
    fun allProjects(): List<Project> = Project.listAll()

    @Mutation
    @Transactional
    fun addProject(name: String, memberIds: List<Long>): Project {
        val project = Project()
        project.name = name
        memberIds.forEach { id ->
            val person = Person.findById(id)
            if (person != null) {
            project.members.add(person)}
            else { println("Warning: Person with ID $id not found.") }
        }
        project.persist()
        return project
        }}
