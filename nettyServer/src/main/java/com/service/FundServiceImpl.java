package com.service;

import com.domain.model.FundModel;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anthony_xu
 * @version $$Id: bkpartner-parent, v 0.1 2018/05/15 13:20 anthony_xu Exp $$
 */
@Service
public class FundServiceImpl implements FundService {

    @Override
    public List<FundModel> queryFundModelList() {
        return Lists.newArrayList(new FundModel());
    }
}
