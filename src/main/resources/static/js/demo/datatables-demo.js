// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios()

  $('#dataTable').DataTable();
});

async function cargarUsuarios() {
    const rawResponse = await fetch('usuarios')
    const usuarios = await rawResponse.json()

    console.log(usuarios);

    let listadoHtml = ''

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
      
              <a href="#" class="btn btn-danger btn-circle btn-sm">
                  <i class="fas fa-trash"></i>
              </a>
          </td>
        </tr>
        `

        litstadoHtml += usuarioHtml
    }

  document.querySelector('#tablaUsuarios tbody').outerHTML = usuarioHtml
}

function crearUsuario() {
  (async () => {
    const rawResponse = await fetch('https://httpbin.org/post', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({a: 1, b: 'Textual content'})
    });
    const content = await rawResponse.json();

    console.log(content);
  })();
}