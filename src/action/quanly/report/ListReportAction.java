package action.quanly.report;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PromotionForm;
import form.ReportForm;
import model.bean.Promotion;
import model.bean.Report;
import model.bo.ReportBO;

public class ListReportAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReportForm reportForm = (ReportForm) form;
		ReportBO ReportBO = new ReportBO();
		ArrayList<Report> listReport = new ArrayList<Report>();
		listReport = ReportBO.getListReport(reportForm.getFrom(), reportForm.getTo(), reportForm.getGroupBy());
		if (!listReport.isEmpty()) {
			int totalQuantity = 0;
			long totalPrice = 0;
			for (Report report : listReport) {
				totalQuantity += report.getTotalQuantity();
				totalPrice += report.getTotalPrice();
			}
			Report totalReport = new Report("", "Tổng Số", totalQuantity, totalPrice);
			listReport.add(totalReport);
		}
		reportForm.setListReport(listReport);
		return mapping.findForward("thanhCong");
	}
}
