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

<title>Alterar Dados do Produto</title>
</head>

<body>

	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" id="modal">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Sistema</h4>
				</div>
				<div class="modal-body">
					<p>
					<div id="msg"></div>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div class=container>

		<h3>Alterar Dados do Produto</h3>

		<form id="formAlterarProduto">

			<input type="hidden" class="form-control" name="id" value="${produto.id}"/>

			<div class="form-group col-md-12">
				<label for="id">Id: </label> <input type="text" class="form-control"
					value="${produto.id}" disabled>
			</div>

			<div class="form-group col-md-6">
				<label for="descricao">Descrição: </label> <input type="text"
					name="descricao" class="form-control" id="descricao"
					placeholder="Descrição do Produto" value="${produto.descricao}"
					required>
			</div>

			<div class="form-group col-md-6">
				<label for="categoria">Categoria:</label> <input type="text"
					name="categoria" class="form-control" id="categoria"
					placeholder="Categoria do Produto" value="${produto.categoria}"
					required>
			</div>

			<div class="form-group col-md-6">
				<label for="fornecedor">Fornecedor:</label> <input type="text"
					name="fornecedor" class="form-control" id="fornecedor"
					placeholder="Fornecedor" value="${produto.fornecedor}" required>
			</div>

			<div class="form-group col-md-6">
				<label for="valorCompra">Valor da Compra:</label> <input
					type="number" name="valorCompra" class="form-control"
					id="valorCompra" placeholder="Valor da compra"
					value="${produto.valorCompra}" required>
			</div>

			<div class="form-group col-md-6">
				<label for="valorVenda">Valor da Venda:</label> <input type="number"
					name="valorVenda" class="form-control" id="valorVenda"
					placeholder="Valor da venda" value="${produto.valorVenda}" required>
			</div>


			<div class="form-group col-md-6">
				<label for="quantidade">Quantidade:</label> <input type="number"
					name="quantidade" class="form-control" id="quantidade"
					placeholder="Quantidade" value="${produto.quantidade}" required>
			</div>

			<div class="form-group col-md-12">
				<input type="submit" class="btn btn-primary" value="Alterar" />
				<button type="button" class="btn btn-default btn-right">Cancelar</button>
			</div>
		</form>

	</div>
	<script src="resource/js/jquery.min.js"></script>
	<script src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/ajax.js"></script>

</body>
</html>