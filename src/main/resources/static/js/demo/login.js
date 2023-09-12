async function iniciarSesion() {
  let datos = {};

  datos.email = document.getElementById('correoLogin').value;
  datos.password = document.getElementById('contrasenaLogin').value;

  console.log('datos', datos);
  const rawResponse = await fetch('api/inicio-sesion', {
    method: 'POST',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(datos),
  });
  
  console.log('rawResponse', rawResponse)
  const content = await rawResponse.text();

  console.log(content);

  if (content != 'FAIL') {
    window.localStorage.token = content;
    window.localStorage.email = datos.email;
    window.location.href = 'index.html';
  } else
    alert('Las credenciales son incorrectas. Por favor intente nuevamente.');
}
