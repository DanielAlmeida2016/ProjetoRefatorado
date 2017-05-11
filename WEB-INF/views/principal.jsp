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

<title>Menu Principal</title>
</head>

<body>

<c:import url="menuPrincipal.jsp"></c:import>

<div class=container>

	 <div class=row>
		
			<div class="col-md-12 col-xs-6">
				<div class="col-md-2"></div>
				<div class="col-md-1"></div>
				<div class="col-md-2" style="margin-bottom:20px;"><a href="" class="btn btn-primary btn-lg" style="height:100px; width:100%">Usuarios</a></div>
				<div class="col-md-2" style="margin-bottom:20px;"><a href="Controller?command=ListarClientes" class="btn btn-primary btn-lg" style="height:100px; width:100%">Clientes</a></div>
				<div class="col-md-2" style="margin-bottom:20px;"><a href="" class="btn btn-primary btn-lg" style="height:100px; width:100%">Produtos</a></div>
			</div>	
		
			<div class="col-md-12 col-xs-6">
				<div class="col-md-2"></div>
				<div class="col-md-1"></div>
				<div class="col-md-2" style="margin-bottom:20px;"><a href="" class="btn btn-primary btn-lg" style="height:100px; width:100%">Compras</a></div>
				<div class="col-md-2" style="margin-bottom:20px;"><a href="" class="btn btn-primary btn-lg" style="height:100px; width:100%">Vendas</a></div>
				<div class="col-md-2" style="margin-bottom:20px;"><a href="" class="btn btn-primary btn-lg" style="height:100px; width:100%">Relatorios</a></div>
			</div>
		</div>
	
	</div>

 	<script src="resource/js/jquery.min.js"></script>
 	<script src="resource/js/bootstrap.min.js"></script>

</body>
</html>