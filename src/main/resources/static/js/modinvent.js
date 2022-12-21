function validaradd(){
	var id, idprod, fechain, fechafi, metodo, valor, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var id = document.getElementById("id").value;
	var idprod = document.getElementById("idprod").value;
	var fechain = document.getElementById("fechain").value;
	var fechafi = document.getElementById("fechafi").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(id == 0){
		Swal.fire("Escribe el ID del inventario");
		return false;
	}
    if(isNaN(id)){
		Swal.fire("El ID debe ser numérico");
		return false;
	}
    if(idprod == 0){
		Swal.fire("Escribe el ID del producto");
		return false;
	}
	if(isNaN(idprod)){
		Swal.fire("El ID del producto debe ser numérico");
		return false;
	}
    if(fechain == 0){
		Swal.fire("Selecciona la fecha de inicio");
		return false;
	}
	if(fechafi == 0){
		Swal.fire("Selecciona la fecha de fin");
		return false;
	}	
	Swal.fire({
		icon: 'success',
		title: 'Inventario agregado correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="inventario.html";
	  }, 2500);
}

function validarmod(){
	var id, idprod, fechain, fechafi, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var id = document.getElementById("id").value;
	var idprod = document.getElementById("idprod").value;
	var fechain = document.getElementById("fechain").value;
	var fechafi = document.getElementById("fechafi").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(id == 0){
		Swal.fire("Escribe el ID del inventario");
		return false;
	}
    if(isNaN(id)){
		Swal.fire("El ID debe ser numérico");
		return false;
	}
    if(idprod == 0){
		Swal.fire("Escribe el ID del producto");
		return false;
	}
	if(isNaN(idprod)){
		Swal.fire("El ID del producto debe ser numérico");
		return false;
	}
    if(fechain == 0){
		Swal.fire("Selecciona la fecha de inicio");
		return false;
	}
	if(fechafi == 0){
		Swal.fire("Selecciona la fecha de fin");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Inventario modificado correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="inventario.html";
	  }, 2500);
}