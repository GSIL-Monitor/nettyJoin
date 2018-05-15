package com.service;

import com.domain.model.FundModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wb-xxb255887
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/15 11:08 wb-xxb255887 Exp $$
 */
public interface FundService {

    List<FundModel> queryFundModelList();
}
