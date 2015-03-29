function addEvaluation(idUser, idProd){
	
	var comment = $("#comment").val();
	var eva  = $("#evaluation").val();
	
	
	console.log('idUser:' +  idUser + 'idProd: ' + idProd + 'comment:' + comment + 'evaluation:' + eva);
	//if(name.lenght > 0){
			$.ajax({
		        type: 'POST',
		        url: "../evaluation/addEvaluation", 
		        data: {idUser: idUser, idProd: idProd, comment: comment, evaluation: eva},
		        dataType: "json",
		        success : function(data) {
		        	$("#msg").text("Cadastrado com sucesso!");
		        },
		        error : function(data){
		        	$("#msg").text("Erro ao Cadastrar");
		        }
			});
	/*} else {
		$("#msg").text("Preencher todos os Campos");
	}*/
}