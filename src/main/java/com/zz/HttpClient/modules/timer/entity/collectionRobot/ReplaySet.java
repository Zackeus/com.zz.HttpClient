package com.zz.HttpClient.modules.timer.entity.collectionRobot;

import java.io.Serializable;

public class ReplaySet implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstTaskId;			// T1任务编号
	private Long firstTimes; 			// T1提交量
	private Long firstResultTimes;  	// T1返回量
	private String secondTaskId;		// T2任务编号
	private Long secondTimes; 			// T2提交量
	private Long secondResultTimes;  	// T2返回量
	private String thirdTaskId;			// T3任务编号
	private Long thirdTimes; 			// T3提交量
	private Long thirdResultTimes;  	// T3返回量
	private String fourthTaskId;		// T4任务编号

	public ReplaySet() {
		super();
	}

	public ReplaySet(String firstTaskId, Long firstTimes, Long firstResultTimes, String secondTaskId, Long secondTimes,
			Long secondResultTimes, String thirdTaskId, Long thirdTimes, Long thirdResultTimes, String fourthTaskId) {
		super();
		this.firstTaskId = firstTaskId;
		this.firstTimes = firstTimes;
		this.firstResultTimes = firstResultTimes;
		this.secondTaskId = secondTaskId;
		this.secondTimes = secondTimes;
		this.secondResultTimes = secondResultTimes;
		this.thirdTaskId = thirdTaskId;
		this.thirdTimes = thirdTimes;
		this.thirdResultTimes = thirdResultTimes;
		this.fourthTaskId = fourthTaskId;
	}

	public String getFirstTaskId() {
		return firstTaskId;
	}

	public void setFirstTaskId(String firstTaskId) {
		this.firstTaskId = firstTaskId;
	}

	public Long getFirstTimes() {
		return firstTimes;
	}

	public void setFirstTimes(Long firstTimes) {
		this.firstTimes = firstTimes;
	}

	public Long getFirstResultTimes() {
		return firstResultTimes;
	}

	public void setFirstResultTimes(Long firstResultTimes) {
		this.firstResultTimes = firstResultTimes;
	}

	public String getSecondTaskId() {
		return secondTaskId;
	}

	public void setSecondTaskId(String secondTaskId) {
		this.secondTaskId = secondTaskId;
	}

	public Long getSecondTimes() {
		return secondTimes;
	}

	public void setSecondTimes(Long secondTimes) {
		this.secondTimes = secondTimes;
	}

	public Long getSecondResultTimes() {
		return secondResultTimes;
	}

	public void setSecondResultTimes(Long secondResultTimes) {
		this.secondResultTimes = secondResultTimes;
	}

	public String getThirdTaskId() {
		return thirdTaskId;
	}

	public void setThirdTaskId(String thirdTaskId) {
		this.thirdTaskId = thirdTaskId;
	}

	public Long getThirdTimes() {
		return thirdTimes;
	}

	public void setThirdTimes(Long thirdTimes) {
		this.thirdTimes = thirdTimes;
	}

	public Long getThirdResultTimes() {
		return thirdResultTimes;
	}

	public void setThirdResultTimes(Long thirdResultTimes) {
		this.thirdResultTimes = thirdResultTimes;
	}
	
	public String getFourthTaskId() {
		return fourthTaskId;
	}

	public void setFourthTaskId(String fourthTaskId) {
		this.fourthTaskId = fourthTaskId;
	}

	@Override
	public String toString() {
		return "ReplaySet [firstTaskId=" + firstTaskId + ", firstTimes=" + firstTimes + ", firstResultTimes="
				+ firstResultTimes + ", secondTaskId=" + secondTaskId + ", secondTimes=" + secondTimes
				+ ", secondResultTimes=" + secondResultTimes + ", thirdTaskId=" + thirdTaskId + ", thirdTimes="
				+ thirdTimes + ", thirdResultTimes=" + thirdResultTimes + ", fourthTaskId=" + fourthTaskId + "]";
	}

}
