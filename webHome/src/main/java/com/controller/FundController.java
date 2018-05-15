package com.controller;

import com.domain.model.FundModel;
import com.service.FundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wb-xxb255887
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/15 9:38 wb-xxb255887 Exp $$
 */
@Controller
public class FundController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FundController.class);

    @Autowired
    private FundService fundService;

    @RequestMapping(value = "/queryFundList/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<FundModel> queryFundList(@PathVariable Integer id, final ModelMap modelMap) {
        return fundService.queryFundModelList();
    }
}
