function validaradd(){
	var codigo, prinom, segnom, priape, segape, correo, telefono, direccion, ciudad, rol, tdoc, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var codigo = document.getElementById("codigo").value;
	var prinom = document.getElementById("prinom").value;
	var segnom = document.getElementById("segnom").value;
	var priape = document.getElementById("priape").value;
	var segape = document.getElementById("segape").value;
	var correo = document.getElementById("correo").value;
	var telefono = document.getElementById("telefono").value;
    var direccion = document.getElementById("direccion").value;
    var ciudad = document.getElementById("ciudad").value;
    var rol = document.getElementById("rol").value;
    var tdoc = document.getElementById("tdoc").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(codigo == 0){
		Swal.fire("Escribe el ID del usuario");
		return false;
	}
    if(isNaN(codigo)){
		Swal.fire("El ID debe ser numérico");
		return false;
	}
    if(prinom == 0){
		Swal.fire("Escribe el primer nombre");
		return false;
	}
	if(!expresion3.test(prinom)){
		Swal.fire("El primer nombre no debe contener números");
		return false;
	}
	if(segnom == 0){
		Swal.fire("Escribe el segundo nombre");
		return false;
	}
	if(!expresion3.test(segnom)){
		Swal.fire("El segundo nombre no debe contener números");
		return false;
	}
	if(priape == 0){
		Swal.fire("Escribe el primer apellido");
		return false;
	}
	if(!expresion3.test(priape)){
		Swal.fire("El primer apellido no debe contener números");
		return false;
	}
	if(segape == 0){
		Swal.fire("Escribe el segundo apellido");
		return false;
	}
	if(!expresion3.test(segape)){
		Swal.fire("El segundo apellido no debe contener números");
		return false;
	}
    if(correo == 0){
		Swal.fire("Escribe el correo");
		return false;
	}
	if(telefono == 0){
		Swal.fire("Escribe el teléfono");
		return false;
	}
	if(isNaN(telefono)){
		Swal.fire("El telefono debe ser numérico");
		return false;
	}
	if(direccion == 0){
		Swal.fire("Escribe la dirección");
		return false;
	}
	if(ciudad == 0){
		Swal.fire("Escribe la ciudad");
		return false;
	}
	if(!expresion3.test(ciudad)){
		Swal.fire("La ciudad no debe contener números");
		return false;
	}
	if(rol == "Selecciona tu rol"){
		Swal.fire("Selecciona el rol");
		return false;
	}
	if(tdoc == 0){
		Swal.fire("Escribe el tipo de documento");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Usuario agregado correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="usuarios.html";
	  }, 2500);
}

function validarmod(){
	var codigo, prinom, segnom, priape, segape, correo, telefono, direccion, ciudad, rol, tdoc, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var codigo = document.getElementById("codigo").value;
	var prinom = document.getElementById("prinom").value;
	var segnom = document.getElementById("segnom").value;
	var priape = document.getElementById("priape").value;
	var segape = document.getElementById("segape").value;
	var correo = document.getElementById("correo").value;
	var telefono = document.getElementById("telefono").value;
    var direccion = document.getElementById("direccion").value;
    var ciudad = document.getElementById("ciudad").value;
    var rol = document.getElementById("rol").value;
    var tdoc = document.getElementById("tdoc").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(codigo == 0){
		Swal.fire("Escribe el ID del usuario");
		return false;
	}
    if(isNaN(codigo)){
		Swal.fire("El ID debe ser numérico");
		return false;
	}
    if(prinom == 0){
		Swal.fire("Escribe el primer nombre");
		return false;
	}
	if(!expresion3.test(prinom)){
		Swal.fire("El primer nombre no debe contener números");
		return false;
	}
	if(segnom == 0){
		Swal.fire("Escribe el segundo nombre");
		return false;
	}
	if(!expresion3.test(segnom)){
		Swal.fire("El segundo nombre no debe contener números");
		return false;
	}
	if(priape == 0){
		Swal.fire("Escribe el primer apellido");
		return false;
	}
	if(!expresion3.test(priape)){
		Swal.fire("El primer apellido no debe contener números");
		return false;
	}
	if(segape == 0){
		Swal.fire("Escribe el segundo apellido");
		return false;
	}
	if(!expresion3.test(segape)){
		Swal.fire("El segundo apellido no debe contener números");
		return false;
	}
    if(correo == 0){
		Swal.fire("Escribe el correo");
		return false;
	}
	if(telefono == 0){
		Swal.fire("Escribe el teléfono");
		return false;
	}
	if(isNaN(telefono)){
		Swal.fire("El telefono debe ser numérico");
		return false;
	}
	if(direccion == 0){
		Swal.fire("Escribe la dirección");
		return false;
	}
	if(ciudad == 0){
		Swal.fire("Escribe la ciudad");
		return false;
	}
	if(!expresion3.test(ciudad)){
		Swal.fire("La ciudad no debe contener números");
		return false;
	}
	if(rol == "Selecciona tu rol"){
		Swal.fire("Selecciona el rol");
		return false;
	}
	if(tdoc == 0){
		Swal.fire("Escribe el tipo de documento");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Usuario modificado correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="usuarios.html";
	  }, 2500);
}

