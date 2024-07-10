document.addEventListener("DOMContentLoaded", function () {
    var headerHtml = `
        <nav class="navbar navbar-dark bg-dark" aria-label="First navbar example">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarsExample01" aria-controls="navbarsExample01" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarsExample01">
                    <ul class="navbar-nav me-auto mb-2">
                      <li class="nav-item">
                            <a class="nav-link" href="/index.html">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/usuarios.html">Usuários</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/titulos.html">Títulos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/equipes.html">Equipes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/campeonatos.html">Campeonatos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/historico.html">Histórico</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/cups.html">Cups</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="/amistoso.html">Amistoso</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    `;
    document.getElementById('header').innerHTML = headerHtml;
});