package graphqlAPI.api

import jakarta.transaction.Transactional
import org.eclipse.microprofile.graphql.*
import graphqlAPI.model.Project
import graphqlAPI.model.Person
import jakarta.annotation.security.RolesAllowed

@GraphQLApi
class ProjectGraphQLAPI {

    @Query
    @Transactional
    @RolesAllowed("user")
    fun allProjects(): List<Project> = Project.listAll()

    @Mutation
    @Transactional
    @RolesAllowed("user")
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
