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
<link type="text/css" rel="stylesheet"  href="resource/css/tabela.css">
<link type="text/css" rel="stylesheet"	href="resource/css/style.css">

<title>Lista de Clientes</title>
</head>

<body>

<c:import url="menuCliente.jsp"></c:import>

<!-- <header class="bs-docs-nav navbar navbar-static-top navbar-inverse" id="top"> 
	<div class="container-fluid"> 
		<div class="navbar-header"> 
			<button aria-controls="bs-navbar" aria-expanded="false" class="navbar-toggle collapsed" data-target="#bs-navbar" data-toggle="collapse" type="button"> 
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span>
			    <span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
			</button> 
			<a href="" class="navbar-brand"><span class="glyphicon glyphicon-home"></span></a> 
		</div> 
			<nav class="navbar-collapse collapse" id="bs-navbar" aria-expanded="false" style="height: 1px;">
				<ul class="nav navbar-nav"> 
					<li> 
						<a role="button" data-toggle="collapse" href="#collapseUsuario" aria-expanded="false" aria-controls="collapseUsuario">Usuarios</a>
							<nav class="collapse" id="collapseUsuario" aria-expanded="false" style="height: 1px;">
								<ul class="nav">
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Cadastrar</a>
									</li>
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Consultar</a>
									</li>
								</ul>
							</nav> 
					</li> 
					<li class="active"> 
						<a role="button" data-toggle="collapse" href="#collapseCliente" aria-expanded="false" aria-controls="collapseCliente">Clientes</a>
							<nav class="collapse" id="collapseCliente" aria-expanded="false" style="height: 1px;">
								<ul class="nav">
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Cadastrar</a>
									</li>
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Consultar</a>
									</li>
								</ul>
							</nav>
					</li> 
					<li> 
						<a role="button" data-toggle="collapse" href="#collapseProduto" aria-expanded="false" aria-controls="collapseProduto">Produtos</a>
							<nav class="collapse" id="collapseProduto" aria-expanded="false" style="height: 1px;">
								<ul class="nav">
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Cadastrar</a>
									</li>
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Consultar</a>
									</li>
								</ul>
							</nav>
					</li> 
					<li> 
						<a role="button" data-toggle="collapse" href="#collapseCompra" aria-expanded="false" aria-controls="collapseCompra">Compras</a>
							<nav class="collapse" id="collapseCompra" aria-expanded="false" style="height: 1px;">
								<ul class="nav">
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Cadastrar</a>
									</li>
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Consultar</a>
									</li>
								</ul>
							</nav> 
					</li>
					<li>
						<a role="button" data-toggle="collapse" href="#collapseVenda" aria-expanded="false" aria-controls="collapseVenda">Vendas</a>
							<nav class="collapse" id="collapseVenda" aria-expanded="false" style="height: 1px;">
								<ul class="nav">
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Cadastrar</a>
									</li>
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Consultar</a>
									</li>
								</ul>
							</nav>
					</li>
					<li>
						<a role="button" data-toggle="collapse" href="#collapseRelatorio" aria-expanded="false" aria-controls="collapseRelatorio">Relatorios</a>
							<nav class="collapse" id="collapseRelatorio" aria-expanded="false" style="height: 1px;">
								<ul class="nav">
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Cadastrar</a>
									</li>
									<li>
										<a href=""><span class="glyphicon glyphicon-share-alt"></span>  Consultar</a>
									</li>
								</ul>
							</nav>
					</li>
				</ul> 
				<ul class="nav navbar-nav navbar-right navbar-collapse collapse"> 
					<li>
						<a href="">Cadastrar</a>
					</li> 
					<li class="active">
						<a href="">Consultar</a>
					</li> 
					<li>
						<a href="">Sair <span class="glyphicon glyphicon-log-out"></span></a>
					</li>
				</ul> 
			</nav> 
	</div> 
</header> -->

<!-- Modal Seleção -->
<div class="modal fade" tabindex="-1" role="dialog" id="modalSelecao">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
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

<!-- Modal Mensagem -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" id="modal">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
     <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Sistema</h4>
      </div>
      <div class="modal-body">
        <p><div id="msg"></div></p>
      </div>
    </div>
  </div>
</div>

<div class="container">
	<div class="row">
	 <div class="panel panel-default filterable">
            <div class="panel-heading">
                <h3 class="panel-title">Clientes</h3>
                <div class="pull-right">
                    <button class="btn btn-default btn-xs btn-filtro"><span class="glyphicon glyphicon-filter"></span>Filtro</button>
                </div>
            </div>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>RG</th>
						<th>Telefone</th>
						<th>Email</th>
						<th style="min-width:160px;">Ações</th>
					</tr>
					<tr id="tr-filters" class="filters" >
                        <th><input type="text" class="form-control" style="min-width:50px; max-width:100px;" placeholder="Id"></th>
                        <th><input type="text" class="form-control" placeholder="Nome"></th>
                        <th><input type="text" class="form-control" placeholder="CPF"></th>
                        <th><input type="text" class="form-control" placeholder="RG"></th>
                        <th><input type="text" class="form-control" placeholder="Telefone"></th>
						<th><input type="text" class="form-control" placeholder="Email"></th>			
                    </tr>
				</thead>
					<tbody class="table-hover">
						<c:forEach var="cliente" items="${clientes}">
							
								<tr id="${cliente.id}">
									<td>${cliente.id}</td>
									<td>${cliente.nome}</td>
									<td>${cliente.cpf}</td>
									<td>${cliente.rg}</td>
									<td>${cliente.telefone}</td>
									<td>${cliente.email}</td>
									<td>
										<a href="Controller?command=DetalharCliente&id=${cliente.id}" id="alterar" class="btn btn-warning">Alterar</a>
										<a id="selecaoCliente" value="${cliente.id}" class="btn btn-danger selecaoCliente">Excluir</a>
									</td>
								</tr>
								
						</c:forEach>
					</tbody>				
			</table>
		</div>
		</div>
	</div>
</div>

 	<script src="resource/js/jquery.min.js"></script>
 	<script src="resource/js/bootstrap.min.js"></script>
 	<script src="resource/js/filtroTabela.js"></script> 
 	<script src="resource/js/ajax.js"></script>
 	
</body>
</html>