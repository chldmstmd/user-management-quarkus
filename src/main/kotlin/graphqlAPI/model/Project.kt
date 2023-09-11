package graphqlAPI.model
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import jakarta.persistence.*

@Entity
@Table(name = "project")
class Project : PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    lateinit var name: String

    @ManyToMany(cascade = [(CascadeType.ALL)])
    @JoinTable(
        name = "project_member",
        joinColumns = [JoinColumn(name = "project_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "person_id", referencedColumnName = "id")]
    )
    var members = mutableSetOf<Person>()

    companion object: PanacheCompanion<Project>
}
