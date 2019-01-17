package com.xjh.time;

import com.xjh.workflowCurrentOperator.service.WorkflowCurrentOperatorService;
import weaver.interfaces.schedule.BaseCronJob;

public class RepaymentReminder extends BaseCronJob {

	private WorkflowCurrentOperatorService workflowCurrentOperatorService = new WorkflowCurrentOperatorService();

	public void execute(){

		this.workflowCurrentOperatorService.repaymentReminder();

	}

}
