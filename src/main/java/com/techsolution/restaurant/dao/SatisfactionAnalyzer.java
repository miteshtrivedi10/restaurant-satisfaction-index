package com.techsolution.restaurant.dao;

import com.techsolution.restaurant.vo.SatisfactionStatsVO;


public interface SatisfactionAnalyzer extends FileLoaderMapper<SatisfactionStatsVO>{
    /*
    *   Calculates the total no. of satisfaction index for a given no. of minutes
    *   @return total value of satisfaction index calculated based on given minutes
    */
    public int getSumOfSatisfactionWithinGivenMinutes();
}
