package version01.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import version01.dao.AccountDao;
import version01.entity.Account;
import version01.vo.AccountPage;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/14.
 */
@Controller
@RequestMapping("/account")
@SessionAttributes("accountPage")
public class AccountController extends BaseController{

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Resource
    private AccountDao accountDao;

    @RequestMapping("/findAccount.form")
    public String find(AccountPage accountPage,Model model){
        //查询出当前页的数据
        List<Account> list=accountDao.findByPage(accountPage);
        model.addAttribute("accounts",list);

        //查询出总行数，从而计算出总页数
        accountPage.setRows(accountDao.findRows(accountPage));
        model.addAttribute("accountPage",accountPage);
        return "account/account_list";
    }

    @RequestMapping("/pauseAccount.form")
    public String updatePause(@RequestParam("id") int id){
        //暂停账务账号
        accountDao.pause(id);

        //TODO 暂停下属业务账号

        return "redirect:findAccount.form";
    }

    //自己根据暂停，参考完成开通
    @RequestMapping("startAccount.form")
    public String updateStart(@RequestParam("id") int id){
        //开通账务账号
        accountDao.start(id);

        return "redirect:findAccount.form";
    }

    //参考暂停完成删除
    @RequestMapping("deleteAccount.form")
    public String updateDelete(@RequestParam("id") int id){
        //删除账务账号
        accountDao.delete(id);

        //TODO 删除下属业务账号

        return "redirect:findAccount.form";
    }

    //以下是修改功能

    @RequestMapping("/toUpdateAccount.form")
    public String toUpdate(@RequestParam("id")int id,Model model){
        Account account=accountDao.findById(id);
        model.addAttribute("account", account);
        return "account/update_account";
    }

//    测试数据SQL：
//    update account set gender='0',email='zsf@qq.com',occupation='1',
//            mailaddress='武当山',zipcode='123456',qq='123456'
//    where account_id=1005;

    @RequestMapping("/updateAccount.form")
    public String update(Account account){
        accountDao.update(account);
        return "redirect:findAccount.form";
    }
}
