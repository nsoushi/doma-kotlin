package app.dao

import app.entity.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime

/**
 *
 * @author nsoushi
 */
class TaskDaoTest: AbstractDaoTest() {

    private lateinit var target: TaskDao


    @Before
    fun before() {
        target = DaoFactory().create(domaConfig, TaskDao::class)
    }

    @Test
    fun insert() {
        val now = LocalDateTime.now()
        val finishedAt = LocalDate.of(2017, 8, 1)

        domaConfig.getTransactionManager().required {
            val data = Task( null, "title",finishedAt,now,now)

            val inserted = target.insert(data)
            assertThat(inserted.count, `is`(1))

            val actual = target.selectById(inserted.entity.id?.toLong())

            assertThat(actual.id, `is`(inserted.entity.id))

            // finishedAt = '2017/8/1'でinsertしたがDBの値はfinishedAt = '2017/7/31'である
            assertThat(actual.finishedAt, `is`(LocalDate.of(2017, 7, 31)))
        }
    }
}
