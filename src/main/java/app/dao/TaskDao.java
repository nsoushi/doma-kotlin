package app.dao;

import app.entity.Task;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

/**
 *
 * @author nsoushi
 */
@ConfigAutowireable
@Dao
public interface TaskDao {

    @Insert
    Result<Task> insert(Task task);

    @Select
    Task selectById(Long id);

}
