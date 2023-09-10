async function registrarUsuario() {
  let datos = {};

  let verificarContrasena = '';

  datos.nombre = document.getElementById('nombre').value;
  datos.apellido = document.getElementById('apellido').value;
  datos.email = document.getElementById('correo').value;
  datos.telefono = document.getElementById('telefono').value;
  datos.password = document.getElementById('contrasena').value;
  verificarContrasena = document.getElementById('repcontrasena').value;

  if (verificarContrasena != datos.password) {
    alert('La contraseña de verificación no es la misma.');
    return;
  }

  const rawResponse = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(datos),
  });

  if (rawResponse.ok) {
    alert('La cuenta fue creada con éxito.');
    window.location.href = 'login.html';
  }
}
