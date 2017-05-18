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

<title>Cadastro de Produto</title>
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
        <p><div id="msg"></div></p>
      </div>
    </div>
  </div>
</div>

<div class=container>

<h3>Menu</h3>

	<a href="views/produto/cadastroProduto">Cadastro de Produto</a> </br>
	<a href="views/produto/buscarProduto">Alterar Produto</a> </br>
	<a href="Controller?command=ListarProdutos">Listar Produto</a> </br>
	<a href="Controller?command=GerarNotaFiscal">Nota Fiscal</a> </br>

 	<script src="resource/js/jquery.min.js"></script>
 	<script src="resource/js/bootstrap.min.js"></script>
 	<script src="resource/js/ajax.js"></script>
 	
 </div>
 	
</body>
</html>