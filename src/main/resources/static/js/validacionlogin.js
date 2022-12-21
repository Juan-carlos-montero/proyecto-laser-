function validar(){
	var name, correo, user, contra, phone, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var name = document.getElementById("name").value;
	var correo = document.getElementById("correo").value;
	var user = document.getElementById("user").value;
	var contra = document.getElementById("contra").value;
	var phone = document.getElementById("phone").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/

	if(name == 0){
		Swal.fire("Escribe tu nombre");
		return false;
	}
	if(name.length>50){
		Swal.fire("El nombre es muy largo");
		return false;
	}
	if(correo == 0){
		Swal.fire("Escribe tu correo");
		return false;
	}
	if(!expresion1.test(correo)){
		Swal.fire("EL correo no es válido");
		return false;
	}
	if(phone == 0){
		Swal.fire("Escribe un teléfono");
		return false;
	}
	if(isNaN(phone)){
		Swal.fire("El teléfono debe ser numérico");
		return false;
	}
	if(!expresion2.test(phone)){
		Swal.fire("El teléfono debe contener entre 7 y 10 números")
		return false;
	}
	
	if(user == 0){
		Swal.fire("Escribe un nombre de usuario");
		return false;
	}
	if(contra == 0){
		Swal.fire("Escribe una contraseña");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Usuario registrado correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="IniciarSesion.html";
	  }, 2500);
}

function validarlog(){
	var correo1, contra, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var correo1 = document.getElementById("inputEmail").value;
	var contra1 = document.getElementById("inputPassword").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/

	if(correo1 == 0){
		Swal.fire("Escribe tu correo");
		return false;
	}
	if(!expresion1.test(correo1)){
		Swal.fire("EL correo no es válido");
		return false;
	}
	if(contra1 == 0){
		Swal.fire("Escribe una contraseña");
		return false;
	}	
}