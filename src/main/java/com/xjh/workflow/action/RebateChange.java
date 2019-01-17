package com.xjh.workflow.action;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.interfaces.workflow.action.Action;
import weaver.interfaces.workflow.action.BaseAction;
import weaver.soa.workflow.request.RequestInfo;
/**
 * 返点变更流程
 * 更新客户卡片返点
 * @author MECHREVO
 *
 */
public class RebateChange extends BaseBean implements Action  {

	public String execute(RequestInfo ri) {
		this.writeLog("----------------------------------RebateChange  执行---------------------------");
		//String workflowid = ri.getWorkflowid();
		String requestid = ri.getRequestid();
		this.writeLog("----------------------------------requestid ---------------------------:"+requestid);
		RecordSet rs = null;
		RecordSet rs1 = null;
		try {
			rs = new RecordSet();
			rs1 = new RecordSet();
			String Sql ="select htbh,bghfdbl,xglc from formtable_main_23_dt1 where mainid=(select id from formtable_main_23 where requestid='"+requestid+"')";
			String htbh="";
			String bghfdbl="";
			String xglc="";
			rs1.execute(Sql);
			while (rs1.next()) {
				htbh = Util.null2String(rs1.getString("htbh"));
				bghfdbl = Util.null2String(rs1.getString("bghfdbl"));
				xglc = Util.null2String(rs1.getString("xglc"));
				rs.execute("update uf_khkp set fd='"+bghfdbl+"' where lcbh='"+htbh+"'");
				rs.execute("update formtable_main_3 set fd='"+bghfdbl+"' where requestId = '"+xglc+"'");
			}

		} catch (Exception e) {
			ri.getRequestManager().setMessageid("10000");
			ri.getRequestManager().setMessagecontent("更新客户卡片返点时出现严重异常，请联系管理员处理！");
			this.writeLog("--------SupervisionProcess Exception---------:" + e);
		}
		this.writeLog("----------------------------------RebateChange  结束-----------------------------");
		return BaseAction.SUCCESS;
	}

}