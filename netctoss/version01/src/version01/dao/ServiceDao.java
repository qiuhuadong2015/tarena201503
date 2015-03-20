package version01.dao;

import version01.annotation.MyMybatisMapper;
import version01.entity.Service;
import version01.page.ServicePage;

import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/14.
 */
@MyMybatisMapper
public interface ServiceDao {

    /**
     * 1）Map代替了实体类
     * 2）每一个模块都有自己的分页组件
     *
     * 查询某一页的Service数据
     * @param servicePage
     * @return
     */
    List<Map<String,Object>> findByPage(ServicePage servicePage);

    /**
     * 查询满足搜索条件的总行数
     * @param servicePage
     * @return
     */
    int findRows(ServicePage servicePage);

    /**
     * 暂停，将状态从0改为1
     * @param id
     */
    void pause(int id);

    /**
     * 开通，将状态从0改为1
     * @param id
     */
    void start(int id);

    /**
     * 删除，将状态改为2
     * @param id
     */
    void delete(int id);

    Service findById(int id);

    void update(Service service);
}
