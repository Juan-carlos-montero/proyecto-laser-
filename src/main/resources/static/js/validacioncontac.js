function validar(){
	var name, correo, asunto, mensaje, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var name = document.getElementById("name").value;
	var correo = document.getElementById("correo").value;
	var asunto = document.getElementById("asunto").value;
	var mensaje = document.getElementById("mensaje").value;
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
		Swal.fire("El correo no es válido");
		return false;
	}
	
	if(asunto == 0){
		Swal.fire("Escribe un asunto");
		return false;
	}
	if(mensaje == 0){
		Swal.fire("Escribe un mensaje");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Formulario enviado correctamente',
		showConfirmButton: false,
		timer: 3000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="Contactos.html";
	  }, 3500);

}
