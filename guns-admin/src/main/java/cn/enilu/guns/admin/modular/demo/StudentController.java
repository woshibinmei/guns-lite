package cn.enilu.guns.admin.modular.demo;

import cn.enilu.guns.admin.core.base.controller.BaseController;
import cn.enilu.guns.bean.annotion.core.Permission;
import cn.enilu.guns.bean.constant.Const;
import cn.enilu.guns.bean.entity.demo.Student;
import cn.enilu.guns.service.demo.StudentService;
import cn.enilu.guns.utils.BeanUtil;
import cn.enilu.guns.warpper.DictWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019-11-20.
 */
@Controller
@RequestMapping("/demo/student")
public class StudentController extends BaseController {

    private String PREFIX = "/demo/student/";

    @Autowired
    private StudentService service;

    @RequestMapping("")
    public String index() {
        return PREFIX + "student.html";
    }

    @GetMapping("/getStudent")
    @ResponseBody
    public List<Student> getStudent(){
        return service.queryAll();
    }

    /**
     * 获取所有字典列表
     */
    @RequestMapping(value = "/list")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object list(String condition) {
        List<Student> list = service.queryAll();
        return super.warpObject(new DictWarpper(BeanUtil.objectsToMaps(list)));
    }

}
