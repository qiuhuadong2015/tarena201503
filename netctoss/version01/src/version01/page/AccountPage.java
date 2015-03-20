package version01.page;

/**
 * Created by qiuhuadong2014 on 2015/3/13.
 * Unit02
 * 账务账号的分页组件
 */
public class AccountPage extends Page{
    //搜索条件
    private String idcard_no;//身份证
    private String real_name;//姓名
    private String login_name;//登录名
    private String status;//状态



    public String getIdcard_no() {
        return idcard_no;
    }

    public void setIdcard_no(String idcard_no) {
        this.idcard_no = idcard_no;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
