"use strict";

function searchChamada() {
  var searchInput = document.querySelector('#input-search');

  if (searchInput) {
    var searchString = '';
    var tbody = document.querySelector('#table-content');
    var pageNext = document.querySelector('.pagination-next');
    var pageBack = document.querySelector('.pagination-previous');
    requestService('chamadas', searchString, 0).then(function (data) {
      var pageable = data.pageable,
          totalPages = data.totalPages;
      updateTable(data, tbody);
      pageNext.addEventListener('click', function () {
        if (pageable.pageNumber < totalPages - 1) {
          requestService('chamadas', searchString, pageable.pageNumber += 1, tbody, pageNext, pageBack).then(function (data) {
            updateTable(data, tbody);
          });
        }
      });
      pageBack.addEventListener('click', function () {
        if (pageable.pageNumber > 0) {
          requestService('chamadas', searchString, pageable.pageNumber -= 1, tbody, pageNext, pageBack).then(function (data) {
            updateTable(data, tbody);
          });
        }
      });
    });
    searchInput.addEventListener('input', function () {
      searchString = searchInput.value;
      requestService('chamadas', searchString, 0).then(function (data) {
        var pageable = data.pageable,
            totalPages = data.totalPages;
        updateTable(data, tbody);
        pageNext.addEventListener('click', function () {
          if (pageable.pageNumber < totalPages - 1) {
            requestService('chamadas', searchString, pageable.pageNumber += 1, tbody).then(function (data) {
              updateTable(data, tbody);
            });
          }
        });
        pageBack.addEventListener('click', function () {
          if (pageable.pageNumber > 0) {
            equestService('chamadas', searchString, pageable.pageNumber -= 1, tbody).then(function (data) {
              updateTable(data, tbody);
            });
          }
        });
      });
    });
  }
}

function requestService(tipo, searchString, page) {
  var url = "http://localhost:8080/".concat(tipo, "/?titulo=").concat(searchString, "&pagina=").concat(page);
  console.log(url);
  return new Promise(function (resolve, reject) {
    var xhr = new XMLHttpRequest();

    xhr.onload = function () {
      if (xhr.readyState == 4) {
        if (xhr.status == 200) {
          resolve(JSON.parse(this.responseText));
        }
      }
    };

    xhr.onerror = reject;
    xhr.open('GET', url, true);
    xhr.send();
  });
}

function formatData(data) {
  var dia = data.slice(8);
  var mes = data.slice(5, 7);
  var ano = data.slice(0, 4);
  return "".concat(dia, "/").concat(mes, "/").concat(ano);
}

function updateTable(data, tbody) {
  var content = data.content;
  var dataInicio = content.dataInicio;
  var dataTermino = content.dataTermino;
  var urlId = '';
  tbody.innerHTML = '';

  if (content.length == 0) {
    tbody.innerHTML = "<p style=\"padding: 20px;\">Nada encontrado.</p>";
  } else {
    content.map(function (chamada) {
      urlId = "/chamadas/".concat(chamada.id);
      var row = "<tr>\n                <td><a href=\"".concat(urlId, "\" class=\"has-text-weight-medium\">").concat(chamada.titulo, "</a></td>\n                <td><span class=\"").concat(chamada.status !== 'FECHADO' ? 'tag is-spaced is-rounded is-primary' : 'tag is-spaced is-rounded is-black', "\">").concat(chamada.status == 'EMANDAMENTO' ? chamada.status.slice(0, 1) + '' + chamada.status.slice(1, 2).toLowerCase() + ' ' + chamada.status.slice(2).toLowerCase() : chamada.status.slice(0, 1) + '' + chamada.status.slice(1).toLowerCase(), "</span></td>\n                <td><strong>").concat(formatData(chamada.dataInicio), "</strong> at\xE9 <strong>").concat(formatData(chamada.dataTermino), "</strong>\n                <td>41/50</td>\n                <td><a href=\"").concat(urlId, "\" class=\"has-text-weight-medium\">Acessar chamada</a></td>\n            </tr>");
      tbody.innerHTML += row;
    });
  }
}

function loadDOM() {
  console.log('Hello Bulma!');
  document.addEventListener('DOMContentLoaded', function () {
    var notification = document.querySelector('[data-notification]');
    var notificationDelete = document.querySelectorAll('.notification .delete');

    if (notification) {
      var notificationbody = document.querySelector('.column .notification').parentNode;
      console.log(notificationbody);
      setTimeout(function () {
        notificationbody.parentNode.removeChild(notificationbody);
      }, 5000);
    }

    if (notificationDelete) {
      (document.querySelectorAll('.notification .delete') || []).forEach(function ($delete) {
        var $notification = $delete.parentNode;
        $delete.addEventListener('click', function () {
          $notification.parentNode.removeChild($notification);
        });
      });
    }
  });
}

function detailsOption() {
  var botaoOpcao = document.querySelector('.detalhes-opcoes-botao');

  if (botaoOpcao) {
    botaoOpcao.addEventListener('click', function () {
      var bodyOptions = document.querySelector('.detalhes-opcoes-body');
      bodyOptions.style.display == 'block' ? bodyOptions.style.display = 'none' : bodyOptions.style.display = 'block';
    });
  }
}

function cadastrarParticipante() {
  var currentTab = 0;
  showTab(currentTab);
  document.querySelector(".form-navigation-next").addEventListener("click", function () {
    return nextPrev(1);
  });
  document.querySelector(".form-navigation-back").addEventListener("click", function () {
    return nextPrev(-1);
  });

  function showTab(n) {
    var x = document.getElementsByClassName("tab");
    x[n].style.display = "block";

    if (n == 0) {
      document.querySelector(".form-navigation-back").style.visibility = "hidden";
    } else {
      document.querySelector(".form-navigation-back").style.visibility = "visible";
    }

    if (n == x.length - 1) {
      document.querySelector(".form-navigation-next").innerHTML = "Finalizar";
    } else {
      document.querySelector(".form-navigation-next").innerHTML = "Próximo";
    }

    fixStepIndicator(n);
  }

  function nextPrev(n) {
    var x = document.getElementsByClassName("tab");
    x[currentTab].style.display = "none";
    currentTab = currentTab + n;

    if (currentTab >= x.length) {
      document.getElementById("regForm").submit();
      return false;
    }

    showTab(currentTab);
  }

  function fixStepIndicator(n) {
    var i,
        x = document.getElementsByClassName("step-info-section");

    for (i = 0; i < x.length; i++) {
      if (i > n) {
        x[i].classList.remove("step-info-checked");
      } else if (i < n) {
        x[i].classList.add("step-info-checked");
      }
    }

    x[n].classList.add("step-info-checked");
  }
}

function main() {
  loadDOM();
  searchChamada();
  detailsOption();
  cadastrarParticipante();
}

main();