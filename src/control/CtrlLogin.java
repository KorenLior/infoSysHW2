package control;

import java.util.ArrayList;

import boundary.BdrEmployeeMenu;
import boundary.BdrManagerMenu;
import boundary.BdrTransportRepMenu;
import entity.Branch;
import entity.DbGetBranchList;
import entity.DbGetEmployeeList;
import entity.Employee;

public class CtrlLogin {

	public CtrlLogin(int id) {
		ArrayList<Employee> emplyeeList = new DbGetEmployeeList().getEmployees();
		ArrayList<Branch> branchList = new DbGetBranchList().getBranches();
		for(Employee employee:emplyeeList)
		{
			if (employee.getId() == id)
			{
				for (Branch branch:branchList)
				{
					if (branch.getBranchNum() == employee.getBranchNum())
					{
						if (branch.getManagerId() == id)
						{
							new BdrManagerMenu();
							break;
						}
						if (branch.getTransportRepId() == id)
						{
							new BdrTransportRepMenu();
							break;
						}
						new BdrEmployeeMenu();
					}
				}
			}
		}
	}
}
