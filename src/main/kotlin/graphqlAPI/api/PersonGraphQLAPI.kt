package graphqlAPI.api
import org.eclipse.microprofile.graphql.*
import graphqlAPI.model.Person
import jakarta.transaction.Transactional
import jakarta.annotation.security.RolesAllowed
@GraphQLApi
class PersonGraphQLAPI {

    @Query
    @Transactional
    @RolesAllowed("user")
    fun allPeople(): List<Person> = Person.listAll()

    @Mutation
    @Transactional
    @RolesAllowed("user")
    fun addPerson(name: String): Person {
        val person = Person()
        person.name = name
        person.persist()
        return person
    }
}
