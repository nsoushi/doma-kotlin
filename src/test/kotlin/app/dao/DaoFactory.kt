package app.dao

import org.seasar.doma.jdbc.Config
import kotlin.reflect.KClass

/**
 * @author nsoushi
 */
class DaoFactory {
    @Suppress("UNCHECKED_CAST")
    fun <T> create(config: Config, daoInterface: KClass<T>): T where T : Any {
        val implClassName = daoInterface.qualifiedName + "Impl"
        try {
            val implClass = Class.forName(implClassName)
            return implClass.getConstructor(Config::class.java).newInstance(config) as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
