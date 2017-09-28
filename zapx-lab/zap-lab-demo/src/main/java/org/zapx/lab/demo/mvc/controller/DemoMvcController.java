package org.zapx.lab.demo.mvc.controller;

import com.didispace.swagger.EnableSwagger2Doc;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.zapx.lab.demo.mvc.model.entity.User;
import org.zapx.lab.demo.mvc.model.message.ResponseMessage;

import static org.zapx.lab.demo.mvc.model.message.ResponseMessage.ok;

/**
 * Created by Shin on 2017/9/28.
 */
@EnableSwagger2Doc
@SpringBootApplication
@RestController
@RequestMapping("demo/mvc")
@ApiResponses({
        @ApiResponse(code = 201, message = "创建成功,返回创建数据的ID"),
        @ApiResponse(code = 401, message = "未授权"),
        @ApiResponse(code = 403, message = "无权限")
})
public class DemoMvcController {

    public static void main(String[] args) {
        SpringApplication.run(DemoMvcController.class);
    }

    @ApiOperation(value = "获取用户信息")

    @GetMapping("/getUser")
    @ResponseBody
    public ResponseMessage<User> getUser() {
        return ok(new User("1", "Tom", 10));
    }

    @ApiOperation(value = "提交用户信息")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PutMapping("/putUser")
    @ResponseBody
    public ResponseMessage<User> putUser(@RequestBody User user) {
        return ok(user);
    }
}
