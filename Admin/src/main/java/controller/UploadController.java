package controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.Client;
import model.Operator;
import service.ClientService;
import utils.ReturnInfo;

@Controller
@Scope(scopeName = "session")
@RequestMapping("upload")
public class UploadController {

	@Autowired
	ClientService service;
	
	
	List<Client> list = new ArrayList<Client>();

	@RequestMapping("list")
	public @ResponseBody ReturnInfo list() {	
		return   new ReturnInfo( list);
	}
	
	@RequestMapping("save")
	@ResponseBody
	public String save(String ids) {
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		
		for(int i=0;i<list.size();i++) {
			String id=","+list.get(i).getId()+",";
			if(ids.indexOf(id)<0)  continue;
			Operator user = (Operator) SecurityUtils.getSubject().getSession().getAttribute("user");
			list.get(i).setCreateoperatorid(user.getId());
			list.get(i).setCreatedate(dateFormat.format(date));
			service.insert(list.get(i));
			list.get(i).setUploadstatus(1);
		}
		return   "{\"status\":1}";
	}

	@RequestMapping("index")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file) {
		list = new Vector<Client>();

		try {
			InputStream input = file.getInputStream();

			Workbook wb = new HSSFWorkbook(input);

			Sheet sheet = wb.getSheetAt(0);

			int rowNum = sheet.getLastRowNum() + 1;

			for (int i = 1; i < rowNum; i++) {
				Client t = new Client();
				Row row = sheet.getRow(i);

				// 容器名称
				Cell containerCell = row.getCell(0);
				String val = containerCell.getStringCellValue();
				t.setName(val);
				containerCell = row.getCell(1);
				int num = (int) containerCell.getNumericCellValue();
				t.setSex(num);
				containerCell = row.getCell(2);
				val = containerCell.getStringCellValue();
				t.setTel(val);
				containerCell = row.getCell(3);
				val = containerCell.getStringCellValue();
				t.setQq(val);
				containerCell = row.getCell(4);
				val = containerCell.getStringCellValue();
				t.setEmail(val);
				containerCell = row.getCell(5);
				num = (int) containerCell.getNumericCellValue();
				t.setClienttypeid(num);
				containerCell = row.getCell(6);
				num = (int) containerCell.getNumericCellValue();
				t.setSrcid(num);
				
				t.setId(i-1);
				list.add(t);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return   "{\"status\":1}";
	}

}
