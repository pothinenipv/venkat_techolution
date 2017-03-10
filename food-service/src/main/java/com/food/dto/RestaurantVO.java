package com.food.dto;

public class RestaurantVO {
	
	private Integer satisfactionRatio;
	private Integer time;
	private Integer satisfaction;
	
	public RestaurantVO(){
	    super();
	}
	
    public Integer getSatisfactionRatio() {
        return satisfactionRatio;
    }
    public void setSatisfactionRatio(Integer satisfactionRatio) {
        this.satisfactionRatio = satisfactionRatio;
    }
    public Integer getTime() {
        return time;
    }
    public void setTime(Integer time) {
        this.time = time;
    }
    public Integer getSatisfaction() {
        return satisfaction;
    }
    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }
	

}
