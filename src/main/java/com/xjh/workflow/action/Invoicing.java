package com.xjh.workflow.action;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.interfaces.workflow.action.Action;
import weaver.interfaces.workflow.action.BaseAction;
import weaver.soa.workflow.request.RequestInfo;
/**
 * 开具发票流程变更发票状态
 * @author MECHREVO
 *
 */
public class Invoicing extends BaseBean implements Action  {

	public String execute(RequestInfo ri) {
		this.writeLog("----------------------------------Invoicing  执行---------------------------");
		//String workflowid = ri.getWorkflowid();
		String requestid = ri.getRequestid();
		RecordSet rs = null;
		RecordSet rs1 = null;
		String selectId="select htmc,lcbh from formtable_main_4 where requestid='"+requestid+"'";
		try {
			rs = new RecordSet();
			rs1 = new RecordSet();
			rs.execute(selectId);
			String htmc="";
			String lcbh="";
			if (rs.next()) {
				htmc = Util.null2String(rs.getString("htmc"));
				lcbh = Util.null2String(rs.getString("lcbh"));
			}
			String updateSql="update uf_fpkjmxb set fpzt=0 where htmc='"+htmc+"' and lcbh ='"+lcbh+"'";
			rs1.execute(updateSql);
		} catch (Exception e) {
			ri.getRequestManager().setMessageid("10000");
			ri.getRequestManager().setMessagecontent("更新发票状态时出现严重异常，请联系管理员处理！");
			this.writeLog("--------SupervisionProcess Exception---------:" + e);
		}
		this.writeLog("----------------------------------Invoicing  结束-----------------------------");
		return BaseAction.SUCCESS;
	}

}