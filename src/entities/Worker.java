package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

//	Associações: "Um trabalhador tem um Departamento e vários Contratos"
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {

	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public double income(int year, int month) {
		double totalIncome = baseSalary;

		for (HourContract contract : contracts) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(contract.getDate());
			int contractYear = cal.get(Calendar.YEAR);
			int contractMonth = cal.get(Calendar.MONTH) + 1;

			if (contractYear == year && contractMonth == month) {
				totalIncome += contract.totalValue();
			}
		}
		return totalIncome;
	}
}
/* >> Passo a passo do Loop:

Início :

	O loop for (HourContract contract : contracts) itera sobre todos os elementos da coleção contracts.

 A cada iteração:

	Uma variável contract do tipo HourContract é criada para representar o contrato atual da iteração.
	Esse contrato é extraído da lista contracts.

 Criação de uma instância de Calendar:

	Em cada iteração, o método Calendar.getInstance() cria uma nova instância de Calendar.
	Essa instância é usada para manipular e extrair informações da data associada ao contrato.

 Configuração da Data no Calendar:

	O método cal.setTime(contract.getDate()) define a data do contrato (contract.getDate()) no objeto Calendar.
	Isso permite que o Calendar seja configurado com a data do contrato atual, facilitando a extração de informações como ano e mês.

 Extração do Ano do Contrato:

	A chamada cal.get(Calendar.YEAR) obtém o ano da data configurada no Calendar.
	Esse valor é armazenado na variável contractYear.

 Extração do Mês do Contrato:

	A chamada cal.get(Calendar.MONTH) obtém o mês da data configurada no Calendar.
	Importante: O valor retornado pelo Calendar.MONTH vai de 0 (janeiro) a 11 (dezembro). Por isso, somamos 1 para que os meses fiquem no intervalo de 1 a 12 (padrão de meses do calendário humano).
	Esse valor ajustado é armazenado na variável contractMonth.

 Verificação do Ano e Mês:

	A condição if (contractYear == year && contractMonth == month) verifica se o ano e o mês do contrato (contractYear e contractMonth) coincidem com os valores fornecidos pelos parâmetros do método (year e month).
	Se essa condição for verdadeira, significa que o contrato pertence ao mês e ano desejados.

 Cálculo do Valor Total do Contrato:

	Se a condição no if for satisfeita, o método contract.totalValue() é chamado.
	Esse método retorna o valor total do contrato, que é calculado como:

	totalValue = valuePerHour * hours
	O valor retornado é adicionado à variável totalIncome, que acumula o salário total do trabalhador para o mês e ano especificados.

 Próxima Iteração:

	O loop segue para o próximo contrato da lista contracts e repete o processo.
	Isso continua até que todos os contratos tenham sido processados.

 Fim do Loop:

	Quando todos os contratos da lista foram iterados, o loop termina.
	Nesse ponto, a variável totalIncome contém o salário total do trabalhador, que inclui o salário-base e o total dos valores dos contratos do mês especificado.

 Resumo do Funcionamento:

  Para cada contrato da lista:

	Extraímos o ano e o mês do contrato usando Calendar.
	Verificamos se o contrato pertence ao ano e mês informados.
	Se sim, somamos o valor total do contrato ao salário acumulado (totalIncome).
*/