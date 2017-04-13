<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html">

<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link type="text/css" rel="stylesheet"	href="resource/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"	href="resource/css/style.css">

<title>Cadastro de Cliente</title>
</head>

<body>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" id="modal">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
     <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Sistema</h4>
      </div>
      <div class="modal-body">
        <p><div id="msg"></div>
      </div>
    </div>
  </div>
</div>

<div class=container>
	<div class="row">
	
		<form id="formCadastroCliente">
			
			<fieldset class="form-post">
			
				<legend>Cadastro de Cliente</legend>
				
				<div class="form-group col-md-12">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" class="form-control" id="nome" placeholder="Nome do cliente" required>
				</div>
				
				<div class="form-group col-md-6">
				<label for="rg">RG:</label>
				<input type="text" name="rg" class="form-control" id="rg" placeholder="RG do cliente" required>
				</div>
			
				<div class="form-group col-md-6">
				<label for="cpf">CPF:</label>
				<input type="text" name="cpf" class="form-control" id="cpf" placeholder="CPF do cliente" required>
				</div>
				
				<div class="form-group col-md-6">
				<label for="telefone">Telefone:</label>
				<input type="text" name="telefone" class="form-control" id="telefone" placeholder="Telefone do cliente" required>
				</div>
				
				<div class="form-group col-md-6">
				<label for="email">Email:</label>
				<input type="email" name="email" class="form-control" id="email" placeholder="Email do cliente" required>
				</div>
				
				<div class="form-group col-md-12">
				<input type="submit" class="btn btn-primary" value="Cadastrar"/>
				<button type="button" class="btn btn-warning btn-right">Cancelar</button>
				</div>
			</fieldset>
		</form>
	</div>
</div>
 	<script src="resource/js/jquery.min.js"></script>
 	<script src="resource/js/bootstrap.min.js"></script>
 	<script src="resource/js/ajax.js"></script>
 	
</body>
</html>