package version01.page;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 */
public class AdminPage extends Page {
    private Integer moduleId;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}
