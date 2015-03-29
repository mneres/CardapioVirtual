function editUser()
{
	var email = $("#email").val();
	var name = $("#name").val();
	var phone = $("#phone").val();
	var secondPhone = $("#secondPhone").val();
	var dateBirth = $("#dateBirth").val();
	var cpf = $("#cpf").val();
	
	var street = $("#street").val();
	var ad_number = $("#ad_number").val();
	var neighborhood = $("#neighborhood").val();
	var code = $("#code").val();
	var city = $("#city").val();
	
	//if(idMenu.lenght > 0 && description.lenght > 0 && 
		//ingredients.lenght > 0 && price.lenght > 0){
			$.ajax({
		        type: 'POST',
		        url: "edit", 
		        data: {email: email, name: name, phone: phone, secondPhone: secondPhone,
		        	dateBirth: dateBirth, cpf: cpf, street: street,
		        	ad_number: ad_number, neighborhood: neighborhood, code: code,
		        	city: city},
		        dataType: "json",
		        success : function(data) {
		        	$("#msg").text("Cadastrado com sucesso!");
		        },
		        error : function(data){
		        	$("#msg").text("Erro ao Cadastrar");
		        }
			});
	//} else {
		//$("#msg").text("Preencher todos os Campos");
	//}
}