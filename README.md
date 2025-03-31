<h2>Setup de teste</h2>

Usando postgres, crie um DB chamado "login"
Envie um POST para "/auth/register" contendo um json:
```
{
  "username": "user",
  "password": "pass"
}
```
Envie um POST para "/auth/login" contendo um json:
```
{
  "username": "user",
  "password": "pass"
}
```
Tentativas de login com credenciais erradas ou registro duplicado exibem mensagem de erro

<h2>Uso em projetos</h2>

Esse repo pode ser usado como submodulo em outro projeto (funcionalidade não testada ainda)
