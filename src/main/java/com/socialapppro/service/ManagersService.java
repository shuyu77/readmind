package com.socialapppro.service;

import com.socialapppro.VO.PageVO;
import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Managers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.socialapppro.form.RuleForm;
import com.socialapppro.form.SearchForm;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2024-03-24
 */

public interface ManagersService extends IService<Managers> {

    ResultVO login(RuleForm ruleForm);

    PageVO search(SearchForm searchForm);

    PageVO list(Integer page, Integer size);
    Managers findByManagerName(String username);

    void update(Managers managers);

    void updatePwd(String newPwd);
}
