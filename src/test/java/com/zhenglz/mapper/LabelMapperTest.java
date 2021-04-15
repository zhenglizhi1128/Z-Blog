package com.zhenglz.mapper;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenglz.entity.Label;

import cn.hutool.core.collection.CollUtil;

/**
 * @description: mybatis批量新增和修改
 * @author: zlz
 * @createDate: 2021/4/14
 * @version:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelMapperTest {

    @Autowired
    LabelMapper mapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Test
    public void testInsertList() throws FileNotFoundException {
        List<Label> labels = new ArrayList<>();
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        for (int i = 0; i < 100000; i++) {
            Label label = new Label();
            label.setCreateTime(LocalDateTime.now())
                    .setName(i+"")
                    .setUpdateTime(LocalDateTime.now())
                    .setStatus(1);
            labels.add(label);
        }
        long timeMillis = System.currentTimeMillis();
        try {
            LabelMapper mapper = session.getMapper(LabelMapper.class);
            for (Label label : labels) {
                mapper.insert(label);
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        logger.info(labels.size()+"条数据耗时:{}",(System.currentTimeMillis()-timeMillis));
    }

    @Test
    public void testInsert() throws FileNotFoundException {
        List<Label> labels = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Label label = new Label();
            label.setCreateTime(LocalDateTime.now())
                    .setName(i+"")
                    .setUpdateTime(LocalDateTime.now())
                    .setStatus(1);
            labels.add(label);
        };
		long timeMillis = System.currentTimeMillis();
		List<List<Label>> lists = CollUtil.splitList(labels, 1000);
		for (List<Label> list : lists) {
			mapper.insertList(list);
		}
        logger.info(labels.size()+"条数据耗时:{}",(System.currentTimeMillis()-timeMillis));
    }

    @Test
    public void testUpdate() throws RuntimeException {
        List<Label> labels = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Label label = new Label();
            label.setCreateTime(LocalDateTime.now())
                    .setName(i+"")
                    .setUpdateTime(LocalDateTime.now())
                    .setStatus(0);
                    labels.add(label);
        };
        long timeMillis = System.currentTimeMillis();
        List<List<Label>> lists = CollUtil.splitList(labels, 1000);
        for (List<Label> list : lists) {
            mapper.updateBatchByName(list);
        }
        long timeMillis1 = System.currentTimeMillis();
        logger.info("批量修改十万数据耗时{}"+(timeMillis1-timeMillis));
    }

    @Test
    public void testUpdateNew() throws RuntimeException {
        List<Label> labels = new ArrayList<>();
        long id=483910L;
        for (int i = 0; i < 100000; i++) {
            Label label = new Label();
            label.setCreateTime(LocalDateTime.now())
                    .setName(i+"")
                    .setUpdateTime(LocalDateTime.now())
                    .setStatus(1)
                    .setId(id);
                   id++;
            labels.add(label);
        };
        long timeMillis = System.currentTimeMillis();
        List<List<Label>> lists = CollUtil.splitList(labels, 1000);
        for (List<Label> list : lists) {
            mapper.updateBatchById(list);
        }

        long timeMillis1 = System.currentTimeMillis();
        logger.info("批量修改十万数据耗时{}"+(timeMillis1-timeMillis));
    }

    @Test
    public void testUpdate3() throws RuntimeException {
        List<Label> labels = new ArrayList<>();
        long id=483910L;
        for (int i = 0; i < 100000; i++) {
            Label label = new Label();
            label.setName(i+"")
                .setStatus(0)
                .setId(id);
            id++;
            labels.add(label);
        };

        List<List<Label>> lists = CollUtil.splitList(labels, 1000);
        for (List<Label> list : lists) {
            mapper.updateBatch(list);
        }
    }
}
