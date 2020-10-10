'use strict';

function searchChamada() {
    let searchInput = document.querySelector('#input-search');
    if(searchInput) {
        let searchString = '';
        let tbody = document.querySelector('#table-content');
        let pageNext = document.querySelector('.pagination-next');
        let pageBack = document.querySelector('.pagination-previous');

        requestService('chamadas', searchString, 0).then(data => {
            let { pageable, totalPages } = data;
            updateTable(data, tbody);

            pageNext.addEventListener('click', () => {
                    if (pageable.pageNumber < totalPages-1){
                        requestService('chamadas', searchString, pageable.pageNumber+=1, tbody, pageNext, pageBack).then(data => {
                            updateTable(data, tbody);
                        });
                    }
                });

            pageBack.addEventListener('click', () => {
                    if (pageable.pageNumber > 0){
                        requestService('chamadas', searchString, pageable.pageNumber-=1, tbody, pageNext, pageBack).then(data => {
                            updateTable(data, tbody);
                        });
                    }
                });
        })

        searchInput.addEventListener('input', () => {
            searchString = searchInput.value;
            requestService('chamadas', searchString, 0).then((data) => {
                let { pageable, totalPages } = data;
                updateTable(data, tbody);

                pageNext.addEventListener('click', () => {
                    if (pageable.pageNumber < totalPages-1){
                        requestService('chamadas', searchString, pageable.pageNumber+=1, tbody).then(data => {
                            updateTable(data, tbody);
                        });
                    }
                });

                pageBack.addEventListener('click', () => {
                    if (pageable.pageNumber > 0){
                        equestService('chamadas', searchString, pageable.pageNumber-=1, tbody).then(data => {
                            updateTable(data, tbody);
                         });
                    }
                });
            })
        })
    }
}

function requestService(tipo, searchString, page) {
        let url = `http://localhost:8080/${tipo}/?titulo=${searchString}&pagina=${page}`;
        console.log(url)
        return new Promise(function(resolve, reject) {
        let xhr = new XMLHttpRequest();
        xhr.onload = function() {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    resolve(JSON.parse(this.responseText));
                }
            }
        }
        xhr.onerror = reject;
        xhr.open('GET', url, true);
        xhr.send();
    })
}

function updateTable(data, tbody) {
    let {content} = data;
    var urlId = '';
    tbody.innerHTML = '';

    if (content.length  == 0) {
        tbody.innerHTML = `<p>Nada encontrado.</p>`
    } else {
        content.map(chamada => {
            urlId = `/chamadas/${chamada.id}`;
            let row = `<tr>
                <td><a href="${urlId}" class="has-text-weight-medium">${chamada.titulo}</a></td>
                <td><span class="${chamada.status !== 'FECHADO' ? 'tag is-spaced is-rounded is-primary' : 'tag is-spaced is-rounded is-black'}">${chamada.status}</span></td>
                <td><strong>${chamada.dataInicio}</strong> até <strong>${chamada.dataTermino}</strong>
                <td>41/50</td>
                <td><a href="${urlId}" class="has-text-weight-medium">Acessar chamada</a></td>
            </tr>`
            tbody.innerHTML += row;
        });
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