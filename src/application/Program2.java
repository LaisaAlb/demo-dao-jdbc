package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDaoJDBC departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TESTE 1: Buscando Departamento por Id =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 2: Buscndo todos os Departamentos =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TESTE 3: Inserindo um Departamento =======");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! Novo Id: " + newDepartment.getId());

		System.out.println("\n=== TESTE 4: Atualizando dados =======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Atualização Completa");
		
		System.out.println("\n=== TESTE 5: delete =======");
		System.out.print("Qual Id você deseja deletar? ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deletado com sucesso");

		sc.close();
	}
}
