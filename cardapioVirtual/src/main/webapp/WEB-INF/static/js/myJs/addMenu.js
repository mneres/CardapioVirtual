function addNewMenu(franchise){
	var name = $("#name").val();
	
	//if(name.lenght > 0){
			$.ajax({
		        type: 'POST',
		        url: "../menu/addMenu", 
		        data: {name: name, idFranchise: franchise},
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

function editMenu(franchise){
	
}