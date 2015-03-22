package version01.dao;

import version01.annotation.MyMybatisMapper;
import version01.entity.Admin;
import version01.entity.Module;
import version01.page.AdminPage;

import java.util.List;
import java.util.Map;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 */
@MyMybatisMapper
public interface AdminDao {

    /**
     * 查询某一页的管理员数据
     * @param adminPage
     * @return
     */
    List<Admin> findByPage(AdminPage adminPage);

    /**
     * 查询总行数
     * @param adminPage
     * @return
     */
    int findRows(AdminPage adminPage);

    /**
     * 更新密码
     * @param param
     * KEY          VALUE
     * ids          List<Integer>
     * password
     */
    void updatePassword(Map<String,Object> param);

    /**
     * 根据账号查询管理员
     * @param adminCode 账号
     * @return
     */
    Admin findByCode(String adminCode);

    /**
     * 根据管理员ID查询其可以访问的模块
     * @param adminId
     * @return
     */
    List<Module> findModulesByAdminId(Integer adminId);
}
