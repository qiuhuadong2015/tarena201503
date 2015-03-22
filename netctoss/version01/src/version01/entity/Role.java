package version01.entity;

import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/20.
 */
public class Role {

    //追加属性，用于封装一组模块ID，持久化时使用
    private List<Integer> module_ids;

    public List<Integer> getModule_ids() {
        return module_ids;
    }

    public void setModule_ids(List<Integer> module_ids) {
        this.module_ids = module_ids;
    }

    //追加关联属性，封装相关的模块数据，查询时使用
    private List<Module> modules;

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    private Integer role_id;
    private String name;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
