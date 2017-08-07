package app.entity

import org.seasar.doma.*
import java.time.LocalDate
import java.time.LocalDateTime

/**
 *
 * @author nsoushi
 */
@Entity(immutable = true)
@Table(name = "tasks")
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int? = null,
        @Column(name = "title")
        val title: String,
        @Column(name = "finished_at")
        val finishedAt: LocalDate,
        @Column(name = "created_at")
        val createdAt: LocalDateTime,
        @Column(name = "updated_at")
        val updatedAt: LocalDateTime
)
