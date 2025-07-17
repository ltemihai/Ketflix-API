import jakarta.persistence.*

@Entity
@Table(name = "genres")
data class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false, unique = true)
    val name: String,

    @ManyToMany(mappedBy = "genres")
    val users: Set<User> = emptySet()
)