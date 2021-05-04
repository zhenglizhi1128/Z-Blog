package com.zhenglz.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zhenglz.common.Constants;
import com.zhenglz.entity.Label;
import com.zhenglz.mapper.LabelMapper;
import com.zhenglz.service.ILabelService;

/*
 * @Description:
 * @Author: zlz
 * @Date: 2021/4/26
 **/
@Service
public class LabelServiceImpl implements ILabelService {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private LabelMapper labelMapper;

    public List<Label> getLabels()throws RuntimeException{
        List<Label> labels = labelMapper.getLabels();
        return labels;
    }

    public int updateNameById(Label label) throws RuntimeException{
        return labelMapper.updatePrimaryById(label);
    }

    public int updateStatus(long id) throws RuntimeException{
        Label label = new Label();
        label.setId(id).setStatus(Constants.DISABLE).setUpdateTime(LocalDateTime.now());
        return labelMapper.updatePrimaryById(label);
    }

    public int insert(Label label) throws RuntimeException{
        return labelMapper.insert(label);
    }

    public int countLabelByName(String name) throws RuntimeException{
        return labelMapper.countLabelByName(name);
    }

    public Label getLabelById(long id) throws RuntimeException{
        return labelMapper.getLabelById(id);
    }





}
