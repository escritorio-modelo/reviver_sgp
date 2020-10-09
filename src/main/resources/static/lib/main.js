'use strict';

function searchChamada() {
    let searchInput = document.querySelector('#input-search');

    if(searchInput) {
        var searchString = '';
        var page = 0;
        requestChamadaService(searchString, page);

        searchInput.addEventListener('input', () => {
            searchString = searchInput.value;
            requestChamadaService(searchString, 0);
        });

        function requestChamadaService(searchString, page) {
            let url = 'http://localhost:8080/chamadas/?titulo=' + searchString + '&pagina=' + page;

            let xhr = new XMLHttpRequest();
            xhr.open('GET', url, true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200)
                        updateTable(JSON.parse(xhr.responseText));

                        let pageLink = document.querySelectorAll('.pagination-link');
                        for (let i = 0; i < pageLink.length; i++) {
                            pageLink[i].addEventListener('click', () => {
                                page = i
                                requestChamadaService(searchString, page);
                            })
                        }
                    }
                }
                xhr.send();
        }

        function updateTable(data) {
            let listaChamadas = data.content;
            let tbody = document.querySelector('#table-content');
            let paginationList = document.querySelector('.pagination-list');
            var urlId = '';
            tbody.innerHTML = '';
            paginationList.innerHTML = '';

            if (listaChamadas.length  == 0) {
                tbody.innerHTML = `<p>Nada encontrado.</p>`
            } else {
                listaChamadas.map(chamada => {
                    urlId = `/chamadas/${chamada.id}`;
                    let row = `<tr>
                        <td><a href="${urlId}" class="has-text-weight-medium">${chamada.titulo}</a></td>
                        <td><span class="${chamada.status !== 'FECHADO' ? 'tag is-spaced is-rounded is-primary' : 'tag is-spaced is-rounded is-black'}">${chamada.status}</span></td>
                        <td><strong>${chamada.dataInicio}</strong> até <strong>${chamada.dataTermino}</strong>
                        <td>41/50</td>
                        <td><a href="${urlId}" class="has-text-weight-medium">Acessar chamada</a></td>
                    </tr>`
                    tbody.innerHTML += row;
                })

                for(let i = 0; i < data.totalPages; i++) {
                    let pageButton = `
                        <li><a class="${data.pageable.pageNumber == i ?  'pagination-link is-current' : 'pagination-link'}" aria-label="Página 1" aria-current="page">${i}</a></li>
                    `;
                    paginationList.innerHTML += pageButton;
                }
            }
        }
    }
}

function loadDOM() {
    console.log('Hello Bulma!');

    document.addEventListener('DOMContentLoaded', function () {
      var notification = document.querySelector('[data-notification]');

      if (notification) {
        var notificationbody = document.querySelector('.column .notification').parentNode;
        console.log(notificationbody);

        setTimeout(function () {
          notificationbody.parentNode.removeChild(notificationbody);
        }, 5000);
      }
    });
}

function detailsOption() {
    let botaoOpcao = document.querySelector('.detalhes-opcoes-botao');
    if (botaoOpcao) {
        botaoOpcao.addEventListener('click', function () {
          var bodyOptions = document.querySelector('.detalhes-opcoes-body');
          bodyOptions.style.display == 'block' ? bodyOptions.style.display = 'none' : bodyOptions.style.display = 'block';
        });
    }
}

function main() {
    loadDOM();
    searchChamada();
    detailsOption();
}

main();