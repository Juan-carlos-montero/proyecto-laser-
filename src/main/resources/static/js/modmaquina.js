function validaradd(){
	var codigo, nombre, precio, cantidad, imagen, categoria, dispon, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var codigo = document.getElementById("codigo").value;
	var nombre = document.getElementById("nombre").value;
	var precio = document.getElementById("precio").value;
	var cantidad = document.getElementById("cantidad").value;
    var imagen = document.getElementById("imagen").value;
    var categoria = document.getElementById("categoria").value;
    var dispon = document.getElementById("dispon").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(codigo == 0){
		Swal.fire("Escribe el ID de la máquina");
		return false;
	}
    if(isNaN(codigo)){
		Swal.fire("El ID debe ser numérico");
		return false;
	}
    if(nombre == 0){
		Swal.fire("Escribe el nombre de la máquina");
		return false;
	}
    if(precio == 0){
		Swal.fire("Escribe el precio de venta");
		return false;
	}
	if(isNaN(precio)){
		Swal.fire("El precio debe ser numérico");
		return false;
	}
	if(cantidad == 0){
		Swal.fire("Escribe la cantidad disponible");
		return false;
	}
	if(isNaN(cantidad)){
		Swal.fire("La cantidad debe ser numérico");
		return false;
	}
	if(imagen == 0){
		Swal.fire("Adjunta la imagen de la máquina");
		return false;
	}
	if(categoria == 0){
		Swal.fire("Escribe la categoría");
		return false;
	}
    if(dispon == 0){
		Swal.fire("Escribe la disponibilidad");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Máquina agregada correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="Maquinarias.html";
	  }, 2500);
}

function validarmod(){
	var codigo, nombre, precio, cantidad, imagen, categoria, dispon, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var codigo = document.getElementById("codigo").value;
	var nombre = document.getElementById("nombre").value;
	var precio = document.getElementById("precio").value;
	var cantidad = document.getElementById("cantidad").value;
    var imagen = document.getElementById("imagen").value;
    var categoria = document.getElementById("categoria").value;
    var dispon = document.getElementById("dispon").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(codigo == 0){
		Swal.fire("Escribe el ID de la máquina");
		return false;
	}
    if(isNaN(codigo)){
		Swal.fire("El ID debe ser numérico");
		return false;
	}
    if(nombre == 0){
		Swal.fire("Escribe el nombre de la máquina");
		return false;
	}
    if(precio == 0){
		Swal.fire("Escribe el precio de venta");
		return false;
	}
	if(isNaN(precio)){
		Swal.fire("El precio debe ser numérico");
		return false;
	}
	if(cantidad == 0){
		Swal.fire("Escribe la cantidad disponible");
		return false;
	}
	if(isNaN(cantidad)){
		Swal.fire("La cantidad debe ser numérico");
		return false;
	}
	if(imagen == 0){
		Swal.fire("Adjunta la imagen de la máquina");
		return false;
	}
	if(categoria == 0){
		Swal.fire("Escribe la categoría");
		return false;
	}
    if(dispon == 0){
		Swal.fire("Escribe la disponibilidad");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Máquina modificada correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="Maquinarias.html";
	  }, 2500);
}