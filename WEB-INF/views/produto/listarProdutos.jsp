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
<link href="resource/css/tabela.css" rel="stylesheet">

<title>Listagem de Todos Produtos</title>
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

	<!-- Modal Seleção -->
	<div class="modal fade" tabindex="-1" role="dialog" id="modalSelecao">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Atenção</h4>
				</div>
				<div class="modal-body">
					<p>Deseja realmente excluir este cliente?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
					<button type="button" class="btn btn-primary" id="excluirCliente">Sim</button>
				</div>
			</div>
		</div>
	</div>

	<div class="Container">
		<div class="table-responsive">
			<table class="table" id="tabela">
				<tr class="filters">
					<td>Descrição:</td>
					<td>Categoria:</td>
					<td>Valor da Venda:</td>
				</tr>
				<tr>
					<th><input type="text" id="descricao" /></th>
					<th><input type="text" id="categoria" /></th>
					<th><input type="text" id="valorVenda" /></th>
				</tr>
				<c:forEach var="produto" items="${produtos}">
					<tr>
						<td>${produto.descricao}</td>
						<td>${produto.categoria}</td>
						<td>${produto.valorVenda}</td>
						<td><a class="btn btn-warning"
							href="Controller?command=BuscarProduto&id=${produto.id}"
							role="button">Alterar</a></td>
						<td><a class="btn btn-danger selecionarProduto">Excluir</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
	<script src="resource/js/jquery.min.js"></script>
	<script src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/ajax.js"></script>
	<script src="resource/js/filtroTabela.js"></script>
</body>
</html>