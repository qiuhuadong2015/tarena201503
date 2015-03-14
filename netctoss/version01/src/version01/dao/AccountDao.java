package version01.dao;

import version01.annotation.MyMybatisMapper;
import version01.entity.Account;
import version01.vo.AccountPage;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/13.
 */
@MyMybatisMapper
public interface AccountDao {
    /**
     * 分页查询账务账号
     * @param accountPage 分页及搜索条件
     * @return
     */
    List<Account> findByPage(AccountPage accountPage);

    /**
     * 查询总行数
     * @param accountPage 分页及搜索条件
     * @return
     */
    int findRows(AccountPage accountPage);

    /**
     * 暂停账务账号，将状态改为1，暂停时间改为系统时间
     * @param id
     */
    void pause(int id);

    /**
     * 参考暂停，自己完成开通功能，将状态改为0，开通时间为系统时间，删除暂停时间
     * @param id
     */
    void start(int id);

    /**
     * 参考暂停，自己完成删除功能，将状态改为2，删除时间改为系统时间
     * @param id
     */
    void delete(int id);

    //以下是Unit02的账务账号模块的修改功能

    /**
     * 根据id查询一条账务账号（这里和资费模块类似）
     * @param id
     * @return
     */
    Account findById(int id);

    /**
     * 修改一条账务账号
     * @param account
     */
    void update(Account account);


}
