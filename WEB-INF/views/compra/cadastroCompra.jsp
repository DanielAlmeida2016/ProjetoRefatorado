<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html">

<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link type="text/css" rel="stylesheet"
	href="resource/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="resource/css/style.css">

<title> Nota fiscal</title>
</head>

<body>

	<div class=container>

		<h3>Nota Fiscal</h3>

		<form id="formCadastroProduto">

			<div class="form-group col-md-6">
				<label for="fornecedor">Fornecedor: </label> <input type="text"
					name="fornecedor" class="form-control" id="fornecedor"
					placeholder="Fornecedor do produto" required>
			</div>
			
			<div class="form-group col-md-6">
				<label for="cnpj">CNPJ: </label> <input type="text"
					name="cnpj" class="form-control" id="cnpj"
					placeholder="CNPJ" required>
			</div>
			
			<div class="form-group col-md-6">
				<label for="observacao">Observação: </label> <input type="text"
					name="observacao" class="form-control" id="observacao"
					placeholder="Observacao" required>
			</div>
			
			<div class="form-group col-md-6">
				<label for="prodId">Produto: </label> <input type="text"
					name="prodId" class="form-control" id="prodId"
					placeholder="Produto" required>
			</div>
			
			<div class="form-group col-md-6">
				<label for="qtdComprada">Quantidade de produtos: </label> <input type="text"
					name="qtdComprada" class="form-control" id="qtdComprada"
					placeholder="Quantidade de produtos" required>
			</div>

			
			<div class="form-group col-md-12">
				<input type="submit" class="btn btn-primary" value="Cadastrar" />
				<button type="button" class="btn btn-warning btn-right">Cancelar</button>
			</div>
		</form>

	</div>
	<script src="resource/js/jquery.min.js"></script>
	<script src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/ajax.js"></script>

</body>
</html>