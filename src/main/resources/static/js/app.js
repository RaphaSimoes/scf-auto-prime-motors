// js/app.js

function abrirFormulario() {
    // Limpa o formulário e ajusta o título para "Cadastrar"
    document.getElementById('formFuncionario').reset();
    document.getElementById('tituloFormulario').innerText = "Cadastro de Funcionário";
    
    // Define a ação do formulário para o endpoint de salvar/criar
    document.getElementById('formFuncionario').action = "/funcionarios/salvar";

    // Mostra o modal
    document.getElementById('modal').style.display = 'block';
}

function fecharModal() {
    document.getElementById('modal').style.display = 'none';
}

// Esta função será chamada pelos botões "Editar" gerados pelo Thymeleaf
function abrirFormularioEdicao(id, nome, genero, cpf, telefone, endereco, cargo, setor, dataAdmissao, salario, status) {
    document.getElementById('tituloFormulario').innerText = "Editar Funcionário";

    // Preenche o formulário com os dados do funcionário
    document.getElementById('id').value = id;
    document.getElementById('nome').value = nome;
    document.getElementById('genero').value = genero;
    document.getElementById('cpf').value = cpf;
    document.getElementById('telefone').value = telefone;
    document.getElementById('endereco').value = endereco;
    document.getElementById('cargo').value = cargo;
    document.getElementById('setor').value = setor;
    document.getElementById('dataAdmissao').value = dataAdmissao;
    document.getElementById('salario').value = salario;
    document.getElementById('status').value = status;
    
    // Define a ação do formulário para o endpoint de salvar/atualizar
    document.getElementById('formFuncionario').action = "/funcionarios/salvar";

    // Mostra o modal
    document.getElementById('modal').style.display = 'block';
}