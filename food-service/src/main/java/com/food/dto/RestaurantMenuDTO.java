package com.food.dto;

public class RestaurantMenuDTO {

	private Integer itemNo;
	private Integer satisfactionAmt;
	private Integer timeTaken;
	
	public RestaurantMenuDTO(){
	    super();
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public Integer getSatisfactionAmt() {
		return satisfactionAmt;
	}

	public void setSatisfactionAmt(Integer satisfactionAmt) {
		this.satisfactionAmt = satisfactionAmt;
	}

    public Integer getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Integer timeTaken) {
        this.timeTaken = timeTaken;
    }

	

}
