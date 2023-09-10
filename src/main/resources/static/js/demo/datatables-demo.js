// Call the dataTables jQuery plugin
$(document).ready(function () {
  verificarToken();
});

function verificarToken() {
  if (window.localStorage.token != undefined) {
    cargarUsuarios();
    actualizarEmailDelUsuario();

    $('#dataTable').DataTable();
  } else {
    window.location.href = 'login.html';
  }
}

function cerrarSesion() {
  // window.localStorage.token = undefined;
  // window.localStorage.email = undefined;}
  window.localStorage.removeItem('token');
  window.localStorage.removeItem('email');
  // window.location.href = 'login.html';
}

function actualizarEmailDelUsuario() {
  if (window.localStorage.email) {
    document.getElementById('currentUserEmail').outerHTML =
      window.localStorage.email;
  } else {
    document.getElementById('currentUserEmail').outerHTML = 'Invitado';
  }
}

async function cargarUsuarios() {
  const rawResponse = await fetch('api/usuarios', {
    headers: {
      Authorization: window.localStorage.token,
    },
  });

  const usuarios = await rawResponse.json();

  let listadoHtml = '';

  for (let usuario of usuarios) {
    let usuarioHtml = `
          <tr>
          <td>${usuario.id}</td>
          <td>${usuario.nombre + ' ' + usuario.apellido}</td>
          <td>${usuario.email}</td>
          <td>${usuario.telefono}</td>
          <td>
              <a href="#" class="btn btn-info btn-circle btn-sm">
                  <i class="fas fa-pencil-fill"></i>
              </a>
      
              <a href="#" onClick="eliminarUsuario('${
                usuario.id
              }')" class="btn btn-danger btn-circle btn-sm">
                  <i class="fas fa-trash"></i>
              </a>
          </td>
        </tr>
        `;

    listadoHtml += usuarioHtml;
  }

  document.querySelector('#tablaUsuarios tbody').outerHTML = listadoHtml;
}

async function eliminarUsuario(idUsuario) {
  if (!confirm('¿Desea eliminar este usuario?')) {
    return;
  }
  await fetch('api/usuario/' + idUsuario, {
    method: 'DELETE',
    headers: {
      Authorization: window.localStorage.token,
    },
  });

  cargarUsuarios();
  //location.reload()
}

// function crearUsuario() {
//   (async () => {
//     const rawResponse = await fetch('https://httpbin.org/post', {
//       method: 'POST',
//       headers: {
//         Accept: 'application/json',
//         'Content-Type': 'application/json',
//         Authorization: window.localStorage.token,
//       },
//       body: JSON.stringify({ a: 1, b: 'Textual content' }),
//     });
//     const content = await rawResponse.json();

//     console.log(content);
//   })();
// }
