package app

import org.apache.commons.dbcp.BasicDataSource
import org.seasar.doma.jdbc.Config
import org.seasar.doma.jdbc.dialect.Dialect
import org.seasar.doma.jdbc.dialect.MysqlDialect
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource
import org.seasar.doma.jdbc.tx.LocalTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

/**
 *
 * @author nsoushi
 */
@Configuration
@EnableTransactionManagement
open class TestAppConfig {
    fun realDataSource(): DataSource {
        val ds = BasicDataSource()
        ds.driverClassName = "com.mysql.jdbc.Driver"
        ds.url = "jdbc:mysql://localhost:3306/doma_kotlin_test"
        ds.username = "root"
        ds.password = ""
        return ds
    }

    @Bean
    open fun dataSource(): DataSource = TransactionAwareDataSourceProxy(realDataSource())

    @Bean
    open fun transactionManager(): PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource())
    }

    @Bean
    open fun domaConfig(): Config {
        return DomaConfig()
    }

    inner class DomaConfig : Config {

        private val dialect = MysqlDialect()

        private val dataSource = LocalTransactionDataSource(dataSource())

        private val transactionManager = LocalTransactionManager(
                dataSource.getLocalTransaction(jdbcLogger))

        override fun getDataSource(): DataSource = dataSource

        override fun getDialect(): Dialect = MysqlDialect()

        override fun getTransactionManager() = transactionManager
    }
}

