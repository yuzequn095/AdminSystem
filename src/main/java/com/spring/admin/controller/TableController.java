package com.spring.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Controller to handle table related request
 * Jump to specified table pages
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basicTableHandler(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamicTableHandler(){

        return "table/dynamic_table";

    }

    @GetMapping("/responsive_table")
    public String responsiveTableHandler(){

        return "table/responsive_table";

    }

    @GetMapping("/editable_table")
    public String editableTableHandler(){

        return "table/editable_table";

    }
}
