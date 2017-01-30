package com.techsolution.restaurant.dao.impl;

import com.techsolution.restaurant.dao.SatisfactionAnalyzer;
import com.techsolution.restaurant.helper.Constants;
import com.techsolution.restaurant.vo.SatisfactionStatsVO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Impementation class for SatisfactionAnalyzer interface
*/
public class SatisfactionAnalyzerImpl implements SatisfactionAnalyzer{

    private List<SatisfactionStatsVO> data;
    private String firstRow;
    private String satisfactionIndexFilePath;

    public SatisfactionAnalyzerImpl(String satisfactionIndexFilePath){
        data = new ArrayList<>();
        this.satisfactionIndexFilePath = satisfactionIndexFilePath;
    }

    @Override
    public int getSumOfSatisfactionWithinGivenMinutes() {
        if(data.size()==0 || (firstRow==null))
            return 0;

        Integer targetMinutes = Integer.parseInt(firstRow.split(" ")[0]);
        Integer satisfactionValue=0;
        Integer totalMinutes=0;

        for(SatisfactionStatsVO sVO : data){
            if(targetMinutes < totalMinutes)
                break;
            satisfactionValue += sVO.getSatisfactionIndex();
            totalMinutes += sVO.getMinutes();
        }
        return satisfactionValue;
    }

    @Override
    public void loadAndGetRecords() {
        try (Stream<String> stream =Files.lines(Paths.get(ClassLoader.getSystemResource(satisfactionIndexFilePath).toURI()))) {
            data = stream.skip(1)
                    .map(s -> {
                        return new SatisfactionStatsVO(Integer.parseInt(s.split(" ")[0]),Integer.parseInt(s.split(" ")[1]));
                    })
                    .sorted()
                    .collect(Collectors.<SatisfactionStatsVO> toList());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadAndGetHeader() {
        try (Stream<String> stream =Files.lines(Paths.get(ClassLoader.getSystemResource(satisfactionIndexFilePath).toURI()))) {
            firstRow = stream.findFirst().map(m -> {
                return new String(m);
            }).get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
