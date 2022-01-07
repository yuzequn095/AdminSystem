package com.spring.admin.controller;

import com.spring.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/*
 * Controller to handle table related request
 * Jump to specified table pages
 */
@Controller
public class TableController {

    @GetMapping("/basic_table.html")
    public String basicTableHandler(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamicTableHandler(){

        // Iterator Table Content
/*
        List<User> users = Arrays.asList(new User("Jason", "123456"),
                      new User("John", "123456"),
                      new User("Kevin", "1234567"));

        model.addAttribute("users", users);
*/

        return "table/dynamic_table";

    }

    @GetMapping("/responsive_table.html")
    public String responsiveTableHandler(){

        return "table/responsive_table";

    }

    @GetMapping("/editable_table.html")
    public String editableTableHandler(){

        return "table/editable_table";

    }
}
