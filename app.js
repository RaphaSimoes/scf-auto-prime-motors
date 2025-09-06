let funcionarios = [
    {
        nome: "Gabriele Bernardo",
        genero: "Feminino",
        cpf: "000.111.222-33",
        telefone: "(11)99999-1111",
        endereco: "Rua A, 123, 00000-000",
        cargo: "Assistente de RH",
        setor: "Recursos Humanos",
        dataAdmissao: "2023-11-07",
        salario: "R$2.400,00",
        status: "Inativo"
    },
    {
        nome: "Rafael Alves",
        genero: "Masculino",
        cpf: "444.555.666-77",
        telefone: "(11)95555-5555",
        endereco: "Rua das Pedras, 527, 00000-000",
        cargo: "Coordenador de Cibersegurança",
        setor: "Segurança da Informação",
        dataAdmissao: "2024-09-06",
        salario: "R$25.000,00",
        status: "Ativo"
    }
];

function atualizarTabela() {
    const tbody = document.querySelector("#tabela tbody");
    tbody.innerHTML = "";

    funcionarios.forEach((f, index) => {
        let tr = document.createElement("tr");
        tr.innerHTML = `
      <td>${f.nome}</td>
      <td>${f.cargo}</td>
      <td>${f.status}</td>
      <td>
        <button onclick="editarFuncionario(${index})">Mais</button>
        <button onclick="excluirFuncionario(${index})" style="background:red">Excluir</button>
      </td>
    `;
        tbody.appendChild(tr);
    });
}

function abrirFormulario(index = null) {
    document.getElementById("modal").style.display = "block";

    if (index !== null) {
        document.getElementById("tituloFormulario").innerText = "Editar Funcionário";
        document.getElementById("indexEdicao").value = index;
        preencherFormulario(funcionarios[index]);
    } else {
        document.getElementById("tituloFormulario").innerText = "Cadastrar Funcionário";
        document.getElementById("indexEdicao").value = "";
        document.getElementById("formFuncionario").reset();
    }
}

function preencherFormulario(f) {
    document.getElementById("nome").value = f.nome;
    document.getElementById("genero").value = f.genero;
    document.getElementById("cpf").value = f.cpf;
    document.getElementById("telefone").value = f.telefone;
    document.getElementById("endereco").value = f.endereco;
    document.getElementById("cargo").value = f.cargo;
    document.getElementById("setor").value = f.setor;
    document.getElementById("dataAdmissao").value = f.dataAdmissao;
    document.getElementById("salario").value = f.salario;
    document.getElementById("status").value = f.status;
}

document.getElementById("formFuncionario").addEventListener("submit", function (e) {
    e.preventDefault();

    const novoFuncionario = {
        nome: document.getElementById("nome").value,
        genero: document.getElementById("genero").value,
        cpf: document.getElementById("cpf").value,
        telefone: document.getElementById("telefone").value,
        endereco: document.getElementById("endereco").value,
        cargo: document.getElementById("cargo").value,
        setor: document.getElementById("setor").value,
        dataAdmissao: document.getElementById("dataAdmissao").value,
        salario: document.getElementById("salario").value,
        status: document.getElementById("status").value
    };

    const index = document.getElementById("indexEdicao").value;
    if (index === "") {
        funcionarios.push(novoFuncionario);
    } else {
        funcionarios[index] = novoFuncionario;
    }

    fecharModal();
    atualizarTabela();
});

function editarFuncionario(index) {
    abrirFormulario(index);
}

function excluirFuncionario(index) {
    if (confirm("Tem certeza que deseja excluir este funcionário?")) {
        funcionarios.splice(index, 1);
        atualizarTabela();
    }
}

function fecharModal() {
    document.getElementById("modal").style.display = "none";
}

function filtrar() {
    const cargo = document.getElementById("searchCargo").value.toLowerCase();
    const status = document.getElementById("statusFilter").value;
    const linhas = document.querySelectorAll("#tabela tbody tr");

    linhas.forEach(linha => {
        const cargoTexto = linha.children[1].textContent.toLowerCase();
        const statusTexto = linha.children[2].textContent;

        if ((cargo === "" || cargoTexto.includes(cargo)) &&
            (status === "" || status === statusTexto)) {
            linha.style.display = "";
        } else {
            linha.style.display = "none";
        }
    });
}

atualizarTabela();
