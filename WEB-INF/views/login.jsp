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

<title>Login</title>
</head>

<body>

<c:import url="menuLogin.jsp"></c:import>

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

	<div class=row>
	
		<div class="col-md-3"></div>
		
		<div class="col-md-6">
		
			<form id="formLogin">
				
				<fieldset>
	
					<legend class="scheduler-border">Acesso ao Sistema</legend>
				
					<div class="form-group col-md-12">
						<label for="nome">Usuario:</label>
						<input type="text" name="usuario" class="form-control" id="usuario" placeholder="Usuario" required>
					</div>
					
					<div class="form-group col-md-12">
						<label for="rg">Senha:</label>
						<input type="password" name="senha" class="form-control" id="senha" placeholder="Senha" required>
					</div>
					
					<div class="form-group col-md-12">
						<input type="submit" class="btn btn-primary" value="Entrar"/>
					</div>
				
				</fieldset>
			</form>
		</div>
		
		<div class="col-md-3"></div>
	
	</div>

</div>
 	<script src="resource/js/jquery.min.js"></script>
 	<script src="resource/js/bootstrap.min.js"></script>
 	<script src="resource/js/ajax2.js"></script>
 	
</body>
</html>