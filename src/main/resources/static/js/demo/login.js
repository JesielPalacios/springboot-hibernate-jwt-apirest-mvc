async function iniciarSesion() {
  let datos = {};

  datos.email = document.getElementById('correoLogin').value;
  datos.password = document.getElementById('contrasenaLogin').value;

  console.log('datos', datos);
  const rawResponse = await fetch('api/login', {
    method: 'POST',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(datos),
  });

  const content = await rawResponse.text();

  console.log(content);

  if (content != 'FAIL') {
    window.localStorage.token = content;
    window.localStorage.email = datos.email;
    window.location.href = 'usuarios.html';
  } else
    alert('Las credenciales son incorrectas. Por favor intente nuevamente.');
}
