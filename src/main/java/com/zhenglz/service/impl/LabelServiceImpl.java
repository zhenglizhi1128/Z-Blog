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

/**
 * @author zlz
 */
@Service
public class LabelServiceImpl implements ILabelService {

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private LabelMapper labelMapper;

    @Override
    public List<Label> getLabels() throws RuntimeException {
        List<Label> labels = labelMapper.getLabels();
        return labels;
    }

    @Override
    public int updateNameById(Label label) throws RuntimeException {
        label.setUpdateTime(LocalDateTime.now()).setStatus(Constants.TRYE);
        return labelMapper.updatePrimaryById(label);
    }

    @Override
    public int updateStatus(long id) throws RuntimeException {
        Label label = new Label();
        label.setId(id).setStatus(Constants.FALSE).setUpdateTime(LocalDateTime.now());
        return labelMapper.updatePrimaryById(label);
    }

    @Override
    public int insert(Label label) throws RuntimeException {
        label.setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now()).setStatus(Constants.TRYE);
        return labelMapper.insert(label);
    }

    @Override
    public int countLabelByName(String name) throws RuntimeException {
        return labelMapper.countLabelByName(name);
    }

    @Override
    public Label getLabelById(long id) throws RuntimeException {
        return labelMapper.getLabelById(id);
    }

}
