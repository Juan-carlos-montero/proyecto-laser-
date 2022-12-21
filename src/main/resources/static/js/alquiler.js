function validar(){
	var idetificacion, direccion, ciudad, metodo, inicio, fin, expresion;

	/*Devuelve una referencia al elemento por su ID.*/
	var idetificacion = document.getElementById("idetificacion").value;
	var direccion = document.getElementById("direccion").value;
	var ciudad = document.getElementById("ciudad").value;
	var metodo = document.getElementById("metodo").value;
    var inicio = document.getElementById("inicio").value;
    var fin = document.getElementById("fin").value;
	expresion1= /\w+@\w+\.+[a-z]/;/*expresiones regulares*//*texto123@gmail.com*/
	expresion2= /^\d{7,10}$/; /*expresiones regulares*/
	expresion3= /\w+\D/;

    if(idetificacion == 0){
		Swal.fire("Escribe tu número de idetificación");
		return false;
	}
    if(isNaN(idetificacion)){
		Swal.fire("La identificación debe ser numérica");
		return false;
	}
    if(direccion == 0){
		Swal.fire("Escribe una dirección");
		return false;
	}
    if(ciudad == 0){
		Swal.fire("Escribe una ciudad");
		return false;
	}
	if(!expresion3.test(ciudad)){
		Swal.fire("La ciudad no debe contener números");
		return false;
	}
    if(metodo == 0){
		Swal.fire("Escribe un método de pago");
		return false;
	}
	if(!expresion3.test(metodo)){
		Swal.fire("El método de pago no debe contener números");
		return false;
	}
    if(inicio == 0){
		Swal.fire("Escribe una fecha de inicio");
		return false;
	}
    if(fin == 0){
		Swal.fire("Escribe una fecha de fin");
		return false;
	}
	Swal.fire({
		icon: 'success',
		title: 'Alquiler registrado correctamente',
		showConfirmButton: false,
		timer: 2000,
		timerProgressBar: true,
	  })
	  setTimeout(() => {
		window.location.href="productos.html";
	  }, 2500);
}