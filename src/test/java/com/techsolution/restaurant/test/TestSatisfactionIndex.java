package com.techsolution.restaurant.test;


import com.techsolution.restaurant.dao.SatisfactionAnalyzer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestSatisfactionIndex {
    @Autowired
    private SatisfactionAnalyzer satisfactionAnalyzer;
}
