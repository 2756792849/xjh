package com.xjh.time;

import java.util.Date;
import java.util.List;
import com.xjh.util.WorkflowDateUtil;
import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.interfaces.schedule.BaseCronJob;
import weaver.system.SysRemindWorkflow;

public class RepaymentReminder extends BaseCronJob {

	public void execute() {
		BaseBean bb = new BaseBean();
		String date = WorkflowDateUtil.getDate();
		RecordSet rs=null;
		RecordSet rs1=null;
		RecordSet rs2=null;
		bb.writeLog("--------------------------------------------------�������Ѽƻ�����ʼ-----------------------------------------------------------------------");
		try {
			rs = new RecordSet();
			rs1 = new RecordSet();
			rs2 = new RecordSet();
			String selectSQL="select requestid,userid,operatedate from workflow_currentoperator where isremark=4 and workflowid=50";
			rs.execute(selectSQL);
			bb.writeLog("-------------------------date��"+date);
			while (rs.next()) {
				String userid = Util.null2String(rs.getString("userid"));//       1
				String czsj = Util.null2String(rs.getString("operatedate"));//�鵵ʱ��         2019-01-04
				String requestid = Util.null2String(rs.getString("requestid"));  //51
				
				List<Date> list = WorkflowDateUtil.getBetweenDates(czsj , date);

				bb.writeLog("-------------------------������"+list.size());
				if (list.size()>=5&list.size()<7) {
				//��ѯ����������ϸ�����Ƿ��л����¼
				String sql="select mainid from formtable_main_7_dt1 where lddklc='"+requestid+"'";
				rs1.execute(sql);
					if (rs1.next()) {
						String mainid = Util.null2String(rs.getString("mainid"));
						String sql1="select requestid from workflow_currentoperator where isremark=4 and workflowid=80 and requestid=" +
								"(select requestid from formtable_main_7 where id ='"+mainid+"')";
						rs2.execute(sql1);
						if (rs2.next()) {
							SysRemindWorkflow srw = new SysRemindWorkflow();
							srw.setSysRemindInfo("�ͻ������������", 0, 0, 0, 0,1,userid, "����һ���ͻ����������[<strong><span style='color: red;'>��������״̬</span></strong>]</br>����鿴��<a href='/workflow/request/ViewRequest.jsp?requestid="+requestid+"'>����������</a>");
						}
					}else{
						SysRemindWorkflow srw = new SysRemindWorkflow();
						srw.setSysRemindInfo("�ͻ������������", 0, 0, 0, 0,1,userid, "����һ���ͻ����������[<strong><span style='color: red;'>��������״̬</span></strong>]</br>����鿴��<a href='/workflow/request/ViewRequest.jsp?requestid="+requestid+"'>����������</a>");
					}
				}else if (list.size()>=7&list.size()<10) {
					String sql="select mainid from 	formtable_main_7_dt1 where lddklc='"+requestid+"'";
					rs1.execute(sql);
						if (rs1.next()) {
							String mainid = Util.null2String(rs.getString("mainid"));
							String sql1="select requestid from workflow_currentoperator where isremark=4 and workflowid=80 and requestid=" +
									"(select requestid from formtable_main_7 where id ='"+mainid+"')";
							rs2.execute(sql1);
							if (rs2.next()) {
								SysRemindWorkflow srw = new SysRemindWorkflow();
								srw.setSysRemindInfo("�ͻ������������", 0, 0, 0, 0,1,userid, "����һ���ͻ����������[<strong><span style='color: red;'>һ�㳬��״̬</span></strong>]</br>����鿴��<a href='/workflow/request/ViewRequest.jsp?requestid="+requestid+"'>����������</a>");
							}
						}else{
							SysRemindWorkflow srw = new SysRemindWorkflow();
							srw.setSysRemindInfo("�ͻ������������", 0, 0, 0, 0,1,userid, "����һ���ͻ����������[<strong><span style='color: red;'>һ�㳬��״̬</span></strong>]</br>����鿴��<a href='/workflow/request/ViewRequest.jsp?requestid="+requestid+"'>����������</a>");
						}
				}else if (list.size()==10) {
					String sql="select mainid from 	formtable_main_7_dt1 where lddklc='"+requestid+"'";
					rs1.execute(sql);
						if (rs1.next()) {
							String mainid = Util.null2String(rs.getString("mainid"));
							String sql1="select requestid from workflow_currentoperator where isremark=4 and workflowid=80 and requestid=" +
									"(select requestid from formtable_main_7 where id ='"+mainid+"')";
							rs2.execute(sql1);
							if (rs2.next()) {
								SysRemindWorkflow srw = new SysRemindWorkflow();
								srw.setSysRemindInfo("�ͻ������������", 0, 0, 0, 0,1,userid, "����һ���ͻ����������[<strong><span style='color: red;'>���س���״̬</span></strong>]</br>����鿴��<a href='/workflow/request/ViewRequest.jsp?requestid="+requestid+"'>����������</a>");
							}
						}else{
							SysRemindWorkflow srw = new SysRemindWorkflow();
							srw.setSysRemindInfo("�ͻ������������", 0, 0, 0, 0,1,userid, "����һ���ͻ����������[<strong><span style='color: red;'>���س���״̬</span></strong>]</br>����鿴��<a href='/workflow/request/ViewRequest.jsp?requestid="+requestid+"'>����������</a>");
						}
				}
			}
		} catch (Exception e) {
			bb.writeLog("------------�쳣��"+e);
		}

		bb.writeLog("--------------------------------------------------�������Ѽƻ��������-----------------------------------------------------------------------");
	}
}
