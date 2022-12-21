function validaradd(){
	var id, idcliente, fecha, hora, metodo, valor, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var id = document.getElementById("id").value;
	var idcliente = document.getElementById("idcliente").value;
	var fecha = document.getElementById("fecha").value;
	var hora = document.getElementById("hora").value;
    var metodo = document.getElementById("metodo").value;
    var valor = document.getElementById("valor").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(id == 0){
		Swal.fire("Escribe el ID de la máquina");
		return false;
	}
    if(isNaN(id)){
		Swal.fire("El ID debe ser numérico");
		return false;
	}
    if(idcliente == 0){
		Swal.fire("Escribe el ID del cliente");
		return false;
	}
	if(isNaN(idcliente)){
		Swal.fire("El ID del cliente debe ser numérico");
		return false;
	}
    if(fecha == 0){
		Swal.fire("Selecciona la fecha de la venta");
		return false;
	}
	if(hora == 0){
		Swal.fire("Selecciona la hora de la venta");
		return false;
	}
	if(metodo == 0){
		Swal.fire("Escribe el método de pago");
		return false;
	}
	if(!expresion3.test(metodo)){
		Swal.fire("El método de pago no debe contener números");
		return false;
	}
    if(valor == 0){
		Swal.fire("Escribe el valor de la venta");
		return false;
	}
	if(isNaN(valor)){
		Swal.fire("El valor debe ser numérico");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Venta agregada correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="ventas.html";
	  }, 2500);
}

function validarmod(){
	var id, idcliente, fecha, hora, metodo, valor, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var id = document.getElementById("id").value;
	var idcliente = document.getElementById("idcliente").value;
	var fecha = document.getElementById("fecha").value;
	var hora = document.getElementById("hora").value;
    var metodo = document.getElementById("metodo").value;
    var valor = document.getElementById("valor").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(id == 0){
		Swal.fire("Escribe el ID de la máquina");
		return false;
	}
    if(isNaN(id)){
		Swal.fire("El ID debe ser numérico");
		return false;
	}
    if(idcliente == 0){
		Swal.fire("Escribe el ID del cliente");
		return false;
	}
	if(isNaN(idcliente)){
		Swal.fire("El ID del cliente debe ser numérico");
		return false;
	}
    if(fecha == 0){
		Swal.fire("Selecciona la fecha de la venta");
		return false;
	}
	if(hora == 0){
		Swal.fire("Selecciona la hora de la venta");
		return false;
	}
	if(metodo == 0){
		Swal.fire("Escribe el método de pago");
		return false;
	}
	if(!expresion3.test(metodo)){
		Swal.fire("El método de pago no debe contener números");
		return false;
	}
    if(valor == 0){
		Swal.fire("Escribe el valor de la venta");
		return false;
	}
	if(isNaN(valor)){
		Swal.fire("El valor debe ser numérico");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Venta modificada correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="ventas.html";
	  }, 2500);
}