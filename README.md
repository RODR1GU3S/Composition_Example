# Worker Contracts System

Este projeto em Java demonstra o uso do conceito de **composição** para modelar um sistema de gestão de trabalhadores, departamentos e contratos de trabalho.

## Estrutura do Projeto

O projeto é composto pelos seguintes pacotes e classes:

### Pacote `application`
- **Program**: Classe principal que interage com o usuário, solicitando informações sobre o trabalhador e seus contratos.

### Pacote `entities`
- **Worker**: Representa um trabalhador e contém uma lista de contratos associados.
- **Department**: Representa um departamento ao qual um trabalhador pertence.
- **HourContract**: Representa um contrato por hora, contendo informações como data, valor por hora e duração.

### Pacote `entities.enums`
- **WorkerLevel**: Enumeração que define os níveis de um trabalhador (JUNIOR, MID_LEVEL, SENIOR).

## Funcionalidades
- Cadastro de um trabalhador associado a um departamento.
- Adição de contratos de trabalho ao trabalhador.
- Cálculo da renda do trabalhador para um mês e ano informados.

## Como Executar
1. Compile e execute a classe `Program`.
2. Insira os dados do departamento e do trabalhador.
3. Informe a quantidade de contratos e preencha os detalhes de cada um.
4. Insira o mês e o ano para calcular a renda do trabalhador.
5. O programa exibirá o resultado formatado.

## Exemplo de Entrada/Saída

**Entrada:**
```
Enter department's name: Sales
Enter worker data:
Name: John Doe
Level: SENIOR
Base salary: 5000.00
How many contracts to this worker? 2
Enter contract #1 data:
Date (DD/MM/YYYY): 20/08/2023
Value per hour: 50.00
Duration (hours): 20
Enter contract #2 data:
Date (DD/MM/YYYY): 13/08/2023
Value per hour: 30.00
Duration (hours): 10
Enter month and year to calculate income (MM/YYYY): 08/2023
```

**Saída:**
```
Name: John Doe
Department: Sales
Income for 08/2023: 5600.00
```

## Conceitos Aplicados
- **Composição**: `Worker` possui um `Department` e uma lista de `HourContract`.
- **Enumeração**: Uso do enum `WorkerLevel` para representar diferentes níveis de trabalhador.
- **Encapsulamento**: Uso de métodos `get` e `set` para acesso seguro aos atributos.
- **Manipulação de Datas**: Uso de `SimpleDateFormat` e `Calendar` para lidar com datas.
