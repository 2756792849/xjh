package com.xjh.workflowCurrentOperator.service;

import com.base.tools.BaseTools;
import com.base.tools.SelectCondition;
import com.base.tools.TransactionTools;
import com.xjh.repaymentDetailOne.dao.RepaymentDetailOneDao;
import com.xjh.repaymentDetailOne.model.RepaymentDetailOne;
import com.xjh.util.WorkflowDateUtil;
import com.xjh.workflowCurrentOperator.model.WorkflowCurrentOperator;
import com.xjh.workflowCurrentOperator.dao.WorkflowCurrentOperatorDao;
import com.base.service.BaseService;
import weaver.system.SysRemindWorkflow;
import java.util.Date;
import java.util.List;

public class WorkflowCurrentOperatorService extends BaseService<WorkflowCurrentOperatorDao,WorkflowCurrentOperator>{

    private WorkflowCurrentOperatorDao workflowCurrentOperatorDao = new WorkflowCurrentOperatorDao();

    private RepaymentDetailOneDao repaymentDetailOneDao = new RepaymentDetailOneDao();

    public void repaymentReminder(){

        String date = WorkflowDateUtil.getDate();

        WorkflowCurrentOperator workflowCurrentOperator = new WorkflowCurrentOperator();

        workflowCurrentOperator.setIsremark("4");

        workflowCurrentOperator.setWorkflowid("50");

        TransactionTools transactionTools = new TransactionTools();

        transactionTools.transactionStart();

        try {

            List<WorkflowCurrentOperator> workflowCurrentOperatorList = this.workflowCurrentOperatorDao.informationLoadList(workflowCurrentOperator, SelectCondition.AND);

            for (WorkflowCurrentOperator workFlowCurrentOperatorResult : workflowCurrentOperatorList
            ) {

                List<Date> dateList = WorkflowDateUtil.getBetweenDates(workFlowCurrentOperatorResult.getOperatedate() , date);

                if (dateList.size() >= 5 && dateList.size() < 7) {

                    String flag = "正常";

                    sendSysRemindWorkFlow(workFlowCurrentOperatorResult,flag);

                }else if (dateList.size() >= 7 && dateList.size() < 10) {

                    String flag = "一般";

                    sendSysRemindWorkFlow(workFlowCurrentOperatorResult,flag);

                }else if (dateList.size()==10) {

                    String flag = "严重";

                    sendSysRemindWorkFlow(workFlowCurrentOperatorResult,flag);

                }

            }

            transactionTools.transactionCommit();

        } catch (Exception e) {

            transactionTools.transactionRollback();

            this.writeLog(e.getMessage());

        }


    }

    public void sendSysRemindWorkFlow(WorkflowCurrentOperator workflowCurrentOperatorResult,String flag) throws Exception {

        RepaymentDetailOne repaymentDetailOne = new RepaymentDetailOne();

        repaymentDetailOne.setLddklc(workflowCurrentOperatorResult.getRequestid());

        repaymentDetailOne = this.repaymentDetailOneDao.informationLoadOne(repaymentDetailOne,SelectCondition.NULL);

        if(repaymentDetailOne != null){

            String sql = "SELECT requestid FROM workflow_currentoperator WHERE isremark=4 AND workflowid=80 AND requestid=" +
                    "(SELECT requestid FROM formtable_main_7 WHERE id ='"+repaymentDetailOne.getMainid()+"')";

            List<WorkflowCurrentOperator> workflowCurrentOperatorSearchList = this.workflowCurrentOperatorDao.informationLoadListCustom(workflowCurrentOperatorResult,sql);

            if (BaseTools.isNullList(workflowCurrentOperatorSearchList)) {

                sendInfo(workflowCurrentOperatorResult,flag);

            }

        }else{

            sendInfo(workflowCurrentOperatorResult,flag);

        }

    }

    public void sendInfo(WorkflowCurrentOperator workflowCurrentOperatorResult,String flag) throws Exception {

        SysRemindWorkflow srw = new SysRemindWorkflow();

        srw.setSysRemindInfo("客户垫款提醒流程", 0, 0, 0, 0,1,workflowCurrentOperatorResult.getUserid(), "您有一条客户垫款现属于[<strong><span style='color: red;'>" + flag + "超期状态</span></strong>]</br>点击查看：<a href='/workflow/request/ViewRequest.jsp?requestid="+workflowCurrentOperatorResult.getRequestid()+"'>垫款相关流程</a>");

    }

}
