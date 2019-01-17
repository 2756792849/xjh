package com.xjh.workflowCurrentOperator.model;

import com.base.model.BaseModel;

public class WorkflowCurrentOperator extends BaseModel {

private String requestid;

 public String getRequestid() {

return requestid;

}

 public void setRequestid(String requestid) {

this.requestid = requestid;

}

private String userid;

 public String getUserid() {

return userid;

}

 public void setUserid(String userid) {

this.userid = userid;

}

private String groupid;

 public String getGroupid() {

return groupid;

}

 public void setGroupid(String groupid) {

this.groupid = groupid;

}

private String workflowid;

 public String getWorkflowid() {

return workflowid;

}

 public void setWorkflowid(String workflowid) {

this.workflowid = workflowid;

}

private String workflowtype;

 public String getWorkflowtype() {

return workflowtype;

}

 public void setWorkflowtype(String workflowtype) {

this.workflowtype = workflowtype;

}

private String isremark;

 public String getIsremark() {

return isremark;

}

 public void setIsremark(String isremark) {

this.isremark = isremark;

}

private String usertype;

 public String getUsertype() {

return usertype;

}

 public void setUsertype(String usertype) {

this.usertype = usertype;

}

private String nodeid;

 public String getNodeid() {

return nodeid;

}

 public void setNodeid(String nodeid) {

this.nodeid = nodeid;

}

private String agentorbyagentid;

 public String getAgentorbyagentid() {

return agentorbyagentid;

}

 public void setAgentorbyagentid(String agentorbyagentid) {

this.agentorbyagentid = agentorbyagentid;

}

private String agenttype;

 public String getAgenttype() {

return agenttype;

}

 public void setAgenttype(String agenttype) {

this.agenttype = agenttype;

}

private String showorder;

 public String getShoworder() {

return showorder;

}

 public void setShoworder(String showorder) {

this.showorder = showorder;

}

private String receivedate;

 public String getReceivedate() {

return receivedate;

}

 public void setReceivedate(String receivedate) {

this.receivedate = receivedate;

}

private String receivetime;

 public String getReceivetime() {

return receivetime;

}

 public void setReceivetime(String receivetime) {

this.receivetime = receivetime;

}

private String viewtype;

 public String getViewtype() {

return viewtype;

}

 public void setViewtype(String viewtype) {

this.viewtype = viewtype;

}

private String iscomplete;

 public String getIscomplete() {

return iscomplete;

}

 public void setIscomplete(String iscomplete) {

this.iscomplete = iscomplete;

}

private String islasttimes;

 public String getIslasttimes() {

return islasttimes;

}

 public void setIslasttimes(String islasttimes) {

this.islasttimes = islasttimes;

}

private String id;

 public String getId() {

return id;

}

 public void setId(String id) {

this.id = id;

}

private String operatedate;

 public String getOperatedate() {

return operatedate;

}

 public void setOperatedate(String operatedate) {

this.operatedate = operatedate;

}

private String operatetime;

 public String getOperatetime() {

return operatetime;

}

 public void setOperatetime(String operatetime) {

this.operatetime = operatetime;

}

private String groupdetailid;

 public String getGroupdetailid() {

return groupdetailid;

}

 public void setGroupdetailid(String groupdetailid) {

this.groupdetailid = groupdetailid;

}

private String isreminded;

 public String getIsreminded() {

return isreminded;

}

 public void setIsreminded(String isreminded) {

this.isreminded = isreminded;

}

private String isprocessed;

 public String getIsprocessed() {

return isprocessed;

}

 public void setIsprocessed(String isprocessed) {

this.isprocessed = isprocessed;

}

private String wfreminduser;

 public String getWfreminduser() {

return wfreminduser;

}

 public void setWfreminduser(String wfreminduser) {

this.wfreminduser = wfreminduser;

}

private String wfusertypes;

 public String getWfusertypes() {

return wfusertypes;

}

 public void setWfusertypes(String wfusertypes) {

this.wfusertypes = wfusertypes;

}

private String preisremark;

 public String getPreisremark() {

return preisremark;

}

 public void setPreisremark(String preisremark) {

this.preisremark = preisremark;

}

private String isreject;

 public String getIsreject() {

return isreject;

}

 public void setIsreject(String isreject) {

this.isreject = isreject;

}

private String needwfback;

 public String getNeedwfback() {

return needwfback;

}

 public void setNeedwfback(String needwfback) {

this.needwfback = needwfback;

}

private String lastisremark;

 public String getLastisremark() {

return lastisremark;

}

 public void setLastisremark(String lastisremark) {

this.lastisremark = lastisremark;

}

private String isreminded_csh;

 public String getIsreminded_csh() {

return isreminded_csh;

}

 public void setIsreminded_csh(String isreminded_csh) {

this.isreminded_csh = isreminded_csh;

}

private String wfreminduser_csh;

 public String getWfreminduser_csh() {

return wfreminduser_csh;

}

 public void setWfreminduser_csh(String wfreminduser_csh) {

this.wfreminduser_csh = wfreminduser_csh;

}

private String wfusertypes_csh;

 public String getWfusertypes_csh() {

return wfusertypes_csh;

}

 public void setWfusertypes_csh(String wfusertypes_csh) {

this.wfusertypes_csh = wfusertypes_csh;

}

private String handleforwardid;

 public String getHandleforwardid() {

return handleforwardid;

}

 public void setHandleforwardid(String handleforwardid) {

this.handleforwardid = handleforwardid;

}

private String takisremark;

 public String getTakisremark() {

return takisremark;

}

 public void setTakisremark(String takisremark) {

this.takisremark = takisremark;

}

private String lastRemindDatetime;

 public String getLastRemindDatetime() {

return lastRemindDatetime;

}

 public void setLastRemindDatetime(String lastRemindDatetime) {

this.lastRemindDatetime = lastRemindDatetime;

}

@Override

public String getTableName() {

return "workflow_currentoperator";

}

}

