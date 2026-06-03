package com.admin;

import com.svnit.AdminDAO;
public class StudentRecord implements AdminTasks 
{
	public void perform()
	{
		AdminDAO dao=new AdminDAO();
		dao.viewRecords();
		dao.updateRecords("U25AI015","KHP@17","KHWAISH",93601);
	}

}
