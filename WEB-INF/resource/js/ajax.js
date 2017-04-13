/**
 * @Daniel
 */
$(document).ready(function() {
	
	// Metodos modulo de cliente

	var idx;
	var id;
	var endereco;

	$('#formCadastroCliente').submit(function(event) {
		event.preventDefault();
		var dados = $(this).serialize();

		$.ajax({
			type : "POST",
			url : 'Controller?command=CadastrarCliente',
			data : dados,
			success : function(result) {
				$('#msg').html("Cliente cadastrado com sucesso!");
				$('#modal').modal('show');

				$('#nome').val("");
				$('#rg').val("");
				$('#cpf').val("");
				$('#telefone').val("");
				$('#email').val("");
			},
			error : function(result) {
				$('#msg').html("Nao foi possivel realizar a operacao!");
				$('#modal').modal('show');
			}
		});

	});

	$(document).on("click", ".selecaoCliente", function() {

		idx = $(this).index(".selecaoCliente");

		id = $(".selecaoCliente:eq(" + idx + ")").attr("value");

		$('#modalSelecao').modal('show');

	});

	$('#excluirCliente').click(function(event) {

		$.ajax({
			type : "POST",
			url : 'Controller?command=ExcluirCliente&id=' + id,
			success : function(result) {
				$('#modalSelecao').modal('hide');
				$('#msg').html("Cliente excluido com sucesso!");
				$('#modal').modal('show');
				$('#'+id).remove();
			},
			error : function(result) {
				$('#modalSelecao').modal('hide');
				$('#msg').html("Nao foi possivel realizar a operacao!");
				$('#modal').modal('show');
			}
		});

	});
	
	$('#formAlterarCliente').submit(function(event) {
		event.preventDefault();
		var dados = $(this).serialize();

		$.ajax({
			type : "POST",
			url : 'Controller?command=AlterarCliente',
			data : dados,
			success : function(result) {
				$('#msg').html("Cliente alterado com sucesso!");
				$('#modal').modal('show');
			},
			error : function(result) {
				$('#msg').html("Nao foi possivel realizar a operacao!");
				$('#modal').modal('show');
			}
		});

	});
	

	// Metodos de login

	$('#formLogin').submit(function(event) {
		event.preventDefault();
		var dados = $(this).serialize();

		$.ajax({
			type : "POST",
			url : 'Controller?command=UsuarioLogin&metodo=valida',
			data : dados,
			success : function(result) {
				$('#msg').html("Bem vindo ao sistema!");
				$('#modal').modal('show');

				$.ajax({
					type : "POST",
					url : 'Controller?command=UsuarioLogin&metodo=redireciona'
				});
			},
			error : function(result) {
				$('#msg').html("Usuario ou senha invalidos!");
				$('#modal').modal('show');
			}
		});

	});
});