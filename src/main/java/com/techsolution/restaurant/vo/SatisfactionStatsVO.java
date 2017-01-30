package com.techsolution.restaurant.vo;

/*
POJO for capturing satisfaction index and minutes to eat dish
*/
public class SatisfactionStatsVO implements Comparable{
    private Integer satisfactionIndex;
    private Integer minutes;

    /*
        Getter method for satisfaction index
        @return satisfaction index in Integer value
    */
    public Integer getSatisfactionIndex() {
        return satisfactionIndex;
    }

    /*
        Setter method for satisfaction index
        @param satisfaction index in Integer value
    */
    public void setSatisfactionIndex(Integer satisfactionIndex) {
        this.satisfactionIndex = satisfactionIndex;
    }

    /*
        Getter method for minutes to eat dish
        @return minutes in Integer value
    */
    public Integer getMinutes() {
        return minutes;
    }

    /*
        Setter method for minutes to eat dish
        @param minutes in Integer value
    */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }


    /*
        Constructor for SatisfactionStats POJO
        @param sIndex in Integer value
        @param sMinutes in Integer value
    */
    public SatisfactionStatsVO(Integer sIndex,Integer sMinutes){
        this.satisfactionIndex=sIndex;
        this.minutes=sMinutes;
    }

    @Override
    public boolean equals(Object o){
        SatisfactionStatsVO sVO = (SatisfactionStatsVO)o;
        if(this.getMinutes() == sVO.getMinutes() && this.getSatisfactionIndex() == sVO.getSatisfactionIndex()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.satisfactionIndex.intValue();
    }

    @Override
    public int compareTo(Object o) {
        SatisfactionStatsVO sVO = (SatisfactionStatsVO)o;
        return this.getMinutes().compareTo(sVO.getMinutes());
    }

    @Override
    public String toString(){
        return "Satifaction Index = " + satisfactionIndex + "  ;  Minutes = " + minutes;
    }
}
