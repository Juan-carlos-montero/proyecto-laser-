function validarcon(){
	var identificacion, correo, contraseña, repetir, codigo, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var identificacion = document.getElementById("identificacion").value;
	var correo = document.getElementById("correo").value;
	var contraseña = document.getElementById("contraseña").value;
	var repetir = document.getElementById("repetir").value;
	var codigo = document.getElementById("codigo").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/


    if(identificacion == 0){
		Swal.fire("Escribe tu número de identificación");
		return false;
	}
    if(isNaN(identificacion)){
		Swal.fire("El número de identificación debe ser numérico");
		return false;
	}
    if(correo == 0){
		Swal.fire("Escribe tu correo");
		return false;
	}
    if(contraseña == 0){
		Swal.fire("Escribe la nueva contraseña");
		return false;
	}
    if(repetir == 0){
		Swal.fire("Repite la contraseña");
		return false;
	}
    if(repetir != contraseña){
		Swal.fire("Las contraseñas no coinciden");
		return false;
	}
    if(codigo == 0){
		Swal.fire("Escribe el código de verificación");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Contraseña modificada correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="IniciarSesion.html";
	  }, 2500);
}

function validar(){
    Swal.fire({
		icon: 'success',
		title: 'El código de verificación se envió',
		showConfirmButton: false,
		timer: 3000,
        timerProgressBar: true
	  })
	
}