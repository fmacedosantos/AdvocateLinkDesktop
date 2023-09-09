<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Documentação do Projeto AdvocateLink</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            font-size: 24px;
        }
        h2 {
            font-size: 20px;
        }
        h3 {
            font-size: 18px;
        }
        p {
            font-size: 16px;
        }
        code {
            background-color: #f2f2f2;
            padding: 2px 4px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-family: Consolas, "Courier New", monospace;
        }
        pre {
            background-color: #f2f2f2;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            overflow-x: auto;
            font-family: Consolas, "Courier New", monospace;
        }
    </style>
</head>
<body>
    <h1>Documentação do Projeto AdvocateLink</h1>
    <h2>Visão Geral</h2>
    <p>O projeto AdvocateLink é uma aplicação que permite gerenciar funcionários e clientes através de uma API. Ele oferece as seguintes funcionalidades:</p>
    <ol>
        <li><strong>Uso em Modo Offline:</strong> O aplicativo suporta um modo offline que permite ao usuário continuar utilizando-o mesmo quando não estiver conectado à API do AdvocateLink.</li>
        <li><strong>Gerenciamento de Funcionários e Clientes:</strong> É possível realizar operações CRUD (Create, Read, Update, Delete) para funcionários e clientes.</li>
    </ol>
    <h2>Modo Offline</h2>
    <p>O AdvocateLink suporta um modo offline para permitir que os usuários continuem utilizando o aplicativo mesmo quando não estão conectados à API. No entanto, é importante notar que as operações que requerem interação com a API não estarão disponíveis durante o modo offline. As informações serão sincronizadas com a API assim que a conexão for restaurada.</p>
    <h2>Endpoints da API</h2>
    <h3>1. Alterar Funcionário/Cliente (PUT)</h3>
    <p><strong>Endpoint:</strong> <code>PUT /client/api/{id}</code></p>
    <p><strong>Descrição:</strong> Este endpoint permite alterar informações de um funcionário ou cliente existente com base no ID fornecido.</p>
    <p><strong>Parâmetros:</strong></p>
    <ul>
        <li><code>{id}</code>: ID do funcionário ou cliente que deseja atualizar.</li>
    </ul>
    <p><strong>Corpo da Solicitação:</strong> O corpo da solicitação deve conter os dados atualizados do funcionário ou cliente.</p>
    <h3>2. Deletar Funcionário/Cliente (DELETE)</h3>
    <p><strong>Endpoint:</strong> <code>DELETE /client/api/{id}</code></p>
    <p><strong>Descrição:</strong> Este endpoint permite excluir um funcionário ou cliente existente com base no ID fornecido.</p>
    <p><strong>Parâmetros:</strong></p>
    <ul>
        <li><code>{id}</code>: ID do funcionário ou cliente que deseja excluir.</li>
    </ul>
</body>
</html>
