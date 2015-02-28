function createNewProduct()
{
	var idMenu = $("#menu").val();
	var description = $("#description").val();
	var ingredients = $("#ingredients").val();
	var price = $("#price").val();
	
	if(idMenu.lenght > 0 && description.lenght > 0 && 
		ingredients.lenght > 0 && price.lenght > 0){
			$.ajax({
		        type: 'POST',
		        url: "../menu/addProd", 
		        data: {menu: idMenu, description: description, 
		        	ingredients: ingredients, price: price},
		        dataType: "json",
		        success : function(data) {
		        	$("#msg").text("Cadastrado com sucesso!");
		        },
		        error : function(data){
		        	$("#msg").text("Erro ao Cadastrar");
		        }
			});
	} else {
		$("#msg").text("Preencher todos os Campos");
	}
}

function editProduct(){
	
}

function removeProduct(idMenu, idProd){
	if (confirm("Deseja Remover este produto?") == true) {
		$.ajax({
	        type: 'POST',
	        url: "../menu/removeProd", 
	        data: {idMenu: idMenu, idProd: idProd},
	        dataType: "json",
	        success : function(data) {
	        	location.reload();
	        },
	        error : function(data){
	        	console.log(data);
	        }
		});
    } else {
    	
    }
}