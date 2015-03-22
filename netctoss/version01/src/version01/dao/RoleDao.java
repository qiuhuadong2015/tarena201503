package version01.dao;

import version01.annotation.MyMybatisMapper;
import version01.entity.Module;
import version01.entity.Role;
import version01.page.RolePage;

import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 */
@MyMybatisMapper
public interface RoleDao {

    /**
     * 查询某一页的角色数据
     * @param rolePage
     * @return
     */
    List<Role> findByPage(RolePage rolePage);

    /**
     * 查询行数
     * @return
     */
    int findRows();

    /**
     * 查询全部的模块
     * @return
     */
    List<Module> findAllModules();

    /**
     * 新增角色
     */
    void save(Role role);

    /**
     * 新增角色-模块中间表的数据
     * @param roleModule
     */
    void saveRoleModule(Map<String,Object> roleModule);

    /**
     * 根据ID查询角色
     * @param id
     * @return
     */
    Role findById(int id);

    /**
     * 修改角色
     * @param role
     */
    void update(Role role);

    /**
     * 根据role_id删除中间表数据
     * @param role_id
     */
    void deleteRoleModule(int role_id);

    /**
     * 根据role_id删除角色表数据
     * @param role_id
     */
    void deleteRole(int role_id);
}
