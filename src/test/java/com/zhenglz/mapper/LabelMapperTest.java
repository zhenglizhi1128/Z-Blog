package com.zhenglz.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenglz.entity.Label;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelMapperTest {

    @Autowired
    LabelMapper labelMapper;

    @Test
    public void list() {
        Label label = new Label();
        label.setName("Mybatis").setStatus(true).setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now());
        // labelMapper.insert(label);
        List<Label> labels = labelMapper.getLabels();
        Label label1 = labels.get(0);
        label1.setUpdateTime(LocalDateTime.now()).setStatus(false);
        labelMapper.updatePrimaryById(label1);
    }

    @Test
    public void test1() {
        int spring = labelMapper.countLabelByName("spring");
    }

    @Test
    public void test2() {
        Label label = labelMapper.getLabelById(12l);
        System.out.println(label);
    }

}