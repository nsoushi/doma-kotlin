package app.dao

import app.TestAppConfig
import org.junit.runner.RunWith
import org.seasar.doma.jdbc.Config
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import javax.sql.DataSource

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = arrayOf(TestAppConfig::class))
abstract class AbstractDaoTest {
    @Autowired
    lateinit var domaConfig: Config
    @Autowired
    lateinit var dataSource: DataSource
}
